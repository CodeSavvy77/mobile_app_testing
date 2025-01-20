package tests;

import config.CapabilitiesManager;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.ios.IOSDriver;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utils.HelperFunctions;

import java.net.MalformedURLException;
import java.net.URL;

import static org.junit.Assert.assertEquals;

public class iOSTests {

    private AppiumDriver driver;

    @Before
    public void setUp() throws MalformedURLException {
        driver = new IOSDriver(new URL("http://127.0.0.1:4723/wd/hub"), CapabilitiesManager.getiOSCapabilities());
    }

    @Test
    public void testLogin() {
        String testName = "testLoginiOS";
        try {
            driver.findElement(By.id("username")).sendKeys("testuser");
            driver.findElement(By.id("password")).sendKeys("password");
            driver.findElement(By.id("login")).click();

            String welcomeMessage = driver.findElement(By.id("welcome_message")).getText();
            assertEquals("Welcome, testuser!", welcomeMessage);
        } catch (Exception e) {
            HelperFunctions.captureScreenshot(driver, testName);
            throw e;
        }
    }

    @After
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}