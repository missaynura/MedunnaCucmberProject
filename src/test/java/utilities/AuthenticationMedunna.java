package utilities;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.checkerframework.checker.units.qual.C;

import static io.restassured.RestAssured.given;

public class AuthenticationMedunna {

    public static String generateToken() {

        String body = "{\"password\": \"Mark.123\", \"username\": \"mark_twain\"}";

        Response response = given().body(body).contentType(ContentType.JSON).post("https://medunna.com/api/authenticate");

        return response.jsonPath().getString("id_token");

    }

}
