package com.bibhu.java.cucumber.bdd.driver;

import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

import java.io.FileInputStream;
import java.util.Properties;

public class DriverFactory {

    private static final String USER_DIR = System.getProperty("user.dir");
    private static final String DRIVER_LOCATION = "/src/main/java/com/bibhu/java/cucumber/bdd/driver/drivers/";
    private static final String CONFIG_FILE_LOCATION = "/src/main/java/properties/config.properties";
    private static final ThreadLocal<WebDriver> webDriver = new ThreadLocal<>();

    private static String getBrowserType() {
        String browserType = null;
        Properties properties = new Properties();
        try {
            FileInputStream file = new FileInputStream(USER_DIR + CONFIG_FILE_LOCATION);
            properties.load(file);
            browserType = properties.getProperty("browser-type").toLowerCase().trim();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return browserType;
    }

    public static WebDriver getWebDriver() {
        if (webDriver.get() == null) {
            webDriver.set(createWebDriver());
        }
        return webDriver.get();
    }

    private static WebDriver createWebDriver() {
        WebDriver driver = null;
        String browserType = getBrowserType();
        switch (browserType.toLowerCase()) {
            case "edge" -> {
                System.setProperty("webdriver.edge.driver", USER_DIR + DRIVER_LOCATION + "msedgedriver.exe");
                EdgeOptions edgeOptions = new EdgeOptions();
                edgeOptions.setPageLoadStrategy(PageLoadStrategy.NORMAL);
                driver = new EdgeDriver(edgeOptions);
                break;
            }
            case "chrome" -> {
                System.setProperty("webdriver.chrome.driver", USER_DIR + DRIVER_LOCATION + "chromedriver.exe");
                ChromeOptions chromeOptions = new ChromeOptions();
                chromeOptions.setPageLoadStrategy(PageLoadStrategy.NORMAL);
                driver = new ChromeDriver(chromeOptions);
                break;
            }
            case "firefox" -> {
                System.setProperty("webdriver.gecko.driver", USER_DIR + DRIVER_LOCATION + "geckodriver.exe");
                FirefoxOptions firefoxOptions = new FirefoxOptions();
                firefoxOptions.setPageLoadStrategy(PageLoadStrategy.NORMAL);
                driver = new FirefoxDriver(firefoxOptions);
                break;
            }
        }
        driver.manage().window().maximize();
        return driver;
    }

    public static void cleanupWebDriver() {
        webDriver.get().quit();
        webDriver.remove();
    }

}
