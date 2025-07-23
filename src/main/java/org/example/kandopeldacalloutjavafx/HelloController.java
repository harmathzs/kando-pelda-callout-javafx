package org.example.kandopeldacalloutjavafx;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;

public class HelloController {
    @FXML public TextArea questionTextArea;
    @FXML public TextArea answerTextArea;

    @FXML
    private Label welcomeText;

    @FXML
    protected void onHelloButtonClick() {
        String question = questionTextArea.getText();
        String answer = "TODO";
        answerTextArea.setText(answer);
    }
}