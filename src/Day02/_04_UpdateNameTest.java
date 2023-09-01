package Day02;

import Utilities.DriverClass;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class _04_UpdateNameTest extends DriverClass {

    /**
     * Go to "https://opencart.abstracta.us/index.php?route=account/login"
     * Login
     * Click on Edit Account
     * Update name
     * Click on Continue
     * Verify the success message
     * Then update the name with the old name
     */

    @Test
    void editNameTest() {
        editName("Mike");
        editName("Michael");
    }

    void editName(String username){
        WebElement editAccount = driver.findElement(By.cssSelector("div[class=\"list-group\"]>a:nth-child(2)"));
        editAccount.click();

        WebElement firstname = driver.findElement(By.id("input-firstname"));
        firstname.clear();
        firstname.sendKeys(username);

        WebElement continueButton = driver.findElement(By.cssSelector("input[type='submit']"));
        continueButton.click();

        WebElement successMessage = driver.findElement(By.xpath("//div[contains(@class,'alert-success')]"));

        Assert.assertTrue(successMessage.getText().contains("successfully updated"));
    }
}
