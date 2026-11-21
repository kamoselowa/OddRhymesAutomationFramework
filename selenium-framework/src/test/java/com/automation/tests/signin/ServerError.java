package com.automation.tests.signin;

import java.time.Duration;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.automation.basetest.BaseTest;

public class ServerError extends BaseTest {

    @Test(
            description = "L-05 - Server Error Simulation",
            groups = {"regression"})
    public void serverErrorIsShownWhenSignInRequestCannotReachServer() {
        Assert.assertTrue(
                driver instanceof ChromeDriver,
                "L-05 uses Chrome DevTools and requires BROWSER=Chrome.");

        WebDriverWait browserWait = new WebDriverWait(driver, Duration.ofSeconds(10));
        browserWait.until(ExpectedConditions.visibilityOfElementLocated(By.id("email")));

        ChromeDriver chromeDriver = (ChromeDriver) driver;
        chromeDriver.executeCdpCommand("Network.enable", Map.of());
        chromeDriver.executeCdpCommand(
                "Network.emulateNetworkConditions",
                Map.of(
                        "offline", true,
                        "latency", 0,
                        "downloadThroughput", 0,
                        "uploadThroughput", 0));

        signInPage.login("server-error@example.com", "NotARealPassword123!");

        String errorMessage = browserWait.until(
                ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".error-message")))
                .getText()
                .trim();

        Assert.assertFalse(errorMessage.isEmpty(), "The server error message should not be empty.");
    }
}
