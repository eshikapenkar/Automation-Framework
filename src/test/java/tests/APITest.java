package tests;

import API.LoginAPI;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

public class APITest {
    @Test
    public void verifyLoginAPI() {

        LoginAPI loginAPI = new LoginAPI();

        Response response = loginAPI.loginUser(
                "eve.holt@reqres.in",
                "cityslicka"
        );
        response.prettyPrint();
        System.out.println("Status Code: " + response.statusCode());
        response.then().statusCode(200);

        Assert.assertNotNull(
                response.jsonPath().getString("token")
        );
    }
}
