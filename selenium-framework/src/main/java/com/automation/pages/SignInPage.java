package com.automation.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import com.automation.base.BasePage;

public class SignInPage extends BasePage {
    private WebDriver driver;

    @FindBy(how = How.ID,using = "email")
    WebElement EmailEntry;
    
    @FindBy(how = How.ID,using = "password")
    WebElement PasswordEntry;

    @FindBy(how = How.XPATH,using="//button[normalize-space()='Forgot password?']")
    WebElement ForgotPassword;

    @FindBy(how = How.XPATH,using="//a[normalize-space()='Learn more about us']")
    WebElement LearnMore;
    
    
}
