package com.bibhu.bdd.stepDefinitions;

import com.bibhu.java.cucumber.bdd.pageobject.BasePageObject;
import com.bibhu.java.cucumber.bdd.pageobject.ContactUsPageObject;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Contact_Us_Steps extends BasePageObject {

    private WebDriver webDriver = getWebDriver();
    private ContactUsPageObject contactUsPageObject;

    public Contact_Us_Steps(ContactUsPageObject contactUsPageObject) {
        this.contactUsPageObject = contactUsPageObject;
    }

    @Given("I access the WebDriver University contact us page")
    public void i_access_the_web_driver_university_contact_us_page() {
        contactUsPageObject.navigateToWebDriverUniversityContactUsPage();
    }

    @When("I enter a unique first name")
    public void i_enter_a_unique_first_name() {
        //webDriver.findElement(By.xpath("//input[@name='first_name']")).sendKeys("AutoFN" + generateRandomString(5));
        //sendKeys(By.xpath("//input[@name='first_name']"), "AutoFN" + generateRandomString(5));
        contactUsPageObject.setFirstName("AutoFN" + generateRandomString(5));
    }

    @When("I enter a specific first name {word}")
    public void i_enter_a_specific_first_name_john(String firstName) {
        //webDriver.findElement(By.xpath("//input[@name='first_name']")).sendKeys(firstName);
        //sendKeys(By.xpath("//input[@name='first_name']"), firstName);
        contactUsPageObject.setFirstName(firstName);
    }

    @And("I enter a unique last name")
    public void i_enter_a_unique_last_name() {
        //webDriver.findElement(By.xpath("//input[@name='last_name']")).sendKeys("AutoLN" + generateRandomString(5));
        //sendKeys(By.xpath("//input[@name='last_name']"), "AutoLN" + generateRandomString(5));
        contactUsPageObject.setLastName("AutoLN" + generateRandomString(5));
    }

    @And("I enter a specific last {word}")
    public void i_enter_a_specific_last_doe(String lastName) {
        //webDriver.findElement(By.xpath("//input[@name='last_name']")).sendKeys(lastName);
        //sendKeys(By.xpath("//input[@name='last_name']"), lastName);
        contactUsPageObject.setLastName(lastName);
    }

    @And("I enter a unique email address")
    public void i_enter_a_unique_email_address() {
        //webDriver.findElement(By.xpath("//input[@name='email']")).sendKeys(generateRandomString(10) + "@gmail.com");
        //sendKeys(By.xpath("//input[@name='email']"), generateRandomString(10) + "@gmail.com");
        contactUsPageObject.setEmailAddress(generateRandomString(10) + "@gmail.com");
    }

    @And("I enter a specific email address {word}")
    public void i_enter_a_specific_email_address_johndoegmailcom(String email) {
        //webDriver.findElement(By.xpath("//input[@name='email']")).sendKeys(email);
        //sendKeys(By.xpath("//input[@name='email']"), email);
        contactUsPageObject.setEmailAddress(email);
    }

    @And("I enter a unique comment")
    public void i_enter_a_unique_comment() {
        //webDriver.findElement(By.xpath("//textarea[@name='message']")).sendKeys("a sample test message " + generateRandomString(30));
        //sendKeys(By.xpath("//textarea[@name='message']"), "a sample test message " + generateRandomString(30));
        contactUsPageObject.setMessage("a sample test message " + generateRandomString(30));
    }

    @And("I enter a specific comment {string}")
    public void i_enter_a_specific_comment(String message) {
        //webDriver.findElement(By.xpath("//textarea[@name='message']")).sendKeys(message);
        //sendKeys(By.xpath("//textarea[@name='message']"), message);
        contactUsPageObject.setMessage(message);
    }

    @And("I click on the submit button")
    public void i_click_on_the_submit_button() {
        //webDriver.findElement(By.xpath("//input[@value='SUBMIT']")).click();
        //waitForWebElementAndClick(By.xpath("//input[@value='SUBMIT']"));
        contactUsPageObject.clickOnSubmitButton();
    }

    @Then("I should be presented with a successful contact us submission message")
    public void i_should_be_presented_with_a_successful_contact_us_submission_message() {
        //WebElement contactUsSubmissionMessage = webDriver.findElement(By.xpath("//div[@id='contact_reply']/h1"));
        //Assertions.assertEquals("Thank You for your Message!", contactUsSubmissionMessage.getText());
        contactUsPageObject.validateSuccessfulSubmissionMessageText();
    }

}
