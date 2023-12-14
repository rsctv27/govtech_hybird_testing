package web.steps;

import web.TestFactory;
import io.cucumber.java.After;
import io.cucumber.java.Before;

import java.io.IOException;

public class Hooks extends TestFactory {

    @Before(order=0)
    public void before() throws IOException {
        setup();
    }

    @After(order=0)
    public void After() {
        quit();
    }

}
