package pages;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;

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

    static String bookingFromDate;

    static String bookingMonth;

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

    public void findDateElement()  {
        bookingMonth = getDriver().findElement(By.className("rbc-toolbar-label")).getText();
        List<WebElement> activeElements = getDriver().findElements(By.xpath("//div[@class='rbc-date-cell']"));
//        if(!getDriver().findElements(By.xpath("//div[@class='rbc-event-content']")).isEmpty()) {
//            checkToSelectDates(activeElements);
//        } else {
        selectDatesForBooking(activeElements, 0, activeElements.size());
        // }
    }

    public static void assertMessageAfterBooked() {
        try {
            //Thread.sleep(100);
            String alertMessage=getDriver().findElement(By.xpath("//div[@role='dialog']")).getText();
            String dateString = bookingMonth + " " + bookingFromDate;
            Date formatDate = new SimpleDateFormat("MMMM yyyy, d", Locale.ENGLISH).parse(dateString);
            SimpleDateFormat formatter1 = new SimpleDateFormat("yyyy-MM-dd");
            String inputDate = String.valueOf(formatter1.parse(String.valueOf(formatDate)));
            Assert.assertTrue(alertMessage.contains(inputDate));
            Assert.assertEquals("Rooms", bookingMonth);
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }

    private static void selectDatesForBooking(List<WebElement> activeElements, int bookedIntDate, int size) {
        //for (int i = bookedIntDate; i < size; i++) {
        WebElement currentRow = activeElements.get(0);
        Actions builder = new Actions(getDriver());
        bookingFromDate = currentRow.getText();
        WebElement from = currentRow.findElement(By.cssSelector("button[class='rbc-button-link']"));
        WebElement to = activeElements.get(2).findElement(By.cssSelector("button[class='rbc-button-link']"));
        builder.clickAndHold(from).build().perform();
        builder.dragAndDrop(currentRow, to).build().perform();
        // break;
        //}
    }

    // Advanced function - not validated for now
//    private void checkToSelectDates(List<WebElement> activeElements) {
//        WebDriverWait wait = new WebDriverWait(getDriver(), 500);
//        By path =By.xpath("//div[@class='rbc-date-cell rbc-current']");
//        wait.until(ExpectedConditions.visibilityOfElementLocated(path));
//
//        List<WebElement> unavailableDates = getDriver().findElements(By.xpath("//div[@class='rbc-date-cell rbc-current']"));
//        int sizeOfUnavailableDates = unavailableDates.size();
//        if(!getDriver().findElements(By.xpath("//div[@class='rbc-date-cell rbc-current']")).isEmpty()) {
//            String bookedDate = getDriver().findElements(By.xpath("//div[@class='rbc-date-cell rbc-current']")).get(sizeOfUnavailableDates-1).getText();
//            int bookedIntDate = Integer.parseInt(bookedDate);
//            selectDatesForBooking(activeElements, bookedIntDate, activeElements.size() - bookedIntDate);
//        }
//    }
}

