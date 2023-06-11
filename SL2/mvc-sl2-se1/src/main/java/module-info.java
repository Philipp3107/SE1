module com.example.mvcsl2se1 {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;
    requires org.kordamp.bootstrapfx.core;

    opens com.example.mvcsl2se1 to javafx.fxml;
    exports com.example.mvcsl2se1;
}