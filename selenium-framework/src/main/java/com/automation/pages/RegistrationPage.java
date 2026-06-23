package com.automation.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import com.automation.base.BasePage;

public class RegistrationPage extends BasePage {

    


    public RegistrationPage(WebDriver driver) {
        super(driver);
        //TODO Auto-generated constructor stub
    }

    private WebDriver driver;

    @FindBy(how = How.ID,using = "username")
    WebElement UserNameEntry;

    @FindBy(how = How.ID,using = "email")
    WebElement EMailEntry;

    @FindBy(how = How.ID,using = "password")
    WebElement PasswordEntry;

    @FindBy(how = How.XPATH, using = "//span[@class='ng-tns-c712066932-2 ng-star-inserted']")
    WebElement CreateAccountBtn;

    @FindBy(how = How.XPATH, using ="//button[normalize-space()='Sign In']")
    WebElement SignInBtn;

    public void NewUsernameEntry(){
        getUserName().sendKeys(); //Entry For New User Information
    }
    public void NewEmailEntry(){
        getEmail().sendKeys(); //Entry for new user Email
    }
    public void NewPassowordEntry(){
        getPassWord().sendKeys();// new Password for new user
    }
    public void CreateBtn(){
        getCreateBtnElement().click();;
    }
     
    
  
   public WebElement getUserName(){
    wait.waitForVisibilityOFElement(UserNameEntry);
    return UserNameEntry;
   }

   public WebElement getEmail(){
    wait.waitForVisibilityOFElement(EMailEntry);
    return EMailEntry;
   }
   public WebElement getPassWord(){
       wait.waitForVisibilityOFElement(PasswordEntry);
    return PasswordEntry;
   }

   public WebElement getSignIn(){
       wait.waitForVisibilityOFElement(SignInBtn);
    return SignInBtn ;
   }
   
    
   public WebElement getCreateBtnElement(){
    wait.waitForVisibilityOFElement(CreateAccountBtn);
    wait.WaitForElementToBeClickable(CreateAccountBtn);
    return CreateAccountBtn;

   }
    public void openRegistrationPage(){
    getCreateBtnElement().click();
   }
   
   
}
