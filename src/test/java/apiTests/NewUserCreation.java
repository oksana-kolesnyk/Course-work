package apiTests;


import io.restassured.response.Response;
import org.junit.Assert;
import org.junit.Test;
import utils.TokenGeneration;

import static io.restassured.RestAssured.when;

public class NewUserCreation extends TokenGeneration {

    String username = "testOksana";
    String password = "Test123%";
    String requestUrl = " https://demoqa.com/Account/v1/User" + username ;

    public NewUserCreation(String username, String url, String password, String token) {
        super(username, url, password, token);
    }

    @Override
    public void generateToken(String token) {
        System.out.println(token + "is token");
    }

    @Test
    public void NewUserCreation(){

        String expectedId = "beedfb0d-ac96-4b72-b47d-0ff1066b83a0";
        String url = "https://demoqa.com//Account/v1/User/" + getToken();
        String expectedToken = "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJ1c2VyTmFtZSI6InRlc3RPa3NhbmEiLCJwYXNzd29yZCI6IlRlc3QxMjMlIiwiaWF0IjoxNjY0NzUyMzg5fQ.7RgZeZo1kr07TxdlkxdS3pQRZlP_Vibbk0yXY0NHlII";


    //Get response
        Response response = when().get(requestUrl);
        response.then().statusCode(200);

    //Verification of userID
        String actualId  = response.then().extract().path("id");
        Assert.assertEquals(expectedId, actualId);

        //Get token
        Response responseT= when().get(url);
        response.then().statusCode(200);
        Assert.assertEquals(getToken(), expectedToken);

        //Verify that username in Response Body corresponds to data provided
        String actualUsername  = response.then().extract().path("username");
        Assert.assertEquals(username, actualUsername);
    }
}
