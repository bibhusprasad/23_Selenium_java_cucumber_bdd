package com.bibhu.bdd.stepDefinitions;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.bytebuddy.utility.RandomString;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;

public class Login_Steps {

    private WebDriver webDriver;

    @Before
    public void setup() {
        System.setProperty("webdriver.edge.driver", System.getProperty("user.dir") + "/src/main/java/drivers/msedgedriver.exe");
        EdgeOptions edgeOptions = new EdgeOptions();
        edgeOptions.setPageLoadStrategy(PageLoadStrategy.NORMAL);
        webDriver = new EdgeDriver(edgeOptions);
        webDriver.manage().window().maximize();
    }

    @After
    public void teardown() {
        webDriver.quit();
    }

    public String generateRandomString(int length) {
        return RandomString.make(length);
    }

    @Given("I access the WebDriver University login page")
    public void i_access_the_web_driver_university_login_page() {
        webDriver.get("https://webdriveruniversity.com/Login-Portal/index.html");
    }

    @When("I enter valid username {word}")
    public void i_enter_valid_username_webdriver(String username) {
        webDriver.findElement(By.id("text")).sendKeys(username);
    }

    @And("I enter valid password {word}")
    public void i_enter_valid_password_webdriver123(String password) {
        webDriver.findElement(By.id("password")).sendKeys(password);
    }

    @And("I click on login button")
    public void i_click_on_login_button() {
        webDriver.findElement(By.id("login-button")).click();
    }

    @Then("I should be presented with a validation success alert message")
    public void i_should_be_presented_with_a_validation_success_alert_message() {
        Alert alert = webDriver.switchTo().alert();
        String alertText = alert.getText();
        Assertions.assertEquals("validation succeeded", alertText);
    }

    @When("I enter invalid username")
    public void i_enter_invalid_username() {
        webDriver.findElement(By.id("text")).sendKeys(generateRandomString(10));
    }

    @And("I enter invalid password")
    public void i_enter_invalid_password() {
        webDriver.findElement(By.id("password")).sendKeys(generateRandomString(10));
    }

    @Then("I should be presented with a validation failure alert message")
    public void i_should_be_presented_with_a_validation_failure_alert_message() {
        Alert alert = webDriver.switchTo().alert();
        String alertText = alert.getText();
        Assertions.assertEquals("validation failed", alertText);
    }
}
