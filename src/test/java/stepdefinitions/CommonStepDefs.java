package stepdefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import utilities.Driver;
import utilities.WaitUtils;

public class CommonStepDefs {

    @Given("user navigates to {string}")
    public void user_navigates_to(String url) {

        Driver.getDriver().get(url);

    }

    @Then("close the application")
    public void close_the_application() {
        WaitUtils.waitFor(3);
        Driver.closeDriver();

    }

}
