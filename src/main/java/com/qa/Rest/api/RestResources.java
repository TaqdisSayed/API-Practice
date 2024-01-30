package com.qa.Rest.api;

import com.qa.Rest.auto.BaseClass;
import com.qa.Rest.utils.PropertyUtils;
import io.qameta.allure.restassured.AllureRestAssured;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.module.jsv.JsonSchemaValidator;
import io.restassured.response.Response;
import org.apache.poi.ss.formula.functions.T;
import org.apache.tools.ant.util.FileUtils;

import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchemaInClasspath;


import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Properties;

import static io.restassured.RestAssured.given;

public class RestResources extends BaseClass {


    public static Response post(String BaseURL, String token, File f) {
        return given().filter(new AllureRestAssured()).
                contentType(ContentType.JSON).
                header("Authorization", "Bearer" + token).header("Content-Type", "application/json").
                body(f).
                post(BaseURL);


    }

    public static Response post(String BaseURL,String EndPoint, Object f) {

        /*RestAssured.baseURI = BaseURL;

        // Specify the path and query parameter
        String path = EndPoint;
        Response response = RestAssured.given().
                auth().preemptive().oauth2(TokenManager.getToken()).
                header("Content-Type", "application/json").
                body(f).
                when().
                post(path);
        return response;*/

        String a = BaseURL+EndPoint;

        return given().filter(new AllureRestAssured()).
                contentType(ContentType.JSON).
                header("Authorization", "Bearer" + TokenManager.getToken()).header("Content-Type", "application/json").
                body(f).
                post(a);

    }

    /*public static Response post(String BaseURL, String token, Object f) {

        int pageSize = 20; // Set your desired page size
        int totalPages = 1;
        Response r = null;
        for (int page = 1; page <= totalPages; page++) {
           r =  given().filter(new AllureRestAssured()).
                    contentType(ContentType.JSON)
                    .header("Authorization", "Bearer" + token).header("Content-Type", "application/json")
                    .body(f).
                    post(BaseURL);
            logger.info("API response body = " + r.getBody().asString());
            logger.info(BaseURL + "?page=" + page + "&pageSize=" + pageSize);
        }
            return r;
    }*/


    public static Response get(String BaseURL, String EndPoint, String QueryParam) {
        RestAssured.baseURI = BaseURL;

        // Specify the path and query parameter
        String path = EndPoint;
        String tenantCode = QueryParam;

        // Make the GET request
        Response response = RestAssured.given()
                .auth().preemptive().oauth2(TokenManager.getToken())
                .queryParam("tenantCode", tenantCode)
                .when()
                .get(path);

        // Print the response status code
        System.out.println("Status Code: " + response.getStatusCode());

        // Print the response body in JSON format
        System.out.println("Response Body (JSON format):");
        response.prettyPrint();
        return response;
    }










}
