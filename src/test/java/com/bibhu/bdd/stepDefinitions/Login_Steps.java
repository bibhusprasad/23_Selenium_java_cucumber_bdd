package com.bibhu.bdd.stepDefinitions;

import com.bibhu.java.cucumber.bdd.pageobject.BasePageObject;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Login_Steps extends BasePageObject {

    private static final String LOGIN_URL = "https://webdriveruniversity.com/Login-Portal/index.html";

    private WebDriver webDriver = getWebDriver();

    @Given("I access the WebDriver University login page")
    public void i_access_the_web_driver_university_login_page() {
        navigateToUrl(LOGIN_URL);
    }

    @When("I enter valid username {word}")
    public void i_enter_valid_username(String username) {
        //webDriver.findElement(By.id("text")).sendKeys(username);
        sendKeys(By.id("text"), username);
    }

    @When("I enter a username {}")
    public void i_enter_a_username(String username) {
        //webDriver.findElement(By.id("text")).sendKeys(username);
        sendKeys(By.id("text"), username);
    }

    @And("I enter valid password {word}")
    public void i_enter_valid_password(String password) {
        //webDriver.findElement(By.id("password")).sendKeys(password);
        sendKeys(By.id("password"), password);
    }

    @And("I enter invalid password {word}")
    public void i_enter_invalid_password(String password) {
        //webDriver.findElement(By.id("password")).sendKeys(password);
        sendKeys(By.id("password"), password);
    }

    @And("I enter a password {}")
    public void i_enter_a_password(String password) {
        //webDriver.findElement(By.id("password")).sendKeys(password);
        sendKeys(By.id("password"), password);
    }

    @And("I click on login button")
    public void i_click_on_login_button() {
        //webDriver.findElement(By.id("login-button")).click();
        waitForWebElementAndClick(By.id("login-button"));
    }

    @Then("I should be presented with a validation success alert message")
    public void i_should_be_presented_with_a_validation_success_alert_message() {
        Alert alert = webDriver.switchTo().alert();
        String alertText = alert.getText();
        Assertions.assertEquals("validation succeeded", alertText);
    }

    @Then("I should be presented with a validation failure alert message")
    public void i_should_be_presented_with_a_validation_failure_alert_message() {
        Alert alert = webDriver.switchTo().alert();
        String alertText = alert.getText();
        Assertions.assertEquals("validation failed", alertText);
    }

    @Then("I should be presented with the following login validation message {}")
    public void i_should_be_presented_with_the_following_login_validation_message(String loginValidationMessage) {
        Alert alert = webDriver.switchTo().alert();
        String alertText = alert.getText();
        Assertions.assertEquals(loginValidationMessage, alertText);
    }
}
