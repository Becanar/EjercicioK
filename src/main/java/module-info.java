module com.example.ejerciciok {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.ejerciciok to javafx.fxml;
    exports com.example.ejerciciok;
}