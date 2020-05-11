package com.example.base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class Base {
    WebDriver driver;

    private String url = "https://google.com.vn";

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
        String expectedUrl = "https://www.google.com.vn/";
        Assert.assertEquals(driver.getCurrentUrl(), expectedUrl);
    }

    @Test
    public void tc002_verifyTitle() {
        String expectedTitle = "Google";
        Assert.assertEquals(driver.getTitle(), expectedTitle);
    }

    @AfterClass
    public void afterClass() {
        driver.quit();
    }
}
