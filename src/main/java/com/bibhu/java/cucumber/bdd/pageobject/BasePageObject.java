package com.bibhu.java.cucumber.bdd.pageobject;

import com.bibhu.java.cucumber.bdd.driver.DriverFactory;
import net.bytebuddy.utility.RandomString;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class BasePageObject {

    public BasePageObject() {
        PageFactory.initElements(getWebDriver(), this);
    }

    public WebDriver getWebDriver() {
        return DriverFactory.getWebDriver();
    }

    public String generateRandomString(int length) {
        return RandomString.make(length);
    }

    public void navigateToUrl(String url) {
        getWebDriver().get(url);
    }

    public void sendKeys(By by, String textToType) {
        WebDriverWait webDriverWait = new WebDriverWait(getWebDriver(), Duration.ofSeconds(15));
        webDriverWait.until(ExpectedConditions.elementToBeClickable(by)).sendKeys(textToType);
    }

    public void sendKeys(WebElement webElement, String textToType) {
        WebDriverWait webDriverWait = new WebDriverWait(getWebDriver(), Duration.ofSeconds(15));
        webDriverWait.until(ExpectedConditions.elementToBeClickable(webElement)).sendKeys(textToType);
    }

    public void waitForWebElementAndClick(By by) {
        WebDriverWait webDriverWait = new WebDriverWait(getWebDriver(), Duration.ofSeconds(15));
        webDriverWait.until(ExpectedConditions.elementToBeClickable(by)).click();
    }

    public void waitForWebElementAndClick(WebElement webElement) {
        WebDriverWait webDriverWait = new WebDriverWait(getWebDriver(), Duration.ofSeconds(15));
        webDriverWait.until(ExpectedConditions.elementToBeClickable(webElement)).click();
    }

    public void waitFor(By by) {
        WebDriverWait webDriverWait = new WebDriverWait(getWebDriver(), Duration.ofSeconds(15));
        webDriverWait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(by));
    }

    public void waitFor(WebElement webElement) {
        WebDriverWait webDriverWait = new WebDriverWait(getWebDriver(), Duration.ofSeconds(15));
        webDriverWait.until(ExpectedConditions.visibilityOf(webElement));
    }

    public void waitForAlertAndValidateText(String message) {
        WebDriverWait webDriverWait = new WebDriverWait(getWebDriver(), Duration.ofSeconds(20));
        webDriverWait.until(ExpectedConditions.alertIsPresent());
        String alertMessageText = getWebDriver().switchTo().alert().getText();
        Assertions.assertEquals(alertMessageText, message);
    }

}
