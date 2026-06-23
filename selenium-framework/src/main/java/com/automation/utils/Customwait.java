package com.automation.utils;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Customwait {

    private WebDriver driver;
    private WebDriverWait wait;

    public Customwait(WebDriver driver ,Duration timeout){
        this.driver = driver;
        this.wait = new WebDriverWait(driver, timeout);

    }

    public void waitForVisibilityOFElement(WebElement element){
        try {
             wait.until(ExpectedConditions.visibilityOf(element));
        } catch (Exception e) {
            //e.printStackTrace();
            System.err.println("Element is not visible after waiting : " + e.getMessage());
        }
    
       
    }
    public void WaitForElementToBeClickable(WebElement element){
       try {
         wait.until(ExpectedConditions.elementToBeClickable(element));
       } catch (Exception e) {
         System.err.println("Element is not clicable : " + e.getMessage());
       }
    }
}