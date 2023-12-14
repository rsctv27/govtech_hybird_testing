package web;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class DriverFactory {
    static WebDriver webDriver;
    static InputStream inputStream;
    static String host;
    static String browser;
    static String browser_version;
    static Properties prop = new Properties();

    public static WebDriver createDriver () throws IOException {
        String propFileName = "env.properties";
        inputStream = DriverFactory.class.getClassLoader().getResourceAsStream(propFileName);

        if (inputStream != null) {
            prop.load(inputStream);
            host = prop.getProperty("host");
            browser = prop.getProperty("browser");
            browser_version = prop.getProperty("browser_version");
        }
        else {
            throw new FileNotFoundException("property file '" + propFileName + "' not found in the classpath");
        }

        if (browser.equals("chrome")) {
            WebDriverManager.chromedriver().setup();
            ChromeOptions chromeOptions = new ChromeOptions();
            chromeOptions.addArguments(
                    "--disable-gpu",
                    "--window-size=1920,1200",
                    "--ignore-certificate-errors",
                    "--disable-extensions",
                    "--no-sandbox",
                    "--disable-dev-shm-usage"
            );
            webDriver = new ChromeDriver(chromeOptions);
        }

        else if (browser.equals("firefox")) {
            WebDriverManager.firefoxdriver().setup();
            FirefoxOptions firefoxOptions = new FirefoxOptions();
            firefoxOptions.addPreference("dom.webdriver.enabled", false);
            firefoxOptions.addPreference("dom.webnotifications.enabled", false);
            firefoxOptions.addPreference("dom.push.enabled", false);
            firefoxOptions.setAcceptInsecureCerts(true);
            webDriver = new FirefoxDriver(firefoxOptions);
        }
        return webDriver;
    }

    public static void quitDriver() {
        if (webDriver != null) {
            webDriver.quit();
        }
    }

    public static WebDriver getWebDriver() {
        return webDriver;
    }
}
