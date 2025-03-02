package pageObjects;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class SearchPage extends BasePage {
    private By firstProduct = By.xpath("//*[@id=\"CardInstanceDrts2DhKSckQsuwekXESCg\"]/div/div/div[1]/div/div[2]/div[2]/div/div[1]/div/div/a[1]");

    private By resultsLocator = By.cssSelector("div.s-main-slot");

    public SearchPage(WebDriver driver) {
        super();
        this.driver = driver;
    }


    public void selectProduct(String index) {
        String xpath="//img[@data-image-index='"+index+"']";

        List<WebElement> productlink=driver.findElements(By.xpath(xpath));

        int k=productlink.size();
        System.out.println("Elements count: "+k);
        if (k==1) {
            productlink.get(k-1).click();
        }else {
            driver.findElement(By.xpath("//img[@data-image-index='2']"));
        }


    }

    public boolean productDisplay(){
        Assert.assertTrue("Search results are not displayed!", isElementVisible(resultsLocator));
        return true;
    }

    public void clickProduct(){
        selectProduct("2");
    }

}


