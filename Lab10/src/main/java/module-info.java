module chatapp.lab10 {
    requires javafx.controls;
    requires javafx.fxml;


    opens chatapp.lab10 to javafx.fxml;
    exports chatapp.lab10;
}