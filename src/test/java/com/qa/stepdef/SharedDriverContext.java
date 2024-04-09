package com.qa.stepdef;

import io.appium.java_client.android.AndroidDriver;

import java.io.OutputStream;

public class SharedDriverContext {
    private static AndroidDriver driver;

    public static AndroidDriver getDriver() {
        return driver;
    }

    public static void setDriver(AndroidDriver driver) {
        SharedDriverContext.driver = driver;
    }

    public static OutputStream getScenario() {
        return null;
    }
}

