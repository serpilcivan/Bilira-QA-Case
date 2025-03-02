package stepDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import pageObjects.CartPage;
import pageObjects.ProductDetailPage;
import pageObjects.SearchPage;
import utils.DriverManager;
import java.io.IOException;

public class ProductDetailSteps {

    WebDriver driver = DriverManager.getDriver();
    ProductDetailPage productDetailPage;
    SearchPage searchPage;
    CartPage cartPage;
    private static final Logger logger = LogManager.getLogger(SearchSteps.class);

    public ProductDetailSteps() throws IOException {
        productDetailPage = new ProductDetailPage(driver);
        searchPage =new SearchPage(driver);
        cartPage = new CartPage(driver);
    }
    @And("click the first product")
    public void click_the_first_product(){
        searchPage.clickProduct();
        logger.info("Successfully clicked on the product.");
    }


    @When("user adds the product to cart")
    public void user_adds_the_product_to_cart() throws Exception {
        productDetailPage.clickAddToCart();
        logger.info("Product successfully added to cart.");
    }


    @Then("the product should be in the cart")
    public void the_product_should_be_in_the_cart() throws Exception {
        cartPage.goToCart();
        assert cartPage.isProductInCart();
    }
}
