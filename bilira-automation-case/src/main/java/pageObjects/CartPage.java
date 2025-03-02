package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.io.IOException;

public class CartPage extends BasePage {

    private By cartIcon = By.id("nav-cart");
    private By cartItem = By.cssSelector(".sc-list-item");

    private  By increaseQuantity = By.cssSelector("button[data-a-selector='increment']");
    private By quantityValue = By.cssSelector("div[data-a-selector='spinbutton'] span[data-a-selector='value']");


    private By deleteButton = By.cssSelector("button[data-a-selector='decrement']");
    private By emptyCartMessage = By.xpath("//h1[contains(text(),'Alışveriş Sepetiniz konumundan kaldırıldı.");

    public CartPage(WebDriver driver) throws IOException {
        super();
    }

    public void goToCart() throws Exception {
        click(cartIcon);
    }

    public boolean isProductInCart() {
        return isElementVisible(cartItem);
    }
    public void increaseQuantity() throws Exception {

        click(increaseQuantity);
        Thread.sleep(3000);
        //click(By.xpath("//option[@value='2']")); // 1 artırarak 2 yapıyoruz
        WebElement quantityElement = driver.findElement(quantityValue);
        String quantityText = quantityElement.getText();
        System.out.println("Quantity: " + quantityText);
    }

    public void emptyCart() throws Exception {
        while (isElementVisible(deleteButton)) {
            click(deleteButton);
            Thread.sleep(2000); // Sayfanın güncellenmesi için bekliyoruz
        }
    }

    public boolean isCartEmpty() {
        return isElementVisible(emptyCartMessage);
    }
}
