package utils;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class DriverManager {

    private static WebDriver driver;
    private static final Logger logger = LogManager.getLogger(DriverManager.class);



    public static void initializeDriver() {
        if (driver == null) {
            logger.info("Driver başlatılıyor...");
            System.setProperty("webdriver.chrome.driver","/Users/master/Downloads/chromedriver-mac-arm64/chromedriver");
            driver = new ChromeDriver();
            driver.manage().window().maximize();
            logger.info("Driver başarıyla başlatıldı.");

        }
    }
    public static WebDriver getDriver() {
        if (driver == null) {
            initializeDriver();  // Eğer driver null ise başlat
        }
        return driver;
    }
    public static void quitDriver() {
        if (driver != null) {
            logger.info("Driver kapatılıyor...");
            driver.quit();
            driver = null;
            logger.info("Driver kapatıldı.");
        }
    }

}

