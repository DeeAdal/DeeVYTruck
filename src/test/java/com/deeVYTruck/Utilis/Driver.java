package com.deeVYTruck.Utilis;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Driver {
    // Creating a private constructor, so we are closing access to the object of this class
    // from outside any class
    private Driver(){}

    /*
    Making our 'driver' instance private, so that it is not reachable from outside of any class
    We make it static, because we want it to run befor anyting else.
    Also we will use it in static method
     */
    private static InheritableThreadLocal<WebDriver> driverpool = new InheritableThreadLocal<>();


    /*
    Create re-useable utility method which will return same driver instance when we call it>
     */
    public static WebDriver getDriver(){

        if(driverpool.get() == null){ // If driver/browser was never opened

            String browserType = ConfigurationReader.getProperty("browser");
                /*
                Depending on the browserType out switch statement will determine to open specific type of
                browser/driver
                 */
            switch (browserType) {
                case "chrome":
                    WebDriverManager.chromedriver().setup();
                    driverpool.set(new ChromeDriver());
                    driverpool.get().manage().window().maximize();
                    // driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
                    break;

                case "firefox":
                    WebDriverManager.chromedriver().setup();
                    driverpool.set(new FirefoxDriver());
                    driverpool.get().manage().window().maximize();
                    // driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
                    break;

            }


        }
        // Same driver instance will be returned every time we call Driver.getDriver() method
        return driverpool.get();
    }

    public static void closeDriver(){
        if(driverpool.get() !=null) {
            driverpool.get() .quit(); // this line will kill the session. value will noy be null
            driverpool.remove();
        }
    }

}
