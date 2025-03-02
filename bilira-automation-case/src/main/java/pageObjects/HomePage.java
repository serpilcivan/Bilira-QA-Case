package pageObjects;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class HomePage extends BasePage{


    //public @FindBy(xpath = "//span[text()='Hello. Sign in']") WebElement button_Sign_In;
    private By buttonSignIn= By.xpath("//*[@id=\"nav-link-accountList\"]");

    private By searchBox = By.id("twotabsearchtextbox");
    private By searchButton = By.id("nav-search-submit-button");
    private By cookiesAcceptButton = By.id("sp-cc-accept");




    public HomePage(WebDriver driver)  {
        super();
    }


    public HomePage gettoHomePage() throws IOException {
        getDriver().get("https://www.amazon.com.tr/");
        return new HomePage(driver);
    }

    public HomePage clickOnSignInButton() throws Exception {
        click(buttonSignIn);
        Thread.sleep(5000);
        System.out.println(getDriver().getTitle());
        return new HomePage(driver);


    }
    public void searchForProduct(String productName) {
        sendKeys(searchBox, productName);
        click(searchButton);
    }
    public void acceptCookies() {
        if (isElementVisible(cookiesAcceptButton)) {
            click(cookiesAcceptButton);
        }
    }

    // Kullanıcının giriş yapıp yapmadığını kontrol eden metot
    public boolean isUserLoggedIn() {
        try {
            WebElement accountElement = driver.findElement(By.id("nav-link-accountList"));
            return accountElement.getText().contains("Hello");
        } catch (Exception e) {
            return false;
        }
    }




}