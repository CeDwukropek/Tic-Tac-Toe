package com.example.tictactoe_;

import javafx.event.ActionEvent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;

import java.io.IOException;

public class MenuWindow {
    private Stage stage;

    public void gameWindow(ActionEvent event, boolean bot) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("gameWindow.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 600, 600);
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        stage.setTitle("Second Window");
        stage.setScene(scene);
        stage.show();
    }
}
