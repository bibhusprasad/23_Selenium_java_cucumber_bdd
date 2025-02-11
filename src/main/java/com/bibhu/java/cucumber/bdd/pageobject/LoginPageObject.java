package com.bibhu.java.cucumber.bdd.pageobject;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import static com.bibhu.java.cucumber.bdd.util.GlobalVariableUtil.WEBDRIVER_UNIVERSITY_LOGIN_URL;

public class LoginPageObject extends BasePageObject {

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
        navigateToUrl(WEBDRIVER_UNIVERSITY_LOGIN_URL);
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
