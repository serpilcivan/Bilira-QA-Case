package stepDefinitions;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import pageObjects.HomePage;
import pageObjects.SearchPage;
import utils.DriverManager;

import java.io.IOException;

public class SearchSteps {
    WebDriver driver;
    HomePage homePage;
    SearchPage searchPage;
    private static final Logger logger = LogManager.getLogger(SearchSteps.class);

    public SearchSteps() {
        driver = DriverManager.getDriver();
        homePage = new HomePage(driver);
        searchPage = new SearchPage(driver);
    }

    @When("user searches for {string}")
    public void user_searches_for(String product) throws Throwable {
        // Kullanıcının login olup olmadığını kontrol et
        if (homePage.isUserLoggedIn()) {
            System.out.println("User is not logged in, performing login first...");
            LoginSteps loginSteps = new LoginSteps();
            loginSteps.i_am_a_user_of_amazoncom();
        }
        homePage.gettoHomePage();
        homePage.acceptCookies();
        homePage.searchForProduct(product);
        logger.info("Searching for product: " + product);
    }

    @Then("search results should be displayed")
    public void search_results_should_be_displayed() {
        //Assert.assertTrue("Search results are not displayed!", searchPage.productDisplay());
        assert searchPage.productDisplay();
        logger.info("Search results are successfully displayed.");
    }


}
