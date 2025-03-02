package pageObjects;

import java.io.IOException;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage extends BasePage{


    private By textfieldEmailAddress= By.id("ap_email");
    private By textfieldPassword = By.id("ap_password");
    private By buttonContinue = By.id("continue");
    private By buttonSubmit= By.id("signInSubmit");
    private By authCode = By.id("auth-mfa-otpcode");
    private By twoStepVerification= By.xpath("//*[@id='auth-mfa-form']/div/div/h1");
    private By buttonCreateAccountSubmit = By.id("createAccountSubmit");
    private By msgHello = By.xpath("//*[@id='nav-link-accountList']/span[1]");


    public LoginPage(WebDriver driver) throws IOException {
        super();
    }


    public LoginPage getPageTitle() throws IOException {


        return new LoginPage(driver);


    }



    public LoginPage enterEmailAddress(String emailAddress) throws Exception {
        Thread.sleep(3000);
        //sendKeysToWebElement(textfield_EmailAddress, emailAddress);
        sendKeys(textfieldEmailAddress, emailAddress);
        return new LoginPage(driver);
    }
    public LoginPage clickOnContinueButton() throws Exception {
        click(buttonContinue);
        // waitAndClickElement(button_Submit);
        return new LoginPage(driver);
    }

    public LoginPage enterPassword(String password) throws Exception {
        //sendKeysToWebElement(textfield_Password, password);
        sendKeys(textfieldPassword, password);
        return new LoginPage(driver);
    }



    public LoginPage clickOnSubmitButton() throws Exception {
        click(buttonSubmit);
       // waitAndClickElement(button_Submit);
        return new LoginPage(driver);
    }

    public void confirmLoginWasSuccessful() throws Exception {


//		WaitUntilWebElementIsVisible(twoStepVerification);
//		Assert.assertEquals("Two-Step Verification", twoStepVerification.getText());

        //WaitUntilWebElementIsVisible(Hello_message);
        isElementVisible(msgHello);
        //Assert.assertEquals("Hello, Serpil", msgHello.getText());



    }

    public void confirmLoginWasNotSuccessful() throws Exception {


        //WaitUntilWebElementIsVisible(createAccountSubmit_button);
        isElementVisible(buttonCreateAccountSubmit);
        //Assert.assertEquals("Create your Amazon account", buttonCreateAccountSubmit.getText());


    }

}