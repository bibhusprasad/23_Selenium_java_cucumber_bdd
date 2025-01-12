package com.bibhu.java.cucumber.bdd.pageobject;

import com.bibhu.java.cucumber.bdd.driver.DriverFactory;
import net.bytebuddy.utility.RandomString;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class BasePageObject {

    public BasePageObject() {
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

}
