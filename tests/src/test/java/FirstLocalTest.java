package com.qmetric.selenium;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;

public class FirstLocalTest {

    @Test
    public void testHTML() {

        WebDriver driver = new HtmlUnitDriver();

            // test starts in Codes entity list page
            driver.get("http://www.google.com");
            // Alternatively the same thing can be done like this
            // driver.navigate().to("http://www.google.com");

            // Find the text input element by its name
            WebElement element = driver.findElement(By.name("q"));

            // Enter something to search for
            element.sendKeys("Cheese!");

            // Check the title of the page
            System.out.println("Page title is: " + driver.getTitle());

            // Now submit the form. WebDriver will find the form for us from the element
            element.submit();

            // Google's search is rendered dynamically with JavaScript.
            // Wait for the page to load, timeout after 10 seconds
            (new WebDriverWait(driver, 10)).until(new ExpectedCondition<Boolean>() {
                public Boolean apply(WebDriver d) {
                    return d.getTitle().toLowerCase().startsWith("cheese!");
                }
            });

            // Check the title of the page
            System.out.println("Page title is: " + driver.getTitle());
    }
}
