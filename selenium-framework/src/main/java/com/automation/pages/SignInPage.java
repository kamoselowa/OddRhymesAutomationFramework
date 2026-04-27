package com.automation.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import com.automation.base.BasePage;

public class SignInPage extends BasePage {
    public SignInPage(WebDriver driver) {
        super(driver);
        //TODO Auto-generated constructor stub
    }

    private WebDriver driver;
    

    @FindBy(how = How.ID,using = "email")
    WebElement EmailEntry;
    
    @FindBy(how = How.ID,using = "password")
    WebElement PasswordEntry;

    @FindBy(how = How.XPATH,using="//button[normalize-space()='Forgot password?']")
    WebElement ForgotPassword;

    @FindBy(how = How.XPATH,using="//a[normalize-space()='Learn more about us']")
    WebElement LearnMore;


    @FindBy(how = How.XPATH,using ="//div[@class='logo-badge ng-tns-c2439698414-2']")
    WebElement Logo;

    @FindBy(how = How.XPATH, using = "//h1[normalize-space()='Odd Rhymes']")
    WebElement PageTitle;

    public void PageTitle(){
        PageTitle.isDisplayed()
    }

    public void Logo(){
        Logo.isDisplayed();
        

    }

    public void RegistredUserEmail(){

    }
    public void ValidPassword(){

    }
    public void UnRegisteredEmail(){

    }
    public void InvalidPassword(){

    }
    public void WeakPassword(){

    }
    public void EmptyPasswordFiled(){

    }
    public void InvalidEmailFormat(){
        
    }
    
    
}
