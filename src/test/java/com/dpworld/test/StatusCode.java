package com.dpworld.test;

import com.qa.Rest.POJO.Search;
import com.qa.Rest.auto.BaseClass;
import io.restassured.module.jsv.JsonSchemaValidator;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.hamcrest.Matchers;

import java.io.File;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;


public enum StatusCode   {
    CODE_200(200, ""),
    CODE_201(201, ""),
    CODE_400(400, "Missing required field: name"),
    CODE_401(401, "Invalid access token");

    public final int code;
    public final String msg;

    StatusCode(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }


    public static void assertStatusCode(int actualStatusCode, StatusCode statusCode){
        try {
            assertThat(actualStatusCode, equalTo(statusCode.code));


        }
        catch (NoSuchMethodError e1)
        {
            System.out.println("Inside no such method error");
        }

    }

    public static void assert_JsonSchemaValidator(Response response ,String f)
    {
        response.then()
                .assertThat()
                .body(JsonSchemaValidator.matchesJsonSchema(new File(f)));
    }

    public static void assertURL(Response response)
    {
        String actualUrl = response.getHeader("Request URL");
        System.out.println("i am here " +actualUrl);
        org.hamcrest.MatcherAssert.assertThat(actualUrl, Matchers.equalTo("https://gluatapi-community.dpworld.com/vbs/containerappointment/search"));
    }

    public static void assert_Response(Response response, Search Expected)
    {
        System.out.println("API response body = " + response.getBody().asString());
        JsonPath j=response.jsonPath();
        assertThat(j.getString("list[0].referenceNo"),equalTo(Expected));
    }

    public static void assert_Headers(Response response , String Header)
    {
        response.then().headers("Content-Type", Matchers.equalTo("application/json"));
    }

    public static void getAllHeaders(Response response)
    {
        response
                .getHeaders()
                .forEach(header -> System.out.println(header.getName() + ": " + header.getValue()));
    }


    public static void validateApiResponse()
    {

    }



}



