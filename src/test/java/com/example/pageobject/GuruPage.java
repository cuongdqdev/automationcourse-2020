package com.example.pageobject;

import com.example.util.Utils;
import org.openqa.selenium.By;

public class GuruPage {
    public String url = "http://live.demoguru99.com/";
    public String invalidEmail = "1234123@1234.123";
    public String email = "cuongdang@gmail.com";
    public String passwordLessThan6Chars = "1a2a";
    public String incorrectPassword = "123abcxyz";
    public String password = "cuongdang";
    public String fullName = "Cuong Dang";
    public String helloUser = "Hello, " + fullName + "!";
    public String titleDashboard = "MY DASHBOARD";
    public String randomFirstName = Utils.generateRandomAlphabeticString();
    public String randomLastName = Utils.generateRandomAlphabeticString();
    public String randomEmailAddress = Utils.generateRandomAlphanumericString() + "@email.com";
    public String loginTitle = "Customer Login";
    public String registerTitle = "Create New Customer Account";
    public String loginUrl = url + "index.php/customer/account/login/";
    public String registerUrl = url + "index.php/customer/account/create/";

    public String errorRequiredEmailMsg = "This is a required field.";
    public String errorRequiredPasswordMsg = "This is a required field.";
    public String errorInvalidEmail = "Please enter a valid email address. For example johndoe@domain.com.";
    public String errorInvalidPasswordMsg = "Please enter 6 or more characters without leading or trailing spaces.";
    public String errorInvalidCredentialMSg = "Invalid login or password.";
    public String successRegisterMsg = "Thank you for registering with Main Website Store.";

    public By txtMyAccount = By.xpath("//div[@class='footer']//a[@title='My Account']");
    public By inpEmail = By.xpath("//input[@id='email']");
    public By inpPass = By.xpath("//input[@id='pass']");
    public By btnLogin = By.xpath("//button[@id='send2']");
    public By txtErrorRequiredEmailMsg = By.xpath("//div[@id='advice-required-entry-email']");
    public By txtErrorRequiredPasswordMsg = By.xpath("//div[@id='advice-required-entry-pass']");
    public By txtErrorInvalidEmailMsg = By.xpath("//div[@id='advice-validate-email-email']");
    public By txtErrorInvalidPasswordMsg = By.xpath("//div[@id='advice-validate-password-pass']");
    public By txtErrorInvalidCredentialMsg = By.xpath("//li[@class='error-msg']//span");
    public By txtTitleDashboard = By.xpath("//div[@class='dashboard']/div[@class='page-title']");
    public By txtHelloUser = By.xpath("//div[@class='dashboard']/div[@class='welcome-msg']//strong");
    public By txtUserInformation = By.xpath("//h3[text()='Contact Information']/parent::div/following-sibling::div/p");
    public By txtAccount = By.xpath("//div[@class='account-cart-wrapper']//a[@data-target-element='#header-account']");
    public By txtLogOut = By.xpath("//div[@id='header-account']//li[last()]");
    public By txtCreateAnAccount = By.xpath("//a[@title='Create an Account']");
    public By inpFirstName = By.xpath("//input[@id='firstname']");
    public By inpLastName= By.xpath("//input[@id='lastname']");
    public By inpEmailAddress = By.xpath("//input[@id='email_address']");
    public By inpPassword = By.xpath("//input[@id='password']");
    public By inpConfirmPassword = By.xpath("//input[@id='confirmation']");
    public By txtRegister = By.xpath("//button[@title='Register']//span");
    public By txtSuccessRegisterMsg = By.xpath("//li[@class='success-msg']//span");

}
