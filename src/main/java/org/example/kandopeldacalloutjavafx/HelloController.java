package org.example.kandopeldacalloutjavafx;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;

import java.io.IOException;

public class HelloController {
    @FXML public TextArea questionTextArea;
    @FXML public TextArea answerTextArea;

    @FXML
    private Label welcomeText;

    @FXML
    protected void onHelloButtonClick() throws IOException {
        String question = questionTextArea.getText();
        String responseJson = GroqService.getResponseJson(question);
        String answer = GroqService.parseAnswer(responseJson);
        answerTextArea.setText(answer);
    }
}