package stepDefinitions;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import org.openqa.selenium.WebDriver;
import utils.DriverManager;
import utils.ScreenshotUtil;

public class  Hooks {

    WebDriver driver = DriverManager.getDriver();
    @Before
    public void setUp() {
        DriverManager.initializeDriver();
    }


    @After
    public void tearDown(io.cucumber.java.Scenario scenario) {
        if (scenario.isFailed()) {
            ScreenshotUtil.takeScreenshot(driver);
        }
        DriverManager.quitDriver();
    }
}
