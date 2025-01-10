package com.bibhu.bdd.stepDefinitions;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.bytebuddy.utility.RandomString;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;

public class Contact_Us_Steps {

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

    @Given("I access the WebDriver University contact us page")
    public void i_access_the_web_driver_university_contact_us_page() {
        webDriver.get("https://webdriveruniversity.com/Contact-Us/contactus.html");
    }

    @When("I enter a unique first name")
    public void i_enter_a_unique_first_name() {
        webDriver.findElement(By.xpath("//input[@name='first_name']")).sendKeys("AutoFN" + generateRandomString(5));
    }

    @And("I enter a unique last name")
    public void i_enter_a_unique_last_name() {
        webDriver.findElement(By.xpath("//input[@name='last_name']")).sendKeys("AutoLN" + generateRandomString(5));
    }

    @And("I enter a unique email address")
    public void i_enter_a_unique_email_address() {
        webDriver.findElement(By.xpath("//input[@name='email']")).sendKeys(generateRandomString(10) + "@gmail.com");
    }

    @And("I enter a unique comment")
    public void i_enter_a_unique_comment() {
        webDriver.findElement(By.xpath("//textarea[@name='message']")).sendKeys("a sample test message " + generateRandomString(30));
    }

    @And("I click on the submit button")
    public void i_click_on_the_submit_button() {
        webDriver.findElement(By.xpath("//input[@value='SUBMIT']")).click();
    }

    @Then("I should be presented with a successful contact us submission message")
    public void i_should_be_presented_with_a_successful_contact_us_submission_message() {
        WebElement contactUsSubmissionMessage = webDriver.findElement(By.xpath("//div[@id='contact_reply']/h1"));
        Assertions.assertEquals("Thank You for your Message!", contactUsSubmissionMessage.getText());
    }
}
