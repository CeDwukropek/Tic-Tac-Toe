module com.example.tictactoe_ {
    requires javafx.controls;
    requires javafx.fxml;

    requires com.dlsc.formsfx;

    opens com.example.tictactoe_ to javafx.fxml;
    exports com.example.tictactoe_;
}