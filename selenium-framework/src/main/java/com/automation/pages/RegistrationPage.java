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


    public void 
   
    

}
