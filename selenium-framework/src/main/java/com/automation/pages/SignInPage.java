package com.automation.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import com.automation.base.BasePage;

public class SignInPage extends BasePage {

    public SignInPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(how = How.ID, using = "email")
    WebElement emailEntry;

    @FindBy(how = How.ID, using = "password")
    WebElement passwordEntry;

    @FindBy(how = How.XPATH, using = "//button[@type='submit']")
    WebElement signInButton;

    @FindBy(how = How.XPATH, using = "//button[normalize-space()='Forgot password?']")
    WebElement forgotPassword;

    @FindBy(how = How.XPATH, using = "//a[normalize-space()='Learn more about us']")
    WebElement learnMore;

    @FindBy(how = How.XPATH, using = "//h1[normalize-space()='Odd Rhymes']")
    WebElement pageTitle;

    @FindBy(how = How.XPATH, using = "//div[contains(@class,'logo-badge')]")
    WebElement logo;

    // 👉 dynamic quote (adjust locator!)
    @FindBy(how = How.XPATH, using = "//div[contains(@class,'quote')]")
    WebElement quoteText;

    // 👉 example error message
    @FindBy(how = How.XPATH, using = "//div[contains(@class,'error')]")
    WebElement errorMessage;

    // ===== PAGE VALIDATION =====

    public boolean isPageLoaded( ) {
        return pageTitle.isDisplayed() && logo.isDisplayed() ;
    }

    public String getPageTitleText() {
        return pageTitle.getText();
    }

    // ===== INPUT ACTIONS =====

    public void enterEmail(String email) {
        emailEntry.clear();
        emailEntry.sendKeys(email);
    }

    public void enterPassword(String password) {
        passwordEntry.clear();
        passwordEntry.sendKeys(password);
    }

    public void clickSignIn() {
        signInButton.click();
    }

    public void login(String email, String password) {
        enterEmail(email);
        enterPassword(password);
        clickSignIn();
    }

    // ===== LINK ACTIONS =====

    public void clickForgotPassword() {
        forgotPassword.click();
    }

    public void clickLearnMore() {
        learnMore.click();
    }

    // ===== VALIDATIONS =====

    public String getErrorMessage() {
        return errorMessage.getText();
    }

    public boolean isErrorDisplayed() {
        return errorMessage.isDisplayed();
    }

    // ===== DYNAMIC CONTENT =====

    public String getQuoteText() {
        return quoteText.getText();
    }

    public boolean isQuoteNotEmpty() {
        return !quoteText.getText().trim().isEmpty();
    }

    public boolean doesQuoteChange() {
        String first = quoteText.getText();

        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        String second = quoteText.getText();
        return !first.equals(second);
    }
}