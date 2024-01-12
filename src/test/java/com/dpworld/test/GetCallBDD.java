package com.dpworld.test;

import com.qa.Rest.POJO.Search;
import com.qa.Rest.api.TokenManager;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.testng.annotations.Test;

import java.io.File;

public class GetCallBDD {


    @Test
    public void SearchContApptBy_RefNo() {
        String filePath = "C:\\Users\\tausi\\OneDrive - DP World\\Desktop\\Taqdis\\DP_World\\VBS_ApiAutomation\\src\\main\\java\\com\\qa\\Rest\\Payload\\SearchApi.Json";
        File jsonFile = new File(filePath);
        /*Map<String, Object> jsonData = new HashMap<>();
        jsonData.put("username", "admin");
        jsonData.put("age", 30);
        jsonData.put("email", "aqh@gmail.com");
        jsonData.put("password", "password");*/

       /* Search s = new Search();
        s. setCcsIdOrContNoOrContApptNo("CAVYA00000MX");
        s. setApptDateTo("");
        s. setLineId("");
        s. setAppointmentType("DOM");
        s. setSubContractCompanyId("");
        s.setBookingNo("");
        s.setPageNo("");
        s.setTruckId("");
        s. setTruckingCompanyId("");
        s.setDriverPortPassId("");
        s. setGrade("");
        s.setStatus("");
        s.setTruckVisitAppointmentNo("");
        s.setClientCode("");
        s.setSite("");
        s. setPageNo("");
        s. setPageSize("");
        s.setOrder("");
        Response response = RestAssured.given().
                        contentType(ContentType.JSON).header("Authorization", "Bearer" + TokenManager.getToken()).header("Content-Type", "application/json").
                        log().all()
                        .when().
                body(s.SearchValue()).
                post("https://gluatapi-community.dpworld.com/vbs/containerappointment/search");
        System.out.println("API response body = " + response.getBody().asString());*/
    }
}
