module org.example.kandopeldacalloutjavafx {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.kordamp.bootstrapfx.core;

    opens org.example.kandopeldacalloutjavafx to javafx.fxml;
    exports org.example.kandopeldacalloutjavafx;
}