package assignment1_danielsavulescu.assignment1_danielsavulescu;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

/**
 * JavaFX App
 */
public class App extends Application {

    private Map<KeyCode, Key> keyMap = new HashMap<>();
    private GridPane keyboardGrid = new GridPane();

    @Override
    public void start(Stage stage) {
        var root = new BorderPane();
        root.setCenter(keyboardGrid);
        
        //Adding the digits row
        addKey("1", KeyCode.DIGIT1, 0, 0);
        addKey("2", KeyCode.DIGIT2, 1, 0);
        addKey("3", KeyCode.DIGIT3, 2, 0);
        addKey("4", KeyCode.DIGIT4, 3, 0);
        addKey("5", KeyCode.DIGIT5, 4, 0);
        addKey("6", KeyCode.DIGIT6, 5, 0);
        addKey("7", KeyCode.DIGIT7, 6, 0);
        addKey("8", KeyCode.DIGIT8, 7, 0);
        addKey("9", KeyCode.DIGIT9, 8, 0);
        addKey("0", KeyCode.DIGIT0, 9, 0);
        
        //Adding the first row of letters
        addKey("Q", KeyCode.Q, 0, 1);
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
        
        Scene scene = new Scene(root, 400, 800);
        stage.setScene(scene);
        stage.setTitle("KeyBoard");
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }

    public void addKey(String label, KeyCode keyCode, int col, int row) {
        Button button = new Button(label);
        Key key = new Key(button, keyCode);
        keyMap.put(keyCode, key);
        keyboardGrid.add(button, col, row);
    }
}
