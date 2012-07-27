package com.qmetric.tests;

import com.qmetric.pages.LandingPage;
import com.qmetric.utility.AbstractTest;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static com.qmetric.utility.FrontendConstants.FRONT_PAGE1_TITLE;

public class LandingPageTest extends AbstractTest {

    @BeforeMethod
    public void getToLandingPage() {
        driver.get(enquiryCreationPostForm);

        LandingPage landingPage = PageFactory.initElements(driver, LandingPage.class);
    }

    @Test
    public void testPageTitle() throws Exception {
        System.out.println(driver.getTitle() + " in " + browserName);
        //assert driver.getTitle().equals(FRONT_PAGE1_TITLE);
    }
}
