package com.example.exercise;

import com.example.pageobject.GuruPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class WebBrowserPractice extends GuruPage {
    WebDriver driver;

    @BeforeClass
    public void beforeClass() {
        System.setProperty("webdriver.chrome.driver", "E:\\AUTOMATION-COURSE-2020\\webdriver\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.get(url);
    }

    @Test
    public void tc001_verifyUrl() {
        driver.findElement(txtMyAccount).click();
        Assert.assertEquals(driver.getCurrentUrl(), loginUrl);

        driver.findElement(txtCreateAnAccount).click();
        Assert.assertEquals(driver.getCurrentUrl(), registerUrl);
    }

    @Test
    public void tc002_verifyTitle() {
        driver.findElement(txtMyAccount).click();
        Assert.assertEquals(driver.getTitle(), loginTitle);

        driver.findElement(txtCreateAnAccount).click();
        Assert.assertEquals(driver.getTitle(), registerTitle);
    }

    @Test
    public void tc003_verifyNavigate() {
        driver.findElement(txtMyAccount).click();
        driver.findElement(txtCreateAnAccount).click();

        Assert.assertEquals(driver.getCurrentUrl(), registerUrl);

        driver.navigate().back();
        Assert.assertEquals(driver.getCurrentUrl(), loginUrl);

        driver.navigate().forward();
        Assert.assertEquals(driver.getCurrentUrl(), registerUrl);
    }

    @Test
    public void tc004_verifyPageSourceCode() {
        String expectedLoginPageStr = "Login or Create an Account";
        String expectedRegisterPageStr = "Create an Account";
        driver.findElement(txtMyAccount).click();
        Assert.assertTrue(driver.getPageSource().contains(expectedLoginPageStr));

        driver.findElement(txtCreateAnAccount).click();
        Assert.assertTrue(driver.getPageSource().contains(expectedRegisterPageStr));
    }

    @AfterClass
    public void afterClass() {
        driver.quit();
    }
}
