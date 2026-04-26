package com.automation.base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class BasePage {

    protected WebDriver driver;
    public BasePage(WebDriver driver){
            this.driver = driver;

        }

    public WebDriver getDriver(String browser){
        
        if (browser.equalsIgnoreCase("chrome")){
            driver = new ChromeDriver();
        }
        else if(browser.equalsIgnoreCase("firefox")){
            driver = new FirefoxDriver();
        }
        else{
            driver = new EdgeDriver();
        }
        return driver;
    }
        public void quitDriver(){
            quitDriver();
        }
        
        
         
}
