package com.bibhu.bdd.stepDefinitions.base;

import io.cucumber.java.After;
import io.cucumber.java.Before;

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

}
