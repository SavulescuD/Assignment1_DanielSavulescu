/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package lab03_danielsavulescu.assignment1_danielsavulescu;

import javafx.scene.control.Button;
import javafx.scene.input.KeyCode;

/**
 *
 * @author Daniel Savulescu
 */
public class Key {
    private final Button button;
    private final KeyCode keyCode;

    public Key(Button button, KeyCode keyCode) {
        this.button = button;
        this.keyCode = keyCode;
    }

    public Button getButton() {
        return button;
    }

    public KeyCode getKeyCode() {
        return keyCode;
    }
}
