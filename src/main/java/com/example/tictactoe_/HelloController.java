package com.example.tictactoe_;

import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Control;
import javafx.scene.control.Label;
import javafx.stage.Stage;

import java.lang.reflect.Array;
import java.net.URL;
import java.util.ArrayList;
import java.util.EventListener;
import java.util.ResourceBundle;

public class HelloController implements Initializable {
    @FXML
    protected Button top_left;
    @FXML
    protected Button top_center;
    @FXML
    protected Button top_right;
    @FXML
    protected Button mid_left;
    @FXML
    protected Button mid_center;
    @FXML
    protected Button mid_right;
    @FXML
    protected Button bottom_left;
    @FXML
    protected Button bottom_center;
    @FXML
    protected Button bottom_right;
    protected boolean turn = true;
    protected boolean[][] tab;

    @FXML
    protected void buttonEvent(Event e) {
        if(this.turn) {
            move((Button)e.getSource(), "O");
        } else {
            move((Button)e.getSource(), "X");
        }
    }

    public void move(Button btn, String v) {
        if(btn.getText().equals("X") || btn.getText().equals("O")) return;
        if(btn.getText().isEmpty()) {
            btn.setText(v);
            this.turn = !this.turn;
            BtnData cooridnates = (BtnData) btn.getUserData();
            this.tab[cooridnates.x][cooridnates.y] = v.equals("O") ? true : false;

            StringBuilder s;
            for (int i = 0; i < 3; i++)
            {
                s = new StringBuilder();
                for (int z = 0; z < 3; z++)
                {
                    s.append(tab[i][z]);
                }
                System.out.println(s);
            }

            if(checkWin()) {
                System.out.println(v + " win");
                ((Stage) btn.getScene().getWindow()).close();
            }
        }
    }

    boolean checkWin() {
        if (this.tab[0][0] && this.tab[0][1] && this.tab[0][2]) return true;
        if (!this.tab[0][0] && !this.tab[0][1] && !this.tab[0][2]) return false;

        return false;
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        this.tab = new boolean[][]{
                {Boolean.parseBoolean(null), Boolean.parseBoolean(null), Boolean.parseBoolean(null)},
                {Boolean.parseBoolean(null), Boolean.parseBoolean(null), Boolean.parseBoolean(null)},
                {Boolean.parseBoolean(null), Boolean.parseBoolean(null), Boolean.parseBoolean(null)}};

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
}