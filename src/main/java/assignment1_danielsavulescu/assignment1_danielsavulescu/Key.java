package assignment1_danielsavulescu.assignment1_danielsavulescu;

import javafx.scene.control.Button;
import javafx.scene.input.KeyCode;

/**
 *
 * @author Daniel Savulescu
 */
public class Key {

    private final Button button;
    private final KeyCode keyCode;
    private final String defaultStyle;

    public Key(Button button, KeyCode keyCode) {
        this.button = button;
        this.keyCode = keyCode;
        this.defaultStyle = button.getStyle();
    }

    public Button getButton() {
        return button;
    }

    public KeyCode getKeyCode() {
        return keyCode;
    }

    /**
     * changes animation for when the key is pressed
     *
     * @param button the button to be animated
     */
    public void buttonPressed(boolean pressed) {
        if (pressed) {
            button.setStyle(
                    "-fx-background-color: #52A6DE;"
                    + "-fx-border-color: #DE5260;"
                    + "-fx-border-radius: 8;"
                    + "-fx-background-radius: 8;"
                    + "-fx-border-width: 2"
            );

        } else {
            button.setStyle(defaultStyle);
        }
    }
}
