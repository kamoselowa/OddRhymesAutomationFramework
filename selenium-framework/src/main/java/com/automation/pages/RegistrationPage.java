package com.automation.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import com.automation.base.BasePage;

public class RegistrationPage extends BasePage {

    public RegistrationPage(WebDriver driver) {
        super(driver);
    }

    // ==========================
    // Page Elements
    // ==========================

    @FindBy(how = How.ID, using = "username")
    private WebElement usernameEntry;

    @FindBy(how = How.ID, using = "email")
    private WebElement emailEntry;

    @FindBy(how = How.ID, using = "password")
    private WebElement passwordEntry;


    @FindBy(how = How.XPATH, using = "//button[normalize-space()='Create Account']")
    private WebElement createAccountButton;

    @FindBy(how = How.XPATH, using = "//button[normalize-space()='Sign In']")
    private WebElement signInButton;

    // ==========================
    // Element Getters
    // ==========================

    public WebElement getUsernameElement() {
        wait.waitForElementVisible(usernameEntry);
        return usernameEntry;
    }

    public WebElement getEmailElement() {
        wait.waitForElementVisible(emailEntry);
        return emailEntry;
    }

    public WebElement getPasswordElement() {
        wait.waitForElementVisible(passwordEntry);
        return passwordEntry;
    }

    public WebElement getCreateAccountButton() {
        wait.waitForElementVisible(createAccountButton);
        wait.WaitForElementToBeClickable(createAccountButton);
        return createAccountButton;
    }

    public WebElement getSignInButton() {
        wait.waitForElementVisible(signInButton);
        wait.WaitForElementToBeClickable(signInButton);
        return signInButton;
    }

    // ==========================
    // Page Actions
    // ==========================

    public void enterUsername(String username) {
        getUsernameElement().clear();
        getUsernameElement().sendKeys(username);
    }

    public void enterEmail(String email) {
        getEmailElement().clear();
        getEmailElement().sendKeys(email);
    }

    public void enterPassword(String password) {
        getPasswordElement().clear();
        getPasswordElement().sendKeys(password);
    }

    public void clickCreateAccount() {
        getCreateAccountButton().click();
    }

    public void clickSignIn() {
        getSignInButton().click();
    }

    // ==========================
    // Business Methods
    // ==========================

    public void registerUser(String username,
                             String email,
                             String password) {

        enterUsername(username);
        enterEmail(email);
        enterPassword(password);
        clickCreateAccount();
    }
    public boolean isEmailFieldInvalid() {

        String classes = getEmailElement().getAttribute("class");

        return classes.contains("ng-invalid");
    }
    public boolean isPasswordFieldInvalid() {

        String classes = getPasswordElement().getAttribute("class");

        return classes.contains("ng-invalid");
    }
    public String getCurrentUrl() {
        return driver.getCurrentUrl();
    }

}