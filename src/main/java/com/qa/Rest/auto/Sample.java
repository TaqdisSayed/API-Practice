package com.qa.Rest.auto;

import io.restassured.response.Response;
import org.json.JSONException;
import org.json.JSONObject;
import org.testng.annotations.Test;


import static io.restassured.RestAssured.given;

public class Sample {
@Test
    public void  getToken() throws JSONException {



        Response response =
                given().
                        auth().preemptive().basic("GLOBAL","uCatiIohQQqIucNJomtgjdhZRZQEJx9D").
                        contentType("application/x-www-form-urlencoded").log().all()
                        .formParam("grant_type", "password")
                        .formParam("username","to.chile" )
                        .formParam("password","P@ssw0rd")
                        .when()
                        .post("https://dev-login.cargoes.com/auth/realms/dtworld/protocol/openid-connect/token");

        System.out.println("API response body = " + response.getBody().asString());
        JSONObject jsonObject = new JSONObject(response.getBody().asString());
        String accessToken = jsonObject.get("access_token").toString();
        String tokenType = jsonObject.get("token_type").toString();
        //log.info("Oauth Token with type " + tokenType + "   " + accessToken);
        System.out.println("Oauth Token with type " + tokenType + "   " + accessToken);

        System.out.println("API response body = " + response.getBody().asString());
        //return  accessToken;
    }





}
