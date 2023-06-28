package pages;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import static utils.CommonUtils.*;
import static utils.DriversUtils.*;


public class HomePage {

    @FindBy(tagName = "h2")
    private WebElement roomCategoryIdentifier;

    @FindBy(xpath = "//button[contains(@class,'openBooking')]")
    private WebElement bookButton;

    @FindBy(xpath = "//button[contains(@class,'btn-outline-primary')]")
    private WebElement bookRoom;

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
        Assert.assertTrue(bookButton.isDisplayed());
    }

    public void navigateToHomePage() {
        getDriver().get("https://automationintesting.online/#/");
    }

    public void clickBookThisRoom() {
        bookButton.click();
    }

    public void clickBookRoom() {
        bookRoom.click();
    }
    public void assertFormControlsAreDisplayed() {
        Assert.assertTrue("First name text in form is displayed", formFirstNameText.isDisplayed());
        Assert.assertTrue("Last name text in form is displayed", formLastNameText.isDisplayed());
        Assert.assertTrue("Email text in form is displayed", formEmailText.isDisplayed());
        Assert.assertTrue("Phone text in form is displayed", formPhoneText.isDisplayed());
    }

    public void enterTextExceptInEmailControl() {
        formFirstNameText.sendKeys("TestUser firstName");
        formLastNameText.sendKeys("TestUser lastName");
        formPhoneText.sendKeys("+32123456789");
    }

    public void assertError() {
        WebElement alert = getDriver().findElement(By.className("alert-danger"));
        Assert.assertTrue(alert.isDisplayed());
    }

    public void enterTextInAllFormControls() {
        formFirstNameText.sendKeys("TestUser firstName");
        formLastNameText.sendKeys("TestUser lastName");
        formPhoneText.sendKeys("+32123456789");
        formEmailText.sendKeys("test@test.com");
    }

    public void assertFormControls() {
        Assert.assertEquals("TestUser firstName", formFirstNameText.getAttribute("value"));
        Assert.assertEquals("TestUser lastName", formLastNameText.getAttribute("value"));
        Assert.assertEquals("+32123456789", formPhoneText.getAttribute("value"));
        Assert.assertEquals("test@test.com", formEmailText.getAttribute("value"));
    }
}

