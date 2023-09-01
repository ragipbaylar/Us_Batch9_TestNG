package Day02;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class _03_SignUpTest {
    /**
     * Go to "https://opencart.abstracta.us/index.php?route=account/login"
     * Click on My Accout
     * Click on Register
     * Fill in the form with valid informations
     * Accept the agreement
     * Click on Continue button
     * Verify that you are signed up
     */

    @Test
    void signUpTest() {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        driver.get("https://opencart.abstracta.us/index.php?route=account/login");

        WebElement myAccountDropDown = driver.findElement(By.xpath("//span[text()='My Account']"));
        myAccountDropDown.click();

        WebElement register = driver.findElement(By.xpath("(//a[text()='Register'])[1]"));
        register.click();

        WebElement firstName = driver.findElement(By.id("input-firstname"));
        firstName.sendKeys("Michael");

        WebElement lastName = driver.findElement(By.id("input-lastname"));
        lastName.sendKeys("Knight");

        WebElement email = driver.findElement(By.id("input-email"));
        email.sendKeys("knightrider@gmail.com");

        WebElement phone = driver.findElement(By.id("input-telephone"));
        phone.sendKeys("6521457896");

        WebElement password = driver.findElement(By.id("input-password"));
        password.sendKeys("knightrider1234");

        WebElement confirmPassword = driver.findElement(By.id("input-confirm"));
        confirmPassword.sendKeys("knightrider1234");

        WebElement termsAndConditions = driver.findElement(By.name("agree"));
        termsAndConditions.click();

        WebElement continueButton = driver.findElement(By.cssSelector("input[type='submit']"));
        continueButton.click();

        WebElement successMessage = driver.findElement(By.xpath("(//div[@id='content']//p)[1]"));

        Assert.assertTrue(successMessage.getText().contains("successfully created"));

        driver.quit();
    }
}
