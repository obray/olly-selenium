package com.qmetric.selenium;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

public class SecondCiTest {

    @Test
    public void testFirefox()  throws MalformedURLException, IOException {

        DesiredCapabilities browser = DesiredCapabilities.firefox();

        testCodesCrud(browser);
    }

     @Test
    public void testChrome()  throws MalformedURLException, IOException {

        DesiredCapabilities browser = DesiredCapabilities.chrome();

        testCodesCrud(browser);
    }

    public void testCodesCrud(DesiredCapabilities browser)
            throws MalformedURLException, IOException {
        WebDriver driver = null;
        try {
            driver = new RemoteWebDriver(
                new URL("http://ec2-46-137-83-19.eu-west-1.compute.amazonaws.com:4444/wd/hub"), browser);

            // test starts in Codes entity list page
            driver.get("https://localhost");
            // Alternatively the same thing can be done like this
            // driver.navigate().to("http://www.google.com");
         

             // Check the title of the page
            System.out.println("Page title is: " + driver.getTitle());

            // rest of test commands come here
        } finally {
            if (driver != null) {
                driver.quit();
            }
        }
    }
}
