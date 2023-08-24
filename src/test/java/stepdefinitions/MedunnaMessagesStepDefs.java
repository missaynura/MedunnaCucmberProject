package stepdefinitions;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.MedunnaHomePage;
import pages.MedunnaMessagesPage;
import utilities.WaitUtils;

import static org.junit.Assert.assertTrue;

public class MedunnaMessagesStepDefs {

    MedunnaHomePage medunnaHomePage = new MedunnaHomePage();
    MedunnaMessagesPage medunnaMessagesPage = new MedunnaMessagesPage();

    @When("click on messages link")
    public void click_on_messages_link() {

        medunnaHomePage.messagesLink.click();


    }

    @When("click on create a new message link")
    public void click_on_create_a_new_message_link() {

        medunnaMessagesPage.createANewMessageLink.click();

    }

    @When("enter name {string}")
    public void enter_name(String name) {

        medunnaMessagesPage.name.sendKeys(name);

    }

    @When("enter email {string}")
    public void enter_email(String email) {

        medunnaMessagesPage.email.sendKeys(email);

    }

    @When("enter subject {string}")
    public void enter_subject(String subject) {

        medunnaMessagesPage.subject.sendKeys(subject);

    }

    @When("enter message {string}")
    public void enter_message(String message) {

        medunnaMessagesPage.message.sendKeys(message);

    }

    @When("click on save submit button")
    public void click_on_save_submit_button() {

        medunnaMessagesPage.saveSubmitButton.click();

    }

    @Then("assert the alert message contains A new Message is created")
    public void assert_the_alert_message_contains_a_new_message_is_created() {
        WaitUtils.waitForVisibility(medunnaMessagesPage.alertMessage,5);
        assertTrue(medunnaMessagesPage.alertMessage.getText().contains("A new Message is created"));

    }


}
