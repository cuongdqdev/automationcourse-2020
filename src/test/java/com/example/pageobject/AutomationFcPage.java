package com.example.pageobject;

import org.openqa.selenium.By;

public class AutomationFcPage {
    public String url = "https://automationfc.github.io/basic-form/index.html";

    public By tbEmail = By.xpath("//input[@id='mail']");
    public By rbAUnder18 = By.xpath("//input[@id='under_18']");
    public By rb18orOlder = By.xpath("//input[@id='over_18']");
    public By tbEducation = By.xpath("//textarea[@id='edu']");
    public By dpJobRole01 = By.xpath("//select[@id='job1']");
    public By dpJobRole02 = By.xpath("//select[@id='job2']");
    public By cbDevelopment = By.xpath("//input[@id='development']");
    public By sdSlider01 = By.xpath("//input[@id='slider-1']");
    public By tbPassword = By.xpath("//input[@id='password']");
    public By rbRadioButtonIsDisabled = By.xpath("//input[@id='radio-disabled']");
    public By dpJobRole03 = By.xpath("//select[@id='job3']");
    public By cbCheckboxIsDisabled = By.xpath("//input[@id='check-disbaled']");
    public By sdSlider02 = By.xpath("//input[@id='slider-2']");
    public By txaBiography = By.xpath("//textarea[@id='bio']");
}
