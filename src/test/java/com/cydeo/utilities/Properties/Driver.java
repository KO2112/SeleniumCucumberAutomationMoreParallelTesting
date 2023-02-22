package com.cydeo.utilities.Properties;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

import java.util.concurrent.TimeUnit;

public class Driver {
    /* CREATING A PRIVATE CONST SO WE ARE COSING ACCESS TO THE OBJECT OF THIS CLASS FROM OUTSIDE THE CLASS*/

    private Driver(){}

    // we make it private because we need getters and setters
    // we also make it static cus we will use it in a static method
    //private static WebDriver driver;
    private static InheritableThreadLocal<WebDriver> driverPool = new InheritableThreadLocal<>();
    public static WebDriver getDriver() {
        if (driverPool.get() == null){
            // get the browsertpe from configs, so we can control the browser type
            String browsertype = ConfigurationReader.getProperty("browser");
            switch (browsertype){
                case "chrome":
                    System.setProperty("webdriver.chrome.driver", "C:\\Users\\kemal\\Desktop\\Testing\\SeleniumCucumberAutomationMore\\SeleniumCucumberAutomationMore\\chromedriver.exe");
                    driverPool.set(new ChromeDriver());
                    driverPool.get().manage().window().maximize();
                    driverPool.get().manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
                    break;
                case "ie":
                    System.setProperty("webdriver.ie.driver", "drivers//IEDriverServer.exe");
                    driverPool.set(new InternetExplorerDriver());
                    driverPool.get().manage().window().maximize();
                    break;
                case "firefox":
                    WebDriverManager.firefoxdriver().setup();
                    driverPool.set(new FirefoxDriver());
                    driverPool.get().manage().window().maximize();
                    break;
            }

        }
        return driverPool.get();
    }
    public static void closedriver(){
        if (driverPool.get() !=null){
            driverPool.get().quit();
            driverPool.remove();
        }
    }
}
