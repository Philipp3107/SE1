module com.example.test_for_sl {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;
    requires org.kordamp.bootstrapfx.core;

    opens com.example.test_for_sl to javafx.fxml;
    exports com.example.test_for_sl;
}