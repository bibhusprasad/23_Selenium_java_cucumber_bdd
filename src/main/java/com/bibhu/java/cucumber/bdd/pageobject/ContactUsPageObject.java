package com.bibhu.java.cucumber.bdd.pageobject;

import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ContactUsPageObject extends BasePageObject {

    private static final String CONTACT_US_URL = "https://webdriveruniversity.com/Contact-Us/contactus.html";

    private @FindBy(xpath = "//input[@name='first_name']")
    WebElement firstNameTextField;

    private @FindBy(xpath = "//input[@name='last_name']")
    WebElement lastNameTextField;

    private @FindBy(xpath = "//input[@name='email']")
    WebElement emailAddressTextField;

    private @FindBy(xpath = "//textarea[@name='message']")
    WebElement messageBoxTextField;

    private @FindBy(xpath = "//input[@value='SUBMIT']")
    WebElement submitButton;

    private @FindBy(xpath = "//div[@id='contact_reply']/h1")
    WebElement contactUsSuccessfulSubmissionMessage;

    public ContactUsPageObject() {
        super();
    }

    public void navigateToWebDriverUniversityContactUsPage() {
        navigateToUrl(CONTACT_US_URL);
    }

    public void setFirstName(String firstName) {
        sendKeys(firstNameTextField, firstName);
    }

    public void setLastName(String lastName) {
        sendKeys(lastNameTextField, lastName);
    }

    public void setEmailAddress(String emailAddress) {
        sendKeys(emailAddressTextField, emailAddress);
    }

    public void setMessage(String message) {
        sendKeys(messageBoxTextField, message);
    }

    public void clickOnSubmitButton() {
        waitForWebElementAndClick(submitButton);
    }

    public void validateSuccessfulSubmissionMessageText() {
        waitFor(contactUsSuccessfulSubmissionMessage);
        Assertions.assertEquals("Thank You for your Message!", contactUsSuccessfulSubmissionMessage.getText());
    }
}
