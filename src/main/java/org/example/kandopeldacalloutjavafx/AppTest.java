package org.example.kandopeldacalloutjavafx;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;

public class AppTest {
    @Before
    public void testBefore() {
        HelloApplication.isRunningTest = true;
        HelloController.isRunningTest = true;
    }

    @After
    public void testAfter() {
        HelloController.isRunningTest = false;
        HelloApplication.isRunningTest = false;
    }

    @Test
    public void testController() throws IOException {
        HelloController controller = new HelloController();
        controller.onHelloButtonClick();
    }

    @Test
    public void testApplication() {
        HelloApplication.main(null);
    }
}
