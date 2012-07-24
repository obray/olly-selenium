package com.qmetric.utility;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

public class TestUtility {

    // Clear the text box, enter a new value and assert the value is stored
    public void testTextBoxInput(WebDriver driver, String element, String text) {
        driver.findElement(By.id(element)).clear();
        driver.findElement(By.id(element)).sendKeys(text);

        assert driver.findElement(By.id(element)).getAttribute("value").equals(text);
    }

    //
    public void testDropDownClears(WebDriver driver, String on, String off, String dropDown, String item) {
        driver.findElement(By.id(on)).click();

        Select droplist = new Select(driver.findElement(By.id(dropDown)));
        droplist.selectByVisibleText(item);

        assert driver.findElement(By.id(dropDown)).getAttribute("value").equals(item);

        driver.findElement(By.id(off)).click();
        driver.findElement(By.id(on)).click();

        assert driver.findElement(By.id(dropDown)).getAttribute("value").equals("");

    }
}
