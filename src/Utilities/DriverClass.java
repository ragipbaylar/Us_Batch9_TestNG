package Utilities;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import org.testng.ITest;
import org.testng.ITestResult;
import org.testng.annotations.*;

import java.io.IOException;
import java.time.Duration;

public class DriverClass {
    public static WebDriver driver;
    public static WebDriverWait wait;

    @BeforeClass(alwaysRun = true) // Before Class doesn't work with groups. Because we are not running the class.
    // We are running some tests in the class. To make sure it run all the time we should add alwaysRun=true
    @Parameters("browserName")
    public void createDriver(@Optional("firefox") String browser) {

        switch (browser.toLowerCase()) {
            case "chrome":
                driver = new ChromeDriver();
                break;
            case "firefox":
                driver = new FirefoxDriver();
                break;
            case "safari":
                driver = new SafariDriver();
                break;
            case "edge":
                driver = new EdgeDriver();
                break;
        }
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        driver.manage().window().maximize();

        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
        driver.get("https://opencart.abstracta.us/index.php?route=account/login");
        login();
    }

    @AfterClass(alwaysRun = true)
    public void quitDriver() {
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            System.out.println(e.getMessage());
        }
        driver.quit();
    }

    public void closePreviousDrivers() {
        try {
            Runtime.getRuntime().exec("taskkill /F /IM chromedriver.exe /T");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void login() {
        WebElement username = driver.findElement(By.id("input-email"));
        username.sendKeys("knightrider@gmail.com");

        WebElement password = driver.findElement(By.id("input-password"));
        password.sendKeys("knightrider1234");

        WebElement loginButton = driver.findElement(By.cssSelector("input[value='Login']"));
        loginButton.click();
    }

   public static final Logger logger = LogManager.getLogger();

    @BeforeMethod
    public void beforeMethod(ITestResult test) {
        // All -> Trace ->Debug -> info -> warn -> error -> fatal
//        logger.info("Test has started");
//        logger.warn("Warn Level Message 1");

        logger.info(test.getTestName()+" test has started");
    }

    @AfterMethod
    public void afterMethod(ITestResult test) {
//        logger.info("Test has ended");
//        logger.warn("Warn Level Message 1");
        logger.info(test.getName()+"has ended and the result is "+(test.getStatus()==1 ? "passed" : "failed")); // setStatus returns 1(passed) or 2(failed)
    }


}
