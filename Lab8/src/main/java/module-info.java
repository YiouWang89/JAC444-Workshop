module lab8.lab8 {
    requires javafx.controls;
    requires javafx.fxml;


    opens lab8.lab8 to javafx.fxml;
    exports lab8.lab8;
}