module com.example.se1sl {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;
    requires org.kordamp.bootstrapfx.core;

    opens com.example.se1sl to javafx.fxml;
    exports com.example.se1sl;
}