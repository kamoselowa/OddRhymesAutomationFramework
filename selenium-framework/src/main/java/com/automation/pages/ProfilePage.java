package com.automation.pages;

import com.automation.base.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class ProfilePage extends BasePage {

    public ProfilePage(WebDriver driver ){
        super(driver);
    }
    //========Page Elements========

    @FindBy(how = How.XPATH, using = "//div[@class='profile-header text-center mb-5 ng-tns-c4284522105-3 ng-trigger ng-trigger-profileEnter ng-star-inserted']")
    private WebElement ProfileSection;

    public WebElement getProfile(){
      return ProfileSection;
    }
}
