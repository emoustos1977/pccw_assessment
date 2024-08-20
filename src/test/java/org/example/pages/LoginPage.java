ipackage org.example.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class LoginPage {

    private By usernameInput = By.id("username");
    private By passwordInput = By.id("password");
    private By loginBtn = By.id("submit");
    private By errorMessage = By.id("error");

    private WebDriver driver;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    public void goTo() {
        driver.get("https://practicetestautomation.com/practice-test-login/");
    }

    public void login(String username, String password) {
        driver.findElement(usernameInput).sendKeys(username);
        driver.findElement(passwordInput).sendKeys(password);
        driver.findElement(loginBtn).click();
    }

    public void verifyWrongUsername() {
        String expectedTest = "Your username is invalid!";
        String actualText = driver.findElement(errorMessage).getText();
        Assert.assertEquals(actualText, expectedTest);
    }

    public void verifyWrongPassword() {
        String expectedTest = "Your password is invalid!";
        String actualText = driver.findElement(errorMessage).getText();
        Assert.assertEquals(actualText, expectedTest);
    }
}
