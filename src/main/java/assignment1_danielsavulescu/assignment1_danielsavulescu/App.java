package assignment1_danielsavulescu.assignment1_danielsavulescu;

import java.util.HashMap;
import java.util.Map;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.input.KeyCode;
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