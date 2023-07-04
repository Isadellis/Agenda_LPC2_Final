module com {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.principal_agenda to javafx.fxml;
    exports com.principal_agenda;
    opens com.controllers to javafx.fxml;
    exports com.controllers;
}