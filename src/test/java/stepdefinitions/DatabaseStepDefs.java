package stepdefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static stepdefinitions.MedunnaRoomStepDefs.fakeRoomNumber;

public class DatabaseStepDefs {

    private Connection connection;

    @Given("connect to database")
    public void connect_to_database() throws SQLException {

        connection = DriverManager.getConnection("jdbc:postgresql://medunna.com:5432/medunna_db_v2", "select_user", "Medunna_pass_@6");

    }


    @Then("read the room and validate body")
    public void read_the_room_and_validate_body() throws SQLException {

        String query = "select * from room where room_number = "+fakeRoomNumber;

        ResultSet resultSet = connection.createStatement().executeQuery(query);
        resultSet.next();//This method will take the pointer one step forward from header
        String roomNumber = resultSet.getString("room_number");
        String price = resultSet.getString("price");
        String description = resultSet.getString("description");
        String roomType = resultSet.getString("room_type");

        assertEquals(fakeRoomNumber, roomNumber);
        assertEquals("DAYCARE", roomType);
        assertEquals("333.00", price);
        assertEquals("This room was created for cucumber practice e2e test", description);

        //Negative test --> Assert that the resultSet is empty:
        //assertFalse(resultSet.next());//If resultSet does not have any record, next method will return false

        connection.close();
        resultSet.close();

    }
}
