package com.bibhu.bdd.stepDefinitions.base;

import io.cucumber.java.After;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import java.sql.Timestamp;

import static com.bibhu.java.cucumber.bdd.driver.DriverFactory.cleanupWebDriver;
import static com.bibhu.java.cucumber.bdd.driver.DriverFactory.getWebDriver;

public class Hooks {

    @Before
    public void setup() {
        getWebDriver();
    }

    @After
    public void teardown() {
        cleanupWebDriver();
    }

    @AfterStep
    public void captureExceptionImage(Scenario scenario) {
        if (scenario.isFailed()) {
            Timestamp timestamp = new Timestamp(System.currentTimeMillis());
            String timeMilliseconds = String.valueOf(timestamp.getTime());
            byte[] screenshots = ((TakesScreenshot) getWebDriver()).getScreenshotAs(OutputType.BYTES);
            scenario.attach(screenshots, "image/png", timeMilliseconds);
        }
    }

}
