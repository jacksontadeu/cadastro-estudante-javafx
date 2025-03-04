module com.jtmjinfo.crudestudantes {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.desktop;
    requires java.sql;


    opens com.jtmjinfo.crudestudantes to javafx.fxml;
    opens com.jtmjinfo.crudestudantes.controller to javafx.fxml;
    opens com.jtmjinfo.crudestudantes.model to javafx.base;
    exports com.jtmjinfo.crudestudantes;
}