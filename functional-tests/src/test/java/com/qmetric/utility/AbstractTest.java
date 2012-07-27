package com.qmetric.utility;

import com.gargoylesoftware.htmlunit.BrowserVersion;
import com.qmetric.pages.QSPage1;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;


import java.net.URL;
import java.util.concurrent.TimeUnit;

public class AbstractTest {

protected WebDriver driver;

    protected String enquiryCreationPostForm;

    protected QSPage1 qsPage1;

    protected TestCase testCase;

    protected String browserName;

    @Parameters({"hubHost", "hubPort", "browserId", "defaultWebappUrl", "enquiryCreationPostForm", "browserVersion"})
    @BeforeClass
    public void setUp(final String hubHost, final int hubPort, final String browserId, final String defaultWebappUrl,
                      final String enquiryCreationPostForm, final String browserVersion) throws Exception {
        this.enquiryCreationPostForm = enquiryCreationPostForm;

        DesiredCapabilities browser = new DesiredCapabilityFactory().create(Browser.lookupBrowserBy(browserId));
        browser.setVersion(browserVersion);


        driver = new RemoteWebDriver(new URL("http://" + hubHost + ":" + hubPort + "/wd/hub"), browser);

        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        browserName = browserId + " " + browserVersion;

        testCase = new TestCase();
    }

    @AfterClass
    public void tearDown() throws Exception {
        if (driver != null) {
            driver.quit();
        }
    }
}
