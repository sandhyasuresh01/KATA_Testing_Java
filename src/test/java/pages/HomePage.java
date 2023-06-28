package pages;

import org.junit.Assert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.*;

import static utils.CommonUtils.*;
import static utils.DriversUtils.*;


public class HomePage {

    @FindBy(tagName = "h2")
    private WebElement roomCategoryIdentifier;

    @FindBy(xpath = "//button[contains(@class,'openBooking')]")
    private WebElement bookButton;

    @FindBy(name = "firstname")
    private WebElement formFirstNameText;

    @FindBy(name = "lastname")
    private WebElement formLastNameText;

    @FindBy(name = "email")
    private WebElement formEmailText;

    @FindBy(name = "phone")
    private WebElement formPhoneText;

    public HomePage() {
        PageFactory.initElements(getDriver(), this);
    }

    public void goToRoomsCategory() {
        try {
            scrollToElement(roomCategoryIdentifier);
        } catch (RuntimeException e) {
            e.printStackTrace();
            System.out.println("Error in the rooms category method");
        }
    }

    public void assertBookButtonDisplayed(){
        Assert.assertEquals(true, bookButton.isDisplayed());
    }

    public void navigateToHomePage() {
        getDriver().get("https://automationintesting.online/#/");
    }

    public void clickBookThisRoom() {
        bookButton.click();
    }

    public void assertFormControlsAreDisplayed() {
        Assert.assertTrue("First name text in form is displayed", formFirstNameText.isDisplayed());
        Assert.assertTrue("Last name text in form is displayed", formLastNameText.isDisplayed());
        Assert.assertTrue("Email text in form is displayed", formEmailText.isDisplayed());
        Assert.assertTrue("Phone text in form is displayed", formPhoneText.isDisplayed());
    }
}

