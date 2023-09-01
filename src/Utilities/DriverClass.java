package Utilities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import java.io.IOException;
import java.time.Duration;

public class DriverClass {
    public WebDriver driver;

    @BeforeClass
    public void createDriver() {
        closePreviousDrivers();
        driver = new ChromeDriver();
        driver.manage().window().maximize();

        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
        driver.get("https://opencart.abstracta.us/index.php?route=account/login");
        login();
    }

//    @AfterClass
//    public void quitDriver() {
//        try {
//            Thread.sleep(3000);
//        } catch (InterruptedException e) {
//            System.out.println(e.getMessage());
//        }
//        driver.quit();
//    }

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
}
