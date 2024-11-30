module ru.guu.lab17 {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;


    opens ru.guu.lab17 to javafx.fxml;
    exports ru.guu.lab17;
}