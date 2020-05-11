package com.example.exercise;

import com.example.pageobject.AutomationFcPage;
import com.example.pageobject.GuruPage;
import com.example.util.Utils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class WebElementPractice extends AutomationFcPage {
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
    public void tc001_verifyDisplayed() {
        if(isElementDisplayed(tbEmail)) {
            driver.findElement(tbEmail).sendKeys("Automation Testing");
        }

        if(isElementDisplayed(rbAUnder18)) {
            driver.findElement(rbAUnder18).click();
        }

        if(isElementDisplayed(tbEducation)) {
            driver.findElement(tbEducation).sendKeys("Automation Testing");
        }
    }

    @Test
    public void tc002_verifyEnabled() {
        Assert.assertTrue(isElementEnabled(tbEmail));
        Assert.assertTrue(isElementEnabled(rbAUnder18));
        Assert.assertTrue(isElementEnabled(tbEducation));
        Assert.assertTrue(isElementEnabled(dpJobRole01));
        Assert.assertTrue(isElementEnabled(dpJobRole02));
        Assert.assertTrue(isElementEnabled(cbDevelopment));

        Assert.assertFalse(isElementEnabled(tbPassword));
        Assert.assertFalse(isElementEnabled(rbRadioButtonIsDisabled));
        Assert.assertFalse(isElementEnabled(txaBiography));
        Assert.assertFalse(isElementEnabled(dpJobRole03));
        Assert.assertFalse(isElementEnabled(cbCheckboxIsDisabled));
        Assert.assertFalse(isElementEnabled(sdSlider02));
    }

    @Test
    public void tc003_verifySelected() {
        if(isElementEnabled(rbAUnder18)) {
            driver.findElement(rbAUnder18).click();
        }

        Assert.assertTrue(driver.findElement(rbAUnder18).isSelected());

        if(isElementEnabled(cbDevelopment)) {
            driver.findElement(cbDevelopment).click();
        }

        Assert.assertTrue(driver.findElement(cbDevelopment).isSelected());

        if(isElementEnabled(rb18orOlder)) {
            driver.findElement(rb18orOlder).click();
        }
        Assert.assertFalse(driver.findElement(rbAUnder18).isSelected());

        if(isElementEnabled(cbDevelopment)) {
            driver.findElement(cbDevelopment).click();
        }
        Assert.assertFalse(driver.findElement(cbDevelopment).isSelected());

    }



    @AfterClass
    public void afterClass() {
        driver.quit();
    }

    public boolean isElementDisplayed(By by) {
        if(driver.findElement(by).isDisplayed()) {
            System.out.println("Element [ " + by + " ]  is DISPLAYED");
            return true;
        }
        System.out.println("Element [ " + by + " ] is NOT DISPLAYED");
        return false;

    }

    public boolean isElementEnabled(By by) {
        if(driver.findElement(by).isEnabled()) {
            System.out.println("Element [ " + by + " ] is ENABLED");
            return true;
        }
        System.out.println("Element [ " + by + " ] is DISABLED");
        return false;
    }

    public  boolean isElementSelected(By by) {
        if(driver.findElement(by).isSelected()) {
            System.out.println("Element [ " + by + " ] is SELECTED");
            return true;
        }
        System.out.println("Element [ " + by + " ] is NOT SELECTED");
        return false;
    }
}
