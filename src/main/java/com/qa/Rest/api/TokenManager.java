package com.qa.Rest.api;

import com.qa.Rest.utils.PropertyUtils;
import io.restassured.response.Response;
import org.json.JSONException;
import org.json.JSONObject;
import java.io.File;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;


import static io.restassured.RestAssured.given;

import java.util.Properties;

public class TokenManager {


    public static String getToken() throws JSONException  {


        Properties p = PropertyUtils.propertyLoader("\\src\\main\\resources\\Config.properties");

        /*System.out.println(p.getProperty("client_id"));
        System.out.println(p.getProperty("client_secret"));*/
        //p.getProperty("username") p.getProperty("password")
        Response response =
                given().
                        auth().preemptive().basic("GLOBAL","zVEHInfSRfhMXHLTk1nhsNdMFUQjDTKb").
                        contentType("application/x-www-form-urlencoded")//log().all()
                        .formParam("grant_type", "password")
                        .formParam("username","to.chile" )
                        .formParam("password","P@ssw0rd")
                        .when()
                .post("https://staging-login.cargoes.com/auth/realms/dtworld/protocol/openid-connect/token");

        assertThat(response.statusCode(),equalTo(200));
        JSONObject jsonObject = new JSONObject(response.getBody().asString());
        String accessToken = jsonObject.get("access_token").toString();
        String tokenType = jsonObject.get("token_type").toString();

        return  accessToken;
    }









}
