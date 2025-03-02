package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import java.io.IOException;

public class ProductDetailPage extends BasePage {

    private By addToCartButton = By.id("add-to-cart-button");

    public ProductDetailPage(WebDriver driver) throws IOException {
        super();
    }

    public void clickAddToCart() throws Exception {
        click(addToCartButton);
    }
}
