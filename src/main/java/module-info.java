module org.ntnu.andershc.miniproject {
    requires javafx.controls;
    requires javafx.fxml;

    opens org.ntnu.andershc.miniproject.model to javafx.fxml,java.base,javafx.graphics;
    opens org.ntnu.andershc.miniproject.controllers to javafx.fxml,java.base,javafx.graphics;

    exports org.ntnu.andershc.miniproject;
    exports org.ntnu.andershc.miniproject.model;
    exports org.ntnu.andershc.miniproject.controllers;
}