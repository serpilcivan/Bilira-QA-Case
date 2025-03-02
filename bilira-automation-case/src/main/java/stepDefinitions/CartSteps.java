package stepDefinitions;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import pageObjects.CartPage;
import pageObjects.HomePage;
import pageObjects.LoginPage;
import utils.DriverManager;
import java.io.IOException;

public class CartSteps {

    WebDriver driver;
    CartPage cartPage;
    HomePage homePage;
    LoginPage loginPage;
    private static final Logger logger = LogManager.getLogger(CartSteps.class);


    public CartSteps() throws IOException {
        this.driver = DriverManager.getDriver();
        cartPage = new CartPage(driver);
        homePage= new HomePage(driver);
        loginPage =new LoginPage(driver);


    }

    @When("user increases the product quantity")
    public void user_increases_the_product_quantity() throws Throwable {

        // Kullanıcının login olup olmadığını kontrol et
        /*
        if (homePage.isUserLoggedIn()) {
            System.out.println("User is not logged in, performing login first...");
            LoginSteps loginSteps = new LoginSteps();
            loginSteps.i_am_a_user_of_amazoncom();
        }

         */
        cartPage.increaseQuantity();
        logger.info("Product quantity successfully increased.");
    }

    @Then("the product quantity should be increased")
    public void the_product_quantity_should_be_increased() {
        System.out.println("Quantity increased successfully!");
        logger.info("Product quantity increased successfully.");


    }

    @When("user empties the cart")
    public void user_empties_the_cart() throws Exception {
        cartPage.emptyCart();
        logger.info("Cart has been emptied successfully.");
    }

    @Then("the cart should be empty")
    public void the_cart_should_be_empty() {
        assert cartPage.isCartEmpty();
        logger.info("Cart is successfully verified as empty.");
    }
}
