package com.qmetric.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.Select;

import static com.qmetric.utility.FrontendConstants.*;


public class QSPage1 {

    final WebDriver driver;

    @FindBy(how = How.ID_OR_NAME, using = FRONT_PAGE1_ADDRESS_SEARCH_BUTTON)
    public WebElement addressSearch;

    @FindBy(how = How.ID_OR_NAME, using = FRONT_PAGE1_POSTCODE_ERROR_MESSAGE)
    public WebElement postcodeErrorMsg;

    @FindBy(how = How.ID_OR_NAME, using = FRONT_PAGE1_POSTCODE_TEXTBOX)
    public WebElement property_postcode;

    @FindBy(how = How.ID_OR_NAME, using = FRONT_PAGE1_POSTCODE_LIST)
    public WebElement nobranch;

    @FindBy(how = How.ID_OR_NAME, using = FRONT_PAGE1_ADDRESS_TEXT)
    public WebElement your_address;

    @FindBy(how = How.PARTIAL_LINK_TEXT, using = FRONT_PAGE1_EDIT_ADDRESS_LINK)
    public WebElement editAddress;

    @FindBy(how = How.ID_OR_NAME, using = FRONT_PAGE1_ADDRESS_LINE1_TEXTBOX)
    public WebElement address_line_1;

    @FindBy(how = How.ID_OR_NAME, using = FRONT_PAGE1_ADDRESS_LINE2_TEXTBOX)
    public WebElement address_line_2;

    @FindBy(how = How.ID_OR_NAME, using = FRONT_PAGE1_ADDRESS_LINE3_TEXTBOX)
    public WebElement address_line_3;

    @FindBy(how = How.ID_OR_NAME, using = FRONT_PAGE1_ADDRESS_LINE4_TEXTBOX)
    public WebElement address_line_4;

    @FindBy(how = How.ID_OR_NAME, using = FRONT_PAGE1_ADDRESS_TOWN_TEXTBOX)
    public WebElement address_town;

    @FindBy(how = How.CLASS_NAME, using = FRONT_PAGE1_PROPERTY_TYPE_HOUSE)
    public WebElement property_type_house;

    @FindBy(how = How.CLASS_NAME, using = FRONT_PAGE1_PROPERTY_TYPE_FLAT)
    public WebElement property_type_flat;

    @FindBy(how = How.CLASS_NAME, using = FRONT_PAGE1_PROPERTY_TYPE_BUNGALOW)
    public WebElement property_type_bungalow;

    @FindBy(how = How.CLASS_NAME, using = FRONT_PAGE1_PROPERTY_TYPE_OTHER)
    public WebElement property_type_other;

    @FindBy(how = How.ID_OR_NAME, using = FRONT_PAGE1_PROPERTY_TYPE_HOUSE_DESCRIPTION)
    public WebElement property_type_house_description;

    @FindBy(how = How.ID_OR_NAME, using = FRONT_PAGE1_PROPERTY_TYPE_FLAT_DESCRIPTION)
    public WebElement property_type_flat_description;

    @FindBy(how = How.ID_OR_NAME, using = FRONT_PAGE1_PROPERTY_TYPE_BUNGALOW_DESCRIPTION)
    public WebElement property_type_bungalow_description;

    @FindBy(how = How.ID_OR_NAME, using = FRONT_PAGE1_PROPERTY_TYPE_OTHER_DESCRIPTION)
    public WebElement property_type_other_description;

    public QSPage1(WebDriver driver) {
        this.driver = driver;
    }

    public void enterPostcode(String postcode) {
        property_postcode.clear();
        property_postcode.sendKeys(postcode);
    }

    public void clickFindAddress() {
        addressSearch.click();
    }

    public void clickEditAddress() {
        editAddress.click();
    }

    public void searchOnPostcode(String postcode) {
        enterPostcode(postcode);
        clickFindAddress();
    }

    public void selectAddressFromList(String id) {
        driver.findElement(By.id(id)).click();
    }

    public void editAddress(String line1, String line2, String line3, String line4, String town) {
        address_line_1.clear();
        address_line_1.sendKeys(line1);
        address_line_2.clear();
        address_line_2.sendKeys(line2);
        address_line_3.clear();
        address_line_3.sendKeys(line3);
        address_line_4.clear();
        address_line_4.sendKeys(line4);
        address_town.clear();
        address_town.sendKeys(town);
    }

    public void selectPropertyType(WebElement type1, String type2) {
        Select droplist = new Select(type1);
        droplist.selectByVisibleText(type2);
    }
}
