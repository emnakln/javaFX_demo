module javafx_demo.javafx_demo {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;
    requires org.kordamp.bootstrapfx.core;
    requires java.desktop;

    opens javafx_demo.javafx_demo to javafx.fxml;
    exports javafx_demo.javafx_demo;
}