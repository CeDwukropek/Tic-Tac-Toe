package com.example.tictactoe_;

import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collections;
import java.util.ResourceBundle;
import java.util.Random;

public class GameWindow implements Initializable {
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
    Button[] btnTab;
    ArrayList<Button> btnTab_copy = new ArrayList<>();
    protected int[][] tab;
    private Stage stage;
    protected Random rand = new Random();
    protected int win;

    @FXML
    protected void buttonEvent(Event e) {
        if(this.turn) {
            if(((Button)e.getSource()).getText().equals("X") || ((Button)e.getSource()).getText().equals("O")) return;

            move((Button)e.getSource(), "O");
            btnTab_copy.remove((Button)e.getSource());
            if(MenuWindow.bot && win == 0) {
                int random = rand.nextInt(btnTab_copy.size());
                move(btnTab_copy.get(random), "X");
                btnTab_copy.remove(random);
            }
        } else {
            move((Button)e.getSource(), "X");
        }
    }

    public void move(Button btn, String v) {
        if(btn.getText().isEmpty()) {
            btn.setText(v);
            btn.getStyleClass().add(v.equals("O") ? "circle" : "cross");

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
            }

            win = checkWin();

            if(win == 1 || win == -1) {
                stackedPane.setVisible(true);
                output.setText(v + " win");
            } else if (win == 2) {
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

        for (Button x : btnTab) {
            x.setText("");
            x.getStyleClass().remove("circle");
            x.getStyleClass().remove("cross");
        }


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

        if (!flag) return 0;
        return 2;
    }

    public void menuWindow(ActionEvent event) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("menuWindow.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        stage.setTitle("Game");
        stage.setScene(scene);
        stage.show();
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        this.tab = new int[][]{
                {0, 0, 0},
                {0, 0, 0},
                {0, 0, 0}
        };

        this.btnTab = new Button[]{
                top_left,
                top_center,
                top_right,
                mid_left,
                mid_center,
                mid_right,
                bottom_left,
                bottom_center,
                bottom_right};

        this.btnTab_copy = new ArrayList<>();

        Collections.addAll(btnTab_copy, btnTab);

        int id = 0;

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                btnTab[id].setUserData(new BtnData(i, j));
                id++;
            }
        }

        for (Button btn : btnTab) {
            String style = String.format("-fx-background-color: %s;", MenuWindow.buttonColor);
            btn.setStyle(style);
        }

        stackedPane.setVisible(false);
    }
}