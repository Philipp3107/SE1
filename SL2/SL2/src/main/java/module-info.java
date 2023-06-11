module com.example.sl2 {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;
    requires org.kordamp.bootstrapfx.core;

    opens com.example.sl2 to javafx.fxml;
    exports com.example.sl2;
    exports com.example.sl2.View;
    opens com.example.sl2.View to javafx.fxml;
    exports com.example.sl2.Model;
    opens com.example.sl2.Model to javafx.fxml;
}