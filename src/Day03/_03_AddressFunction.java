package Day03;

import Utilities.DriverClass;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

public class _03_AddressFunction extends DriverClass {
    /**
     * Go to "https://opencart.abstracta.us/index.php?route=account/login"
     * Login
     * Click on Address Book
     * Add a new address
     * Edit the address
     * Delete the address
     * Write 3 different tests for add, edit and delete address
     */

    @Test(groups = "MyGroup") // We also added this test because edit and delete depend on this one
    void addAddress() {
        WebElement addressBook = driver.findElement(By.xpath("(//a[text()='Address Book'])[1]"));
        addressBook.click();

        WebElement newAddressButton = driver.findElement(By.xpath("//a[text()='New Address']"));
        newAddressButton.click();

        WebElement firstname = driver.findElement(By.id("input-firstname"));
        firstname.sendKeys("Micheal");

        WebElement lastname = driver.findElement(By.id("input-lastname"));
        lastname.sendKeys("Knight");

        WebElement address1 = driver.findElement(By.id("input-address-1"));
        address1.sendKeys("896 Knights Ave.");

        WebElement city = driver.findElement(By.id("input-city"));
        city.sendKeys("Los Angeles");

        WebElement postCode = driver.findElement(By.id("input-postcode"));
        postCode.sendKeys("321547");

        WebElement countryDropDown = driver.findElement(By.id("input-country"));
        Select countrySelect = new Select(countryDropDown);
        countrySelect.selectByValue("223");

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//option[text()='California']")));

        WebElement stateDropDown = driver.findElement(By.id("input-zone"));
        Select stateSelect = new Select(stateDropDown);
        stateSelect.selectByValue("3624");

        WebElement continueButton = driver.findElement(By.xpath("//input[@type='submit']"));
        continueButton.click();

        WebElement successMessage = driver.findElement(By.xpath("//div[contains(@class,'alert-success')]"));
        Assert.assertTrue(successMessage.getText().contains("successfully added"));
    }

    @Test(dependsOnMethods = "addAddress", groups = "MyGroup")
    void editAddress() {

        WebElement editButton = driver.findElement(By.xpath("//a[text()='Edit']"));
        editButton.click();

        WebElement address1 = driver.findElement(By.id("input-address-1"));
        address1.clear();
        address1.sendKeys("741 St. James St.");

        WebElement countryDropDown = driver.findElement(By.id("input-country"));
        Select countrySelect = new Select(countryDropDown);
        countrySelect.selectByValue("223");

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//option[text()='California']")));

        WebElement stateDropDown = driver.findElement(By.id("input-zone"));
        Select stateSelect = new Select(stateDropDown);
        stateSelect.selectByValue("3624");

        WebElement continueButton = driver.findElement(By.xpath("//input[@type='submit']"));
        continueButton.click();

        WebElement successMessage = driver.findElement(By.xpath("//div[contains(@class,'alert-success')]"));
        Assert.assertTrue(successMessage.getText().contains("successfully updated"));
    }

    @Test(dependsOnMethods = "addAddress", groups = "MyGroup")
    void deleteAddress() {
        WebElement deleteButton = driver.findElement(By.xpath("(//a[text()='Delete'])[2]"));
        deleteButton.click();

        WebElement successMessage = driver.findElement(By.xpath("//div[contains(@class,'alert-success')]"));
        Assert.assertTrue(successMessage.getText().contains("successfully deleted"));
    }
    //TODO: edit the code to select random country and random state/region
}