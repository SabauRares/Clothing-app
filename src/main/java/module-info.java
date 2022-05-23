module com.example.clothingapp {
    requires javafx.controls;
    requires javafx.fxml;
    requires com.fasterxml.jackson.databind;
    requires org.json;


    opens com.example.clothingapp to javafx.fxml;
    exports com.example.clothingapp;
    exports com.example.clothingapp.exceptions;
    exports com.example.clothingapp.servicies;
    exports com.example.clothingapp.user;
}