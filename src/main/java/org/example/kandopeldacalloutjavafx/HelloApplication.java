package org.example.kandopeldacalloutjavafx;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

import org.kordamp.bootstrapfx.BootstrapFX;

public class HelloApplication extends Application {
    public static boolean isRunningTest = false;

    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = null;
        if (!isRunningTest) fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("hello-view.fxml"));
        Scene scene = null;
        if (!isRunningTest) scene = new Scene(fxmlLoader.load(), 800, 600);
        if (!isRunningTest) scene.getStylesheets().add(BootstrapFX.bootstrapFXStylesheet());
        if (!isRunningTest) stage.setTitle("Hello!");
        if (!isRunningTest) stage.setScene(scene);
        if (!isRunningTest) stage.show();
        if (isRunningTest) Platform.exit();
    }

    public static void main(String[] args) {
        launch();
    }
}