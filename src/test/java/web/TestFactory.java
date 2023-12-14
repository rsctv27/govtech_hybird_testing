package web;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class TestFactory {

    protected static GovtechFactory govtech;

    public void setup() throws IOException {
        DriverFactory.createDriver();
        govtech = new GovtechFactory(DriverFactory.getWebDriver());
        DriverFactory.getWebDriver().manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        DriverFactory.getWebDriver().manage().window().maximize();
    }

    public void quit() {
        DriverFactory.quitDriver();
    }
}
