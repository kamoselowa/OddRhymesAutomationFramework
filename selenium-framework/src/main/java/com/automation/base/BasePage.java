package com.automation.base;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.PageFactory;

import com.automation.utils.ConfigReader;
import com.automation.utils.Customwait;

public class BasePage {

    protected WebDriver driver;
    protected Customwait wait;
    protected ConfigReader configReader;

    public BasePage(WebDriver driver){
            this.driver = driver;
            configReader = new ConfigReader();
            PageFactory.initElements(driver, this);
            this.wait = new CustomWait(driver,Duration.ofSeconds(configReader.getGlobalWait()));

        }
        

    public WebDriver getDriver(String browser){
        
        if (browser.equalsIgnoreCase("chrome")){
            ChromeOptions options = new ChromeOptions();
            options.addArguments("--incognito");
            driver = new ChromeDriver(options);
            driver.manage().window().maximize();
        }
        else if(browser.equalsIgnoreCase("firefox")){
            driver = new FirefoxDriver();
            driver.manage().window().maximize();
        }
        else{
            driver = new EdgeDriver();
            driver.manage().window().maximize();
        }
        return driver;
    }
        public void quitDriver(){
            quitDriver();
        }
        
        
         
}
