module org.ntnu.andershc.miniproject {
    requires javafx.controls;
    requires javafx.fxml;

    opens org.ntnu.andershc.miniproject to javafx.fxml;
    exports org.ntnu.andershc.miniproject;
}