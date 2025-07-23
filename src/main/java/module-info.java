module org.example.kandopeldacalloutjavafx {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.kordamp.bootstrapfx.core;
    requires junit;
    requires java.xml;

    opens org.example.kandopeldacalloutjavafx to javafx.fxml;
    exports org.example.kandopeldacalloutjavafx;
}