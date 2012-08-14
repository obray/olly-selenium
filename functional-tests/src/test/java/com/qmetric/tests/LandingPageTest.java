package com.qmetric.tests;

import com.qmetric.utility.AbstractTest;
import com.qmetric.pages.LandingPage;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static com.qmetric.utility.FrontendConstants.*;

public class LandingPageTest extends AbstractTest {

    @BeforeMethod
    public void getToPage1() {
        driver.get(enquiryCreationPostForm);

        LandingPage landingPage = PageFactory.initElements(driver, LandingPage.class);
    }

    @Test
    public void testPageTitle() throws Exception {
        System.out.println(driver.getTitle() + " in " + browserName);
        assert driver.getTitle().equals(FRONT_LANDING_PAGE_TITLE);
    }

}
