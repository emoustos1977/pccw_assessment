package org.example.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class LogoutPage {

    private By successMessage = By.xpath("//h1[text()='Logged In Successfully']");
    private By logoutBtn = By.xpath("//*[@id='loop-container']//a");

    private WebDriver driver;

    public LogoutPage(WebDriver driver) {
        this.driver = driver;
    }

    public void verifySuccessfulLogin() {
        // Verify new page URL contains practicetestautomation.com/logged-in-successfully/
        String expectedUrl = "https://practicetestautomation.com/logged-in-successfully/";
        String actualUrl = driver.getCurrentUrl();
        Assert.assertEquals(actualUrl, expectedUrl);
        // Verify new page contains expected text ('Congratulations' or 'successfully logged in')
        Assert.assertTrue(driver.findElement(successMessage).isDisplayed());
        // Verify button Log out is displayed on the new page
        Assert.assertTrue(driver.findElement(logoutBtn).isDisplayed());
    }
}
