package pageObjects;

import java.util.List;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.DriverManager;


public class BasePage extends DriverManager {
    protected WebDriver driver;
    protected WebDriverWait wait;

    public BasePage() {
        this.driver = DriverManager.getDriver(); // Doğru driver ataması
        this.wait = new WebDriverWait(driver, 10);
    }



    public void click(By locator) {
        waitForElementToBeClickable((By) locator);
        driver.findElement((By) locator).click();
    }




    public void sendKeys(By locator, String text) {
        waitForElementToBeVisible(locator);
        driver.findElement(locator).sendKeys(text);
    }




    public boolean isElementVisible(By locator) {
        try {
            waitForElementToBeVisible(locator);
            return true;
        } catch (Exception e) {
            return false;
        }
    }


    public void waitForElementToBeVisible(By locator) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }


    public void waitForElementToBeClickable(By locator) {
        wait.until(ExpectedConditions.elementToBeClickable(locator));
    }



    public void clickElement(WebElement element) {
        new WebDriverWait(driver, 10)
                .until(ExpectedConditions.elementToBeClickable(element))
                .click();
    }



    public WebElement waitForElement(By locator, int timeout) {
        return new WebDriverWait(driver, 10)
                .until(ExpectedConditions.presenceOfElementLocated(locator));
    }


    public List<WebElement> waitForElements(By locator, int timeout) {
        return new WebDriverWait(driver, 10)
                .until(ExpectedConditions.presenceOfAllElementsLocatedBy(locator));
    }



}