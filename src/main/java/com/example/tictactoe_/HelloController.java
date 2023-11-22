package com.example.tictactoe_;

import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import java.net.URL;
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
    @FXML
    protected Pane stackedPane;
    @FXML
    protected Label output;

    protected boolean turn = true;
    protected int[][] tab;

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
            btn.getStyleClass().add("circle");

            this.turn = !this.turn;
            BtnData coordinates = (BtnData) btn.getUserData();
            this.tab[coordinates.x][coordinates.y] = v.equals("O") ? 1 : -1;

            StringBuilder s;
            for (int i = 0; i < 3; i++)
            {
                s = new StringBuilder();
                for (int z = 0; z < 3; z++)
                {
                    s.append("[");
                    s.append(tab[i][z]).append(", ");
                    s.append("]");
                }
                System.out.println(s);

            }
            System.out.println(" ");

            int res = checkWin();

            if(res == 1 || res == -1) {
                System.out.println(v + " win");
                stackedPane.setVisible(true);
                output.setText(v + " win");
            } else if (res == 2) {
                System.out.println("Draw");
                stackedPane.setVisible(true);
                output.setText("Draw");
            }
        }
    }

    public void exit(Event e) {
        ((Stage)((Button)e.getSource()).getScene().getWindow()).close();
    }

    public void playAgain() {
        this.tab = new int[][]{
                {0, 0, 0},
                {0, 0, 0},
                {0, 0, 0}
        };

        top_left.setText("");
        top_center.setText("");
        top_right.setText("");
        mid_left.setText("");
        mid_center.setText("");
        mid_right.setText("");
        bottom_left.setText("");
        bottom_center.setText("");
        bottom_right.setText("");

        stackedPane.setVisible(false);
    }

    int checkWin() {
        if (this.tab[0][0] == 1 && this.tab[0][1] == 1 && this.tab[0][2] == 1) return 1;
        if (this.tab[0][0] == -1 && this.tab[0][1] == -1 && this.tab[0][2] == -1) return -1;
        if (this.tab[1][0] == 1 && this.tab[1][1] == 1 && this.tab[1][2] == 1) return 1;
        if (this.tab[1][0] == -1 && this.tab[1][1] == -1 && this.tab[1][2] == -1) return -1;
        if (this.tab[2][0] == 1 && this.tab[2][1] == 1 && this.tab[2][2] == 1) return 1;
        if (this.tab[2][0] == -1 && this.tab[2][1] == -1 && this.tab[2][2] == -1) return -1;

        if (this.tab[0][0] == 1 && this.tab[1][0] == 1 && this.tab[2][0] == 1) return 1;
        if (this.tab[0][0] == -1 && this.tab[1][0] == -1 && this.tab[2][0] == -1) return -1;
        if (this.tab[0][1] == 1 && this.tab[1][1] == 1 && this.tab[2][1] == 1) return 1;
        if (this.tab[0][1] == -1 && this.tab[1][1] == -1 && this.tab[2][1] == -1) return -1;
        if (this.tab[0][2] == 1 && this.tab[1][2] == 1 && this.tab[2][2] == 1) return 1;
        if (this.tab[0][2] == -1 && this.tab[1][2] == -1 && this.tab[2][2] == -1) return -1;

        if (this.tab[0][0] == 1 && this.tab[1][1] == 1 && this.tab[2][2] == 1) return 1;
        if (this.tab[0][0] == -1 && this.tab[1][1] == -1 && this.tab[2][2] == -1) return 1;
        if (this.tab[2][0] == 1 && this.tab[1][1] == 1 && this.tab[0][2] == 1) return 1;
        if (this.tab[2][0] == -1 && this.tab[1][1] == -1 && this.tab[0][2] == -1) return 1;

        boolean flag = true;

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (tab[i][j] == 0) {
                    flag = false;
                    break;
                }
            }
        }

        System.out.println(flag);

        if (!flag) return 0;
        return 2;
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        this.tab = new int[][]{
                {0, 0, 0},
                {0, 0, 0},
                {0, 0, 0}
        };

        top_left.setUserData(new BtnData(0, 0));
        top_center.setUserData(new BtnData(0, 1));
        top_right.setUserData(new BtnData(0, 2));
        mid_left.setUserData(new BtnData(1, 0));
        mid_center.setUserData(new BtnData(1, 1));
        mid_right.setUserData(new BtnData(1, 2));
        bottom_left.setUserData(new BtnData(2, 0));
        bottom_center.setUserData(new BtnData(2, 1));
        bottom_right.setUserData(new BtnData(2, 2));

        stackedPane.setVisible(false);
    }
}