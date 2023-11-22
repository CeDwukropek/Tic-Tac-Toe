package com.example.tictactoe_;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class HelloApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("hello-view.fxml"));
<<<<<<< Updated upstream
        Scene scene = new Scene(fxmlLoader.load(), 320, 240);
=======
        Scene scene = new Scene(fxmlLoader.load(), 600, 600);

        stage.setResizable(false);
>>>>>>> Stashed changes
        stage.setTitle("Hello!");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}