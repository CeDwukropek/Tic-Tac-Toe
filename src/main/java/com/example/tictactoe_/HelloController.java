package com.example.tictactoe_;

import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Control;
import javafx.scene.control.Label;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.EventListener;

public class HelloController {
    @FXML
    private Label welcomeText;
    @FXML
    private Button buttonTest;
    protected boolean turn = true;
    protected int[][] tab;

    public HelloController() {
        this.tab = new int[][]{
                {-1, -1, -1},
                {-1, -1, -1},
                {-1, -1, -1}};
    }

    @FXML
    protected void buttonEvent(Event e) {
        if(this.turn) {
            move((Button)e.getSource(), "O");
        } else {
            move((Button)e.getSource(), "X");
        }

        System.out.println(
                ((Control)e.getSource()).getId()
        );
    }

    public void move(Button btn, String v) {
        if(btn.getText().equals("X") || btn.getText().equals("O")) return;
        if(btn.getText().isEmpty()) {
            btn.setText(v);
            this.turn = !this.turn;
            // btn.setUserData() i btn.getUserData() !
        }
    }
}