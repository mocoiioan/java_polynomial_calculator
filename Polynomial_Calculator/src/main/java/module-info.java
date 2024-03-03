module com.example.assignment1 {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.assignment1 to javafx.fxml;
    exports com.example.assignment1;
    exports com.example.assignment1.gui;
    opens com.example.assignment1.gui to javafx.fxml;
    exports com.example.assignment1.data;
    opens com.example.assignment1.data to javafx.fxml;
    exports com.example.assignment1.logic;
    opens com.example.assignment1.logic to javafx.fxml;
}