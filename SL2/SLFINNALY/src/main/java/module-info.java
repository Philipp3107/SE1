module com.example.slfinnaly {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.logging;

    requires org.controlsfx.controls;
    requires org.kordamp.bootstrapfx.core;

    opens com.example.slfinnaly to javafx.fxml;
    exports com.example.slfinnaly;
    exports com.example.slfinnaly.View;
    opens com.example.slfinnaly.View to javafx.fxml;
    exports com.example.slfinnaly.Controller;
    opens com.example.slfinnaly.Controller to javafx.fxml;
    exports com.example.slfinnaly.Model;
    opens com.example.slfinnaly.Model to javafx.fxml;
}
