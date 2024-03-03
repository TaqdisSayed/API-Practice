package com.dpworld.test;
import com.fasterxml.jackson.databind.JsonNode;
import com.qa.Rest.POJO.Search;
import com.qa.Rest.Payload.Payloads;
import com.qa.Rest.auto.BaseClass;
import io.restassured.module.jsv.JsonSchemaValidator;
import io.restassured.response.Response;
import org.hamcrest.Matchers;
import io.restassured.path.json.JsonPath;
import org.json.JSONObject;
import org.testng.Assert;
import org.testng.asserts.Assertion;

import java.io.File;
import java.io.IOException;
import java.text.ParseException;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

public class Assertions extends Payloads {

    public static JsonPath j;

    public static int StatusCODE_200 = 200;
    public static int StatusCODE_400 = 400;
    public static int StatusCODE_401 = 401;
    public static int StatusCODE_403 = 403;
    public static int StatusCODE_404 = 404;
    public static int StatusCODE_405 = 405;
    public static int StatusCODE_500 = 500;
    public static int StatusCODE_501 = 501;
    public static int StatusCODE_502 = 502;
    public static int StatusCODE_503 = 503;
    public static String AWAITING_APPROVAL = "Awaiting Approval";
    public static String OK = "OK";
    public static String REJECTED = "REJECTED";
    public static String CANCELLED = "CANCELLED";
    public static String PARTIALLY_APPROVED = "PARTIALLY_APPROVED";







    /*public final int code=0;
    public final String msg="";

    Assertions(int code, String msg) {
       this.code = code;*/


    public static void assertStatusCode(int actualStatusCode, int statusCode) {
        try {
            assertThat(actualStatusCode, equalTo(statusCode));

        } catch (NoSuchMethodError e1) {
            int type = actualStatusCode;
            switch (type) {
                case 400:
                    System.out.println("malformed request syntax, invalid request message framing, or deceptive request routing");
                    break;
                case 401:
                    System.out.println("the client must authenticate itself to get the requested response.");
                    break;
                case 403:
                    System.out.println("The client does not have access rights to the content; that is, it is unauthorized, so the server is refusing to give the requested resource. ");
                    break;
                case 404:
                    System.out.println("The server cannot find the requested resource. In the browser, URL is not recognized");
                    break;
                case 405:
                    System.out.println("The request method is known by the server but is not supported by the target resource. An API may not allow calling this method ");
                    break;
                case 500:
                    System.out.println("Internal Server Error");
                    break;
                case 501:
                    System.out.println();
                    break;
                case 502:
                    System.out.println("Bad gateway");
                    break;
                case 503:
                    System.out.println("Service Unavailable");
                    break;
            }

        }

    }

    public static void assert_JsonSchemaValidator(Response response, String f) {
        response.then()
                .assertThat()
                .body(JsonSchemaValidator.matchesJsonSchema(new File(f)));
    }

    public static void assertURL(Response response) {
        String actualUrl = response.getHeader("Request URL");
        System.out.println("i am here " + actualUrl);
        org.hamcrest.MatcherAssert.assertThat(actualUrl, Matchers.equalTo("https://gluatapi-community.dpworld.com/vbs/containerappointment/search"));
    }

    public  static String  fetch_ReferenceNo(Response response) {
        j=response.jsonPath();
        return j.getString("referenceNo");

    }


    public static void assert_Status(Response response, String ExpectedStatus) {
        j=response.jsonPath();
        String a = j.getString("status");
        assertThat(j.getString("status"),equalTo(ExpectedStatus));
    }

    public static void assert_Headers(Response response, String Header) {
        response.then().headers("Content-Type", Matchers.equalTo("application/json"));

    }


    public static void getAllHeaders(Response response) {
        response
                .getHeaders()
                .forEach(header -> System.out.println(header.getName() + ": " + header.getValue()));


    }


    public static void validateApiResponse(Response response,String key, String value) throws IOException {

        jsonObject = new JSONObject(response.getBody().asString());
        String a = jsonObject.get("totalRecords").toString();
        int totalRecords = Integer.parseInt(a);
        JsonPath j = response.jsonPath();

        int i = 0;
        boolean flag = true;
        String apiResponse = null;
        try {
            if (totalRecords != 0 ) {
                if (totalRecords == 1) {
                    System.out.println("total records in response is" + totalRecords);
                    apiResponse = j.getString("list" + "[" + i + "]." + key);
                    if (apiResponse.equals(value)) {
                        flag = true;


                    } else {
                        System.out.println("Record found is not in" + value + "status");
                        System.out.println("Validation failed for " + value);
                        flag = false;
                    }

                }
                if(totalRecords>1) {
                    for (i = 0; i <= 10; i++) {
                        apiResponse = j.getString("list" + "[" + i + "]." + key);
                        if (apiResponse.equals(value)) {
                            flag = true;

                        } else {
                            System.out.println("Record found is not in" + value + "status");
                            System.out.println("Validation failed for " + value);
                            flag = false;
                            break;
                        }
                    }//end of for loop
                }

                if (flag == true) {
                    System.out.println("validation Successfull for" + value);
                }

            }
            else{
                throw new Exception("API has no response");
            }
        }
        catch (Exception e)
        {
            Assert.fail("API has no response");
        }




    }
}