package com.cydeo.nodeseleniumgrid;

import com.cydeo.utilities.Properties.Driver;
import org.openqa.selenium.Platform;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.Test;
import java.net.MalformedURLException;
import java.net.URL;

public class SeleniumGrid {
    @Test
    public void test1() throws MalformedURLException {
            DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
            desiredCapabilities.setBrowserName("chrome");
            desiredCapabilities.setPlatform(Platform.WIN10);
            new RemoteWebDriver(new URL("http://localhost:4444"), desiredCapabilities);
            Driver.getDriver().get("https://www.google.com/");
    }
    @Test
    public void test2() throws MalformedURLException {
        DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
        desiredCapabilities.setBrowserName("firefox");
        desiredCapabilities.setPlatform(Platform.WIN10);
        new RemoteWebDriver(new URL("http://localhost:4444"), desiredCapabilities);
        Driver.getDriver().get("https://www.google.com/");
    }
}
