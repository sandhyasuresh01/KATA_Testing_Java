package features.step_definitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.BasePage;
import pages.HomePage;

public class BookingRoomSteps extends BasePage {

    HomePage homePage = new HomePage();

    @Given("I am on the room booking calendar form")
    public void i_am_on_the_room_booking_calendar_form() {
        homePage.navigateToHomePage();
        homePage.goToRoomsCategory();
        homePage.clickBookThisRoom();
        homePage.enterTextInAllFormControls();
    }

    @When("I select the dates and book the room")
    public void i_select_the_dates_and_book_the_room() {
        homePage.findDateElement();
        homePage.clickBookRoom();
    }

    @Then("I get the confirmation message")
    public void i_have_the_option_to_validate_form_controls() {
        homePage.assertMessageAfterBooked();
    }
}
