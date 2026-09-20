package assignment1_danielsavulescu.assignment1_danielsavulescu;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javafx.application.Application;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

/**
 * JavaFX App
 */
public class App extends Application {

    private Map<KeyCode, Key> keyMap = new HashMap<>();
    private GridPane keyboardGrid = new GridPane();
    private TextField toTypeTextField = new TextField();
    private TextField typedTextField = new TextField();
    private StringBuilder sb = new StringBuilder();
    private Label valid = new Label();

    @Override
    public void start(Stage stage) {
        var root = new BorderPane();
        root.setCenter(keyboardGrid);
        var vbox = new VBox(10, toTypeTextField, typedTextField);
        root.setTop(vbox);
        vbox.setAlignment(Pos.CENTER);
        toTypeTextField.setText("Test");
        root.setBottom(valid);
        valid.setAlignment(Pos.CENTER);
        valid.setScaleX(2);
        valid.setScaleX(2);
        keyboardGrid.setAlignment(Pos.CENTER);
        keyboardGrid.setHgap(4);
        keyboardGrid.setVgap(4);
        keyboardGrid.setPadding(new Insets(80, 10, 10, 10));
        keyboardGrid.setScaleX(4);
        keyboardGrid.setScaleY(4);

        //Adding the digits row
        addKey("1", KeyCode.DIGIT1, 0, 0);
        GridPane.setHalignment(keyMap.get(KeyCode.DIGIT1).getButton(), HPos.RIGHT);
        addKey("2", KeyCode.DIGIT2, 1, 0);
        addKey("3", KeyCode.DIGIT3, 2, 0);
        addKey("4", KeyCode.DIGIT4, 3, 0);
        addKey("5", KeyCode.DIGIT5, 4, 0);
        addKey("6", KeyCode.DIGIT6, 5, 0);
        addKey("7", KeyCode.DIGIT7, 6, 0);
        addKey("8", KeyCode.DIGIT8, 7, 0);
        addKey("9", KeyCode.DIGIT9, 8, 0);
        addKey("0", KeyCode.DIGIT0, 9, 0);
        addKey("←", KeyCode.BACK_SPACE, 10, 0);

        //Adding the first row of letters
        addKey("Q", KeyCode.Q, 0, 1);
        GridPane.setHalignment(keyMap.get(KeyCode.Q).getButton(), HPos.RIGHT);
        addKey("W", KeyCode.W, 1, 1);
        addKey("E", KeyCode.E, 2, 1);
        addKey("R", KeyCode.R, 3, 1);
        addKey("T", KeyCode.T, 4, 1);
        addKey("Y", KeyCode.Y, 5, 1);
        addKey("U", KeyCode.U, 6, 1);
        addKey("I", KeyCode.I, 7, 1);
        addKey("O", KeyCode.O, 8, 1);
        addKey("P", KeyCode.P, 9, 1);

        //Adding the second row of letters
        addKey("A", KeyCode.A, 0, 2);
        GridPane.setHalignment(keyMap.get(KeyCode.A).getButton(), HPos.RIGHT);
        addKey("S", KeyCode.S, 1, 2);
        addKey("D", KeyCode.D, 2, 2);
        addKey("F", KeyCode.F, 3, 2);
        addKey("G", KeyCode.G, 4, 2);
        addKey("H", KeyCode.H, 5, 2);
        addKey("J", KeyCode.J, 6, 2);
        addKey("K", KeyCode.K, 7, 2);
        addKey("L", KeyCode.L, 8, 2);

        //Adding the third row of letters
        addKey("SHIFT", KeyCode.SHIFT, 0, 3);
        addKey("Z", KeyCode.Z, 1, 3);
        addKey("X", KeyCode.X, 2, 3);
        addKey("C", KeyCode.C, 3, 3);
        addKey("V", KeyCode.V, 4, 3);
        addKey("B", KeyCode.B, 5, 3);
        addKey("N", KeyCode.N, 6, 3);
        addKey("M", KeyCode.M, 7, 3);
        addKey(",", KeyCode.COMMA, 8, 3);
        addKey(".", KeyCode.PERIOD, 9, 3);
        
        Scene scene = new Scene(root, 1920, 1080);
        stage.setScene(scene);

        scene.setOnKeyPressed(event -> keyPressed(event));
        scene.setOnKeyReleased(event -> keyReleased(event));

        stage.setTitle("KeyBoard");
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }

    /**
     * adds a key to the map and the button for grid pane for the keyboard
     *
     * @param label the label of the button
     * @param keyCode the key code of the button
     * @param col the colon of the button
     * @param row
     */
    public void addKey(String label, KeyCode keyCode, int col, int row) {
        Button button = new Button(label);
        button.setStyle(
                "-fx-background-color: #DE8A52;"
                + "-fx-border-color: #DE5260;"
                + "-fx-border-radius: 8;"
                + "-fx-background-radius: 8;"
                + "-fx-border-width: 2"
        );
        
        Key key = new Key(button, keyCode);
        keyMap.put(keyCode, key);
        keyboardGrid.add(button, col, row);
        GridPane.setHalignment(button, HPos.CENTER);
    }

    /**
     * handles the animation when a key is pressed
     *
     * @param event the event when a key is pressed
     */
    public void keyPressed(KeyEvent event) {
        KeyCode keyCode = event.getCode();
        Key key = keyMap.get(keyCode);

        if (key != null) {
            key.buttonPressed(true);
        } else {
            valid.setText("Not Handled");
            valid.setTextFill(Color.RED);
        }
        
        if (keyCode == KeyCode.BACK_SPACE) {
            if (sb.length() > 0) {
                sb.deleteCharAt(sb.length() - 1);
            }
        } else {
            String typed = event.getText();
            if (typed != null && !typed.isEmpty()) {
                sb.append(typed);
            }
        }
        
        typedTextField.setText(sb.toString());
    }

    /**
     * handles the animation when a key is released
     *
     * @param event the event when a key is released
     */
    public void keyReleased(KeyEvent event) {
        KeyCode keyCode = event.getCode();
        Key key = keyMap.get(keyCode);

        if (key != null) {
            key.buttonPressed(false);
        } else {
            valid.setText("");
            valid.setTextFill(Color.BLACK);
        }
    }
}
