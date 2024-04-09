package com.qa.stepdef;

import com.qa.stepdef.SharedDriverContext;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.Duration;
import java.util.Properties;

public class Hooks {

    public static AndroidDriver driver;
    protected static Properties properties;
    private InputStream propStream;
    private WebDriverWait wait;

    @Before
    public void initialize() throws Exception {
        properties = new Properties();
        String propertiesFileName = "argos.properties";
        propStream = getClass().getClassLoader().getResourceAsStream(propertiesFileName);
        properties.load(propStream);

        DesiredCapabilities caps = new DesiredCapabilities();
        caps.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
        caps.setCapability(MobileCapabilityType.PLATFORM_VERSION, "8.1");
        caps.setCapability(MobileCapabilityType.DEVICE_NAME, properties.getProperty("androidDeviceName"));
        caps.setCapability("newCommandTimeout", 300);
        caps.setCapability(MobileCapabilityType.AUTOMATION_NAME, properties.getProperty("androidAutomationName")); // Fixed typo here
        caps.setCapability("appActivity", properties.getProperty("androidAppActivity"));
        caps.setCapability("appPackage", properties.getProperty("androidAppName"));

        caps.setCapability("forceAppLaunch", true);
        caps.setCapability("autoGrantPermissions", true);
        URL url = new URL(properties.getProperty("appiumURL"));

        driver = new AndroidDriver(url, caps);git commit -m "first commit"
        SharedDriverContext.setDriver(driver);

        wait = new WebDriverWait(driver, Duration.ofMillis(5000));
    }

    @After
    public void quit(Scenario scenario) throws IOException {
        if (propStream != null) propStream.close();
        if (driver != null) {
            if (scenario.isFailed()) {
                // Capture and save screenshot in case of failure
                byte[] screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
                String screenshotName = scenario.getName().replaceAll(" ", "_") + "_screenshot.png";
                String screenshotDirectory = "screenshots";
                Path screenshotPath = Paths.get(screenshotDirectory, screenshotName);
                Files.createDirectories(screenshotPath.getParent());
                Files.write(screenshotPath, screenshot);

                // Attach screenshot to the report
                scenario.attach(screenshot, "image/png", screenshotName);
            }
            driver.quit();
        }
    }
}
