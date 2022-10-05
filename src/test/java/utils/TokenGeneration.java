package utils;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.json.JSONObject;

public class TokenGeneration {
    public String url;
    public String username;
    public String password;
    public String token;

    public TokenGeneration(String username, String url, String password, String token) {
        this.username = username;
        this.password = password;
        this.url = url;
        this.token = token;
    }

    public void generateToken(String token) {

        RequestSpecification request = RestAssured.given();
        request.header("Content-Type", "application/json");

        JSONObject requestPayload = new JSONObject();
        requestPayload.put("username", username);
        requestPayload.put("password", password);
        request.body(requestPayload.toString());

        Response response = request.post(url);
        response.then().statusCode(200);
        response.then().extract().path("token");
       // Assert.assertNotNull(token);
    }

    public String getToken(){
        return token;
    }
}
