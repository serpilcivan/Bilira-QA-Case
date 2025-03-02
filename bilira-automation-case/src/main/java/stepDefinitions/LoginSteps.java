package stepDefinitions;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import org.openqa.selenium.chrome.ChromeDriver;
import pageObjects.HomePage;
import pageObjects.LoginPage;
import utils.DriverManager;

import java.io.IOException;

public class LoginSteps extends DriverManager {

    LoginPage loginPage;
    HomePage homePage;
    WebDriver driver ;
    private static final Logger logger = LogManager.getLogger(LoginSteps.class);

    public LoginSteps() throws IOException {
        driver = DriverManager.getDriver();
        homePage = new HomePage(driver);
        loginPage = new LoginPage(driver);
    }


    @Given("I am a user of amazoncom")
    public void i_am_a_user_of_amazoncom() throws Throwable {


        homePage = new HomePage(driver);
        homePage.gettoHomePage();
        logger.info("Successfully navigated to Amazon homepage.");
        homePage.clickOnSignInButton();


    }
    /*
    @Given("user is on Amazon login page")
    public void user_is_on_amazon_login_page() throws IOException {
        driver.get("https://www.amazon.com/ap/signin");
        loginPage = new LoginPage(driver);
    }

     */

    @When("user enters valid email {string}")
    public void user_enters_valid_email(String email) throws Exception {
        loginPage.enterEmailAddress(email);
        loginPage.clickOnContinueButton();
    }

    @When("user enters valid password {string}")
    public void user_enters_valid_password(String password) throws Exception {
        loginPage.enterPassword(password);
        loginPage.clickOnSubmitButton();
    }

    @Then("user should be logged in successfully")
    public void user_should_be_logged_in_successfully() {
        Assert.assertTrue(driver.getTitle().contains("Amazon"));
        driver.quit();
    }
}