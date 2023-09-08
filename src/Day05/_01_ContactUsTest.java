package Day05;

import Utilities.DriverClass;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class _01_ContactUsTest extends DriverClass {
    /**
     * Go to "https://opencart.abstracta.us/index.php?route=account/login"
     * login
     * click on Contact Us
     * send a message
     * check if the url has "success" key word
     * and run your test from XML file
     * */

    @Test
    @Parameters("message") // This one must be the same with xml file
    void contactUsTest(@Optional("We are Batch 9 and we are coming soon.") String msg){ // this can be different
        // optional means if the method is getting parameter from xml use that parameter
        // otherwise use the message in the @Optional annotation
        WebElement contactUs = driver.findElement(By.xpath("//a[text()='Contact Us']"));
        contactUs.click();

        WebElement messageInput = driver.findElement(By.id("input-enquiry"));
        messageInput.sendKeys(msg);

        WebElement submitButton = driver.findElement(By.xpath("//input[@type='submit']"));
        submitButton.click();

        Assert.assertTrue(driver.getCurrentUrl().contains("success"),"The url doesn't have success key word");
    }

    @Test
    @Parameters({"message1", "message2"}) // This one must be the same with xml file
    void contactUsTest1(@Optional("We are Batch 9 and we are coming soon.") String msg1, @Optional("Get ready") String msg2){ // this can be different
        WebElement contactUs = driver.findElement(By.xpath("//a[text()='Contact Us']"));
        contactUs.click();

        WebElement messageInput = driver.findElement(By.id("input-enquiry"));
        messageInput.sendKeys(msg1);
        messageInput.sendKeys(msg2);

        WebElement submitButton = driver.findElement(By.xpath("//input[@type='submit']"));
        submitButton.click();

        Assert.assertTrue(driver.getCurrentUrl().contains("success"),"The url doesn't have success key word");
    }
}
