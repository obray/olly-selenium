package com.qmetric.tests;

import com.qmetric.utility.AbstractTest;
import com.qmetric.pages.LandingPage;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.*;

import static com.qmetric.utility.FrontendConstants.*;


public class PageOneUITest extends AbstractTest {

    @BeforeMethod
    public void getToPage1() {
        driver.get(enquiryCreationPostForm);

        LandingPage landingPage = PageFactory.initElements(driver, LandingPage.class);
        qsPage1 = landingPage.startNewEnquiry();
    }

    @Test
    public void testPageTitle() throws Exception {
        assert driver.getTitle().equals(FRONT_PAGE1_TITLE);
    }

    @Test
    public void testAddressSearchValidationText() throws Exception {
        qsPage1.clickFindAddress();

        assert qsPage1.postcodeErrorMsg.getText().equals(FRONT_PAGE1_VALIDATION_ADDRESS_SEARCH);
    }

    @Test
    public void testAddressSearch() throws Exception {
        qsPage1.searchOnPostcode(testCase.postcode);
        qsPage1.selectAddressFromList(testCase.addressListId);

        assert qsPage1.your_address.getText().equals(testCase.fullAddress);
    }

    @Test
    public void testAddressManualEdit() throws Exception {
        qsPage1.searchOnPostcode(testCase.postcode);
        qsPage1.selectAddressFromList(testCase.addressListId);
        qsPage1.clickEditAddress();
        qsPage1.editAddress("test line 1", "test line 2", "test line 3", "test line 4", "test town");

        assert qsPage1.address_line_1.getAttribute("value").equals("test line 1");
        assert qsPage1.address_line_2.getAttribute("value").equals("test line 2");
        assert qsPage1.address_line_3.getAttribute("value").equals("test line 3");
        assert qsPage1.address_line_4.getAttribute("value").equals("test line 4");
        assert qsPage1.address_town.getAttribute("value").equals("test town");
    }

    @Test
    public void testPropertyTypeDropDowns() throws Exception {

        qsPage1.property_type_house.click();
        qsPage1.selectPropertyType(qsPage1.property_type_house_description, "Detached house");
        qsPage1.property_type_other.click();
        qsPage1.property_type_house.click();

        assert qsPage1.property_type_house_description.getAttribute("value").equals("");

        qsPage1.property_type_flat.click();
        qsPage1.selectPropertyType(qsPage1.property_type_flat_description, "Flat or apartment - purpose built");
        qsPage1.property_type_other.click();
        qsPage1.property_type_flat.click();

        assert qsPage1.property_type_flat_description.getAttribute("value").equals("");

        qsPage1.property_type_bungalow.click();
        qsPage1.selectPropertyType(qsPage1.property_type_bungalow_description, "Detached bungalow");
        qsPage1.property_type_other.click();
        qsPage1.property_type_bungalow.click();

        assert qsPage1.property_type_bungalow_description.getAttribute("value").equals("");

        qsPage1.property_type_other.click();
        qsPage1.selectPropertyType(qsPage1.property_type_other_description, "Converted warehouse/church");
        qsPage1.property_type_house.click();
        qsPage1.property_type_other.click();

        assert qsPage1.property_type_other_description.getAttribute("value").equals("");
    }


}

