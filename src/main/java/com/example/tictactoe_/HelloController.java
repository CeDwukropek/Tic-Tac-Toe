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
    protected Button top_left;
    protected Button top_center;
    protected Button top_right;
    protected Button mid_left;
    protected Button mid_center;
    protected Button mid_right;
    protected Button bottom_left;
    protected Button bottom_center;
    protected Button bottom_right;
    protected boolean turn = true;
    protected int[][] tab;

    public HelloController() {
        this.tab = new int[][]{
                {-1, -1, -1},
                {-1, -1, -1},
                {-1, -1, -1}};

        top_left.setUserData(new BtnData(0, 0));
        top_center.setUserData(new BtnData(0, 1));
        top_right.setUserData(new BtnData(0, 2));
        mid_left.setUserData(new BtnData(1, 0));
        mid_center.setUserData(new BtnData(1, 1));
        mid_right.setUserData(new BtnData(1, 2));
        bottom_left.setUserData(new BtnData(2, 0));
        bottom_center.setUserData(new BtnData(2, 1));
        bottom_right.setUserData(new BtnData(2, 2));
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