module com.example.morpion {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;

    opens com.example.morpion to javafx.fxml;
    exports com.example.morpion;
}