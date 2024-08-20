package org.example;

import org.example.pages.LoginPage;
import org.example.pages.LogoutPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

public class TestCases {

    LoginPage loginPage;
    LogoutPage logoutPage;
    WebDriver driver;

    @BeforeMethod
    public void setup() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--disable-search-engine-choice-screen");
        driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        loginPage = new LoginPage(driver);
        logoutPage = new LogoutPage(driver);
        loginPage.goTo();
    }

    @Test
    public void positiveLogInTest() {
        loginPage.login("student", "Password123");
        logoutPage.verifySuccessfulLogin();
    }

    @Test
    public void negativeUsernameTest() {
        loginPage.login("incorrectUser", "Password123");
        loginPage.verifyWrongUsername();
    }

    @Test
    public void negativePasswordTest() {
        loginPage.login("student", "incorrectPassword");
        loginPage.verifyWrongPassword();
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }
}
