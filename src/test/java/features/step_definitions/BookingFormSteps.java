package features.step_definitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.BasePage;
import pages.HomePage;

public class BookingFormSteps extends BasePage {

    HomePage homePage = new HomePage();

    @Given("I am on the book a room option")
    public void i_am_on_the_book_a_room() {
        homePage.navigateToHomePage();
        homePage.goToRoomsCategory();
    }

    @When("I select book this room option")
    public void i_select_book_this_room() {
        homePage.clickBookThisRoom();
    }

    @Then("I have the option to see form controls to fill up necessary information")
    public void i_have_the_option_to_see_form_controls() {
        homePage.assertFormControlsAreDisplayed();
    }
}
