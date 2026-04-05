package tests;

import io.restassured.RestAssured;
import org.testng.annotations.Test;

public class APITest {
    @Test
    public void getUsersTest() {

        RestAssured
                .given()
                .when()
                .get("https://jsonplaceholder.typicode.com/users")
                .then()
                .statusCode(200)
                .log().all();
    }
}
