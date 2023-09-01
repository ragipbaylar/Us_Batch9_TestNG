package Day02;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class _01_Example {

    /**
     * Go to "https://opencart.abstracta.us/index.php?route=account/login" page
     * login
     * email:  testngusbatch@gmail.com
     * password: usbatch1234
     * verify that you see My Account
     * */

    @Test
    void loginTest(){
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://opencart.abstracta.us/index.php?route=account/login");

        WebElement username = driver.findElement(By.id("input-email"));
        username.sendKeys("testngusbatch@gmail.com");

        WebElement password = driver.findElement(By.id("input-password"));
        password.sendKeys("usbatch1234");

        WebElement loginButton = driver.findElement(By.cssSelector("input[value='Login']"));
        loginButton.click();

        WebElement myAccount = driver.findElement(By.xpath("(//div[@id='content']//h2)[1]"));

//        if (myAccount.isDisplayed()){
//            System.out.println("Test is passed");
//        }else {
//            System.out.println("Test is failed");
//        }

        Assert.assertTrue(myAccount.getText().contains("My Account"));

        driver.quit();



    }
}
