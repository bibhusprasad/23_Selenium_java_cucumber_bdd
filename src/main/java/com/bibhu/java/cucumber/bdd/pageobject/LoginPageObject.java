package com.bibhu.java.cucumber.bdd.pageobject;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPageObject extends BasePageObject {

    private static final String LOGIN_URL = "https://webdriveruniversity.com/Login-Portal/index.html";

    private @FindBy(id = "text")
    WebElement usernameTextField;

    private @FindBy(id = "password")
    WebElement passwordTextField;

    private @FindBy(id = "login-button")
    WebElement loginButton;


    public LoginPageObject() {
        super();
    }

    public void navigateToWebDriverUniversityLoginPage() {
        navigateToUrl(LOGIN_URL);
    }

    public void setUsername(String username) {
        sendKeys(usernameTextField, username);
    }

    public void setPassword(String password) {
        sendKeys(passwordTextField, password);
    }

    public void clickOnLoginButton() {
        waitForWebElementAndClick(loginButton);
    }

    public void validateSuccessfulLogin() {
        waitForAlertAndValidateText("validation succeeded");
    }

    public void validateUnsuccessfulLogin() {
        waitForAlertAndValidateText("validation failed");
    }

    public void validateUserLogin(String message) {
        waitForAlertAndValidateText(message);
    }

}
