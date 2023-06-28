package features.step_definitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.BasePage;
import pages.HomePage;

public class BookingFormValidationSteps extends BasePage {
    
    HomePage homePage = new HomePage();

    @Given("I am on the room booking form")
    public void i_am_on_the_home_page() {
        homePage.navigateToHomePage();
        homePage.goToRoomsCategory();
        homePage.clickBookThisRoom();
    }

    @When("I enter all text in all the form controls")
    public void i_enter_text_in_all_the_form_controls() {
        homePage.enterTextInAllFormControls();
    }

    @Then("I validate the text in all form fields")
    public void i_have_the_option_to_validate_form_controls() {
        homePage.assertFormControls();
    }
}