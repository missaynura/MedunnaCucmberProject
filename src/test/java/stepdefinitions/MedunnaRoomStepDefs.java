package stepdefinitions;

import com.github.javafaker.Faker;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.support.ui.Select;
import pages.MedunnaHomePage;
import pages.MedunnaRoomPage;
import utilities.WaitUtils;

import static org.junit.Assert.assertTrue;

public class MedunnaRoomStepDefs {

    MedunnaRoomPage medunnaRoomPage = new MedunnaRoomPage();
    MedunnaHomePage medunnaHomePage = new MedunnaHomePage();

    @When("click on itemsAndTitles link")
    public void click_on_items_and_titles_link() {

        medunnaHomePage.itemsAndTitles.click();

    }
    @When("click on room link")
    public void click_on_room_link() {

        medunnaHomePage.roomLink.click();

    }
    @When("click on create a new room link")
    public void click_on_create_a_new_room_link() {

        medunnaRoomPage.createANewRoomLink.click();

    }
    @When("enter room number {string}")
    public void enter_room_number(String roomNumber) {

        medunnaRoomPage.roomNumber.sendKeys(Faker.instance().number().numberBetween(1000000,5000000)+"");

    }
    @When("select room type {string}")
    public void select_room_type(String roomType) {

        new Select(medunnaRoomPage.roomTypeDropDown).selectByVisibleText(roomType);

    }

    @When("click on status checkbox")
    public void click_on_status_checkbox() {

        medunnaRoomPage.statusCheckBox.click();
    }

    @When("enter price {string}")
    public void enter_price(String price) {

        medunnaRoomPage.price.sendKeys(price);
    }

    @When("enter description {string}")
    public void enter_description(String description) {

        medunnaRoomPage.description.sendKeys(description);
    }

    @When("click on save button")
    public void click_on_save_button() {

        medunnaRoomPage.saveSubmitButton.click();
    }

    @Then("assert the alert message contains A new Room is created")
    public void assert_the_alert_message_contains_a_new_room_is_created() {
        WaitUtils.waitFor(1);
        assertTrue(medunnaRoomPage.alertMessage.getText().contains("A new Room is created"));
    }

}
