package com.automation.listeners;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import com.automation.basetest.BaseTest;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class ExtentTestListener implements ITestListener {

    private static final ThreadLocal<ExtentTest> TEST = new ThreadLocal<>();
    private static ExtentReports extent;
    private static Path reportDirectory;

    @Override
    public void onStart(ITestContext context) {
        String timestamp = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd_HH-mm-ss"));
        reportDirectory = Path.of("target", "extent-reports");

        try {
            Files.createDirectories(reportDirectory);
        } catch (Exception e) {
            throw new IllegalStateException("Unable to create Extent Reports directory", e);
        }

        ExtentSparkReporter spark = new ExtentSparkReporter(
                reportDirectory.resolve("ExtentReport-" + timestamp + ".html").toFile());
        spark.config().setDocumentTitle("OddRhymes Automation Report");
        spark.config().setReportName("Selenium Test Execution");
        spark.config().setTheme(Theme.DARK);

        extent = new ExtentReports();
        extent.attachReporter(spark);
        extent.setSystemInfo("Application", "OddRhymes");
        extent.setSystemInfo("Environment", "QA");
        extent.setSystemInfo("Java", System.getProperty("java.version"));
        extent.setSystemInfo("OS", System.getProperty("os.name"));
        extent.setSystemInfo("Browser", getConfiguredBrowser());
    }

    @Override
    public void onTestStart(ITestResult result) {
        String testName = result.getMethod().getMethodName();
        ExtentTest test = extent.createTest(testName);

        String description = result.getMethod().getDescription();
        if (description != null && !description.isBlank()) {
            test.assignCategory(description);
        }

        TEST.set(test);
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        TEST.get().log(Status.PASS, "Test passed");
    }

    @Override
    public void onTestFailure(ITestResult result) {
        ExtentTest test = TEST.get();
        test.log(Status.FAIL, result.getThrowable());

        WebDriver driver = getDriver(result);
        if (driver != null) {
            try {
                File screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
                Path screenshotsDirectory = reportDirectory.resolve("screenshots");
                Files.createDirectories(screenshotsDirectory);

                String testName = result.getMethod().getMethodName();
                String timestamp = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyyMMdd_HHmmss_SSS"));
                Path destination = screenshotsDirectory.resolve(testName + "_" + timestamp + ".png");
                Files.copy(screenshot.toPath(), destination, StandardCopyOption.REPLACE_EXISTING);

                test.fail("Failure screenshot",
                        MediaEntityBuilder.createScreenCaptureFromPath(
                                "screenshots/" + destination.getFileName()).build());
            } catch (Exception e) {
                test.log(Status.WARNING, "Screenshot capture failed: " + e.getMessage());
            }
        }
    }

    @Override
    public void onTestSkipped(ITestResult result) {
        TEST.get().log(Status.SKIP, "Test skipped");
        if (result.getThrowable() != null) {
            TEST.get().log(Status.SKIP, result.getThrowable());
        }
    }

    @Override
    public void onFinish(ITestContext context) {
        if (extent != null) {
            extent.flush();
        }
        TEST.remove();
    }

    private WebDriver getDriver(ITestResult result) {
        Object instance = result.getInstance();
        if (instance instanceof BaseTest) {
            return ((BaseTest) instance).driver;
        }
        return null;
    }

    private String getConfiguredBrowser() {
        try {
            return new com.automation.utils.ConfigReader().getBrowser();
        } catch (RuntimeException e) {
            return "Not configured";
        }
    }
}
