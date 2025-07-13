package com.google;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import pages.Timer;
import pages.chrome.FirstChromePage;
import pages.chrome.GoogleSearchPage;
import pages.chrome.PopUpChromePage;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.net.MalformedURLException;
import java.net.URL;

public class firstTest {

    AndroidDriver driver;

    @BeforeEach
    public void beforeEach() throws MalformedURLException {
        UiAutomator2Options options = new UiAutomator2Options();
        options.setDeviceName("emulator-5554");
        options.setAutomationName("UiAutomator2");
        options.setPlatformName("Android");
        options.setPlatformVersion("15");
        options.setAppPackage("com.google.android.deskclock");
        options.setAppActivity("com.android.deskclock.DeskClock");
        options.setNoReset(false);
        options.setFullReset(false);
        driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), options);
    }

        @Test
    public void loadGoogleSearch() throws InterruptedException, MalformedURLException {
            Timer timer=new Timer(driver);
            Assertions.assertTrue(timer.isOnPage());
            timer.OnClick();

    }

//    @AfterEach
//    public void afterEach(){
//        driver.quit();
//    }
}
