package com.example.exercise;

import com.example.pageobject.GuruPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class XpathPractice extends GuruPage {
    WebDriver driver;

    @BeforeClass
    public void beforeClass() {
        System.setProperty("webdriver.chrome.driver", "E:\\AUTOMATION-COURSE-2020\\webdriver\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.get(url);
    }

    @Test()
    private void tc001_verifyLoginWithEmptyEmailAndPassword() {
        driver.findElement(txtMyAccount).click();
        driver.findElement(inpEmail).sendKeys("");
        driver.findElement(inpPass).sendKeys("");
        driver.findElement(btnLogin).click();

        Assert.assertEquals(driver.findElement(txtErrorRequiredEmailMsg).getText(), errorRequiredEmailMsg);
        Assert.assertEquals(driver.findElement(txtErrorRequiredPasswordMsg).getText(), errorRequiredPasswordMsg);
    }

    @Test()
    private void tc002_verifyLoginWithInvalidEmail() {
        driver.findElement(txtMyAccount).click();
        driver.findElement(inpEmail).sendKeys(invalidEmail);
        driver.findElement(btnLogin).click();

        Assert.assertEquals(driver.findElement(txtErrorInvalidEmailMsg).getText(), errorInvalidEmail);
    }

    @Test()
    private void tc003_verifyLoginWithPasswordLessThan6Characters() {
        driver.findElement(txtMyAccount).click();
        driver.findElement(inpEmail).sendKeys(email);
        driver.findElement(inpPass).sendKeys(passwordLessThan6Chars);
        driver.findElement(btnLogin).click();

        Assert.assertEquals(driver.findElement(txtErrorInvalidPasswordMsg).getText(), errorInvalidPasswordMsg);
    }

    @Test()
    private void tc004_verifyLoginWithIncorrectPassword() {
        driver.findElement(txtMyAccount).click();
        driver.findElement(inpEmail).sendKeys(email);
        driver.findElement(inpPass).sendKeys(incorrectPassword);
        driver.findElement(btnLogin).click();

        Assert.assertEquals(driver.findElement(txtErrorInvalidCredentialMsg).getText(), errorInvalidCredentialMSg);
    }

    @Test()
    private void tc005_verifyLoginWithValidEmailAndPassword() {
        driver.findElement(txtMyAccount).click();
        driver.findElement(inpEmail).sendKeys(email);
        driver.findElement(inpPass).sendKeys(password);
        driver.findElement(btnLogin).click();

        Assert.assertEquals(driver.findElement(txtTitleDashboard).getText().toUpperCase(), titleDashboard);
        Assert.assertEquals(driver.findElement(txtHelloUser).getText(), helloUser);
        Assert.assertTrue(driver.findElement(txtUserInformation).getText().contains(fullName));
        Assert.assertTrue(driver.findElement(txtUserInformation).getText().contains(email));

        driver.findElement(txtAccount).click();
        driver.findElement(txtLogOut).click();
    }

    @Test()
    private void tc006_verifyCreateANewAccount() throws InterruptedException {
        driver.findElement(txtMyAccount).click();
        driver.findElement(txtCreateAnAccount).click();
        driver.findElement(inpFirstName).sendKeys(randomFirstName);
        driver.findElement(inpLastName).sendKeys(randomLastName);
        driver.findElement(inpEmailAddress).sendKeys(randomEmailAddress);
        driver.findElement(inpPassword).sendKeys(password);
        driver.findElement(inpConfirmPassword).sendKeys(password);
        driver.findElement(txtRegister).click();

        Assert.assertEquals(driver.findElement(txtSuccessRegisterMsg).getText(), successRegisterMsg);
        Assert.assertTrue(driver.findElement(txtUserInformation).getText().contains(randomFirstName));
        Assert.assertTrue(driver.findElement(txtUserInformation).getText().contains(randomLastName));
        Assert.assertTrue(driver.findElement(txtUserInformation).getText().contains(randomEmailAddress));

        driver.findElement(txtAccount).click();
        driver.findElement(txtLogOut).click();

        Thread.sleep(6000);
        Assert.assertEquals(driver.getTitle(), "Home page");
    }


    @AfterClass
    public void afterClass() {
        driver.quit();
    }
}
