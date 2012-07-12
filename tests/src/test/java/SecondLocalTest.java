package com.qmetric.selenium;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SecondLocalTest {

    @Test
    public void testHTML() {

        WebDriver driver = new HtmlUnitDriver();

            // test starts in Codes entity list page
            driver.get("https://localhost");
            // Alternatively the same thing can be done like this
            // driver.navigate().to("http://www.google.com");

            // Check the title of the page
            System.out.println("Page title is: " + driver.getTitle());
    }
}
