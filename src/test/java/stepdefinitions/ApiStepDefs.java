package stepdefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.restassured.response.Response;

import static base_urls.MedunnaBaseUrl.setSpec;
import static base_urls.MedunnaBaseUrl.spec;
import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;
import static stepdefinitions.MedunnaRoomStepDefs.fakeRoomNumber;
import static stepdefinitions.MedunnaRoomStepDefs.roomId;

public class ApiStepDefs {
    Response response;

    @Given("send get request by id to read the room")
    public void send_get_request_by_id_to_read_the_room() {

        response = given(spec).get("api/rooms/" + roomId);
        response.prettyPrint();

    }

    @Then("validate body")
    public void validate_body() {

        String roomNumber = response.jsonPath().getString("roomNumber");
        String roomType = response.jsonPath().getString("roomType");
        String price = response.jsonPath().getString("price");
        String description = response.jsonPath().getString("description");

        assertEquals(200, response.statusCode());
        assertEquals(fakeRoomNumber, roomNumber);
        assertEquals("DAYCARE", roomType);
        assertEquals("333.0", price);
        assertEquals("This room was created for cucumber practice e2e test", description);


    }
}
