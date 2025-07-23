package org.example.kandopeldacalloutjavafx;

import org.junit.Assert;
import org.junit.Test;

public class GroqTest {
    @Test
    public void testBehavior() {
        String responseJson = GroqService.getResponseJson("How to tie a tie?");
        Assert.assertNotNull(responseJson);

        String answer = GroqService.parseAnswer(responseJson);
        Assert.assertNotNull(answer);
    }
}
