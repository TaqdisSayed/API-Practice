package com.dpworld.test;

import com.qa.Rest.utils.PropertyUtils;
import io.restassured.response.Response;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.Properties;

import static io.restassured.RestAssured.given;


public class SampleTest {

    public static String getToken() throws JSONException {


         Properties p = PropertyUtils.propertyLoader("C:\\Users\\tausi\\OneDrive - DP World\\Desktop\\Taqdis\\DP_World\\VBS_ApiAutomation\\src\\main\\resources\\Config.properties");

        //p.getProperty("client_id") p.getProperty("client_secret") p.getProperty("username") p.getProperty("password")
        
        Response response =
                given().
                        auth().preemptive().basic("client_id","client_secret" ).
                        contentType("application/x-www-form-urlencoded").log().all()
                        .formParam("grant_type", "password")
                        .formParam("username","username" )
                        .formParam("password","password")
                        .when()
                        .post("https://dev-login.cargoes.com/auth/realms/dtworld/protocol/openid-connect/token");

        System.out.println("API response body = " + response.getBody().asString());
        JSONObject jsonObject = new JSONObject(response.getBody().asString());
        String accessToken = jsonObject.get("access_token").toString();
        String tokenType = jsonObject.get("token_type").toString();
        //log.info("Oauth Token with type " + tokenType + "   " + accessToken);
        System.out.println("Oauth Token with type " + tokenType + "   " + accessToken);

        System.out.println("API response body = " + response.getBody().asString());
        return  accessToken;
    }





}
