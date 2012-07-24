package com.qmetric.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import static com.qmetric.utility.FrontendConstants.*;

public class LandingPage {
    final WebDriver driver;

    @FindBy(how = How.XPATH, using = FRONT_LANDING_PAGE_NEW_ENQUIRY_BUTTON)
    public WebElement newEnquiryButton;

    public LandingPage(WebDriver driver) {
        this.driver = driver;
    }

    public void clickNewEnquiry() {
        newEnquiryButton.click();
    }

    public QSPage1 startNewEnquiry() {
        clickNewEnquiry();
        return PageFactory.initElements(driver, QSPage1.class);
    }
}
