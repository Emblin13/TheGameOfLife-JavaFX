module com.example.thegameoflife {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.thegameoflife to javafx.fxml;
    exports com.example.thegameoflife;
}