package com.example.tictactoe_;

import javafx.event.ActionEvent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ColorPicker;
import javafx.stage.Stage;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.paint.Color;

import java.io.IOException;

public class MenuWindow {
    private Stage stage;
    public static boolean bot;
    public static String buttonColor;
    public ColorPicker colorPicker;

    public void gameWindow(ActionEvent event) throws IOException {
        MenuWindow.bot = ((Button)event.getSource()).getId().equals("True");
        MenuWindow.buttonColor = toHexString(colorPicker.getValue());
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("gameWindow.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        stage.setTitle("Second Window");
        stage.setScene(scene);
        stage.show();
    }
    private String toHexString(Color color) {
        int r = ((int) Math.round(color.getRed()     * 255)) << 24;
        int g = ((int) Math.round(color.getGreen()   * 255)) << 16;
        int b = ((int) Math.round(color.getBlue()    * 255)) << 8;
        int a = ((int) Math.round(color.getOpacity() * 255));

        return String.format("#%08X", (r + g + b + a));
    }
}
