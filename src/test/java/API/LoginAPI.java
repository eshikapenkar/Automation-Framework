package API;

import io.restassured.response.Response;
import utils.APIConfig;

import static io.restassured.RestAssured.given;

public class LoginAPI {
    public Response loginUser(String email, String password) {

        return given()
                .baseUri(APIConfig.BASE_URL)
                .header("Content-Type", "application/json")
                .body("{\"email\":\"" + email + "\",\"password\":\"" + password + "\"}")
                .when()
                .post("/api/login");
    }
}
