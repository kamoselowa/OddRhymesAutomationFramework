package com.automation.tests.signin;

import java.net.URL;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.bidi.emulation.Emulation;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.devtools.DevTools;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.automation.basetest.BaseTest;

public class ServerError extends BaseTest {
  @Test
    public void ServerErrorSetup(){
        BaseSetup();
    }

 /*  @Test
//@DisplayName("L-05 - Server Error Simulation")
public void testServerErrorSimulation() {
    
    // Step 1: Go to a page where an API call happens (e.g. Feed, Post Verse, Profile)
    driver.get("https://oddrhymes.com/feed");   // or whichever page makes sense
    
    // Step 2: Enable DevTools and simulate network failure
    DevTools devTools = ((ChromeDriver) driver).getDevTools();
    devTools.createSession();
    
    devTools.send(Emulation.setOfflineMode(true));   // Simulate offline / server unreachable
    
    // Wait for error message
    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    WebElement errorMessage = wait.until(ExpectedConditions.visibilityOfElementLocated(
        By.xpath("//*[contains(text(), 'something went wrong') or contains(text(), 'try again later')]")
    ));

    // Assertion
    String actualText = errorMessage.getText().toLowerCase();
    Assert.assertTrue(actualText.contains("something went wrong") || 
                      actualText.contains("try again later"),
        "Expected server error message not displayed!");
    
    System.out.println("✅ L-05 Passed: Server error message displayed correctly.");
}*/

}
