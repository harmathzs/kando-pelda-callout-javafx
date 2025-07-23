package org.example.kandopeldacalloutjavafx;

import org.junit.Assert;
import org.junit.Test;

import java.io.IOException;

public class GroqTest {
    @Test
    public void testBehavior() throws IOException {
        String responseJson = GroqService.getResponseJson("How to tie a tie?");
        Assert.assertNotNull(responseJson);

        String answer = GroqService.parseAnswer(responseJson);
        Assert.assertNotNull(answer);
    }
}
