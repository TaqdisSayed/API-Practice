package com.dpworld.test;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.qa.Rest.POJO.Search;
import com.qa.Rest.Payload.Payloads;
import com.qa.Rest.api.RestCalls;
import com.qa.Rest.auto.BaseClass;
import com.qa.Rest.auto.SearchCall;
import io.restassured.response.Response;
import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;
import java.util.Map;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;


public class ContainerAppointmentPickUpEmptyTest extends BaseClass {
   //public Response response;
   SearchCall s= new SearchCall();
    String filePath
            = "C:\\Users\\tausi\\OneDrive - DP World\\Desktop\\Taqdis\\DP_World\\VBS_ApiAutomation\\src\\main\\java\\com\\qa\\Rest\\Payload\\SearchApi.Json";
    File file = new File(filePath);



    @Test
    public void SearchContApptBy_RefNo() throws IOException {

        /*s.SetSearchPayload("ccsIdOrContNoOrContApptNo",p.getProperty("ccsIdOrContNoOrContApptNo"));
            String filePath
                    = "C:\\Users\\tausi\\OneDrive - DP World\\Desktop\\Taqdis\\DP_World\\VBS_ApiAutomation\\src\\main\\java\\com\\qa\\Rest\\Payload\\SearchApi.Json";
            File file = new File(filePath);
             response = RestAssured.given().
                     contentType(ContentType.JSON).header("Authorization", "Bearer" + TokenManager.getToken()).header("Content-Type", "application/json").
                    // log().all()
                     when().
                    body(file).
                    post("https://gluatapi-community.dpworld.com/vbs/containerappointment/search");
            System.out.println("API response body = " + response.getBody().asString());
            Assert.assertEquals(response.getStatusCode(), 200,
                    "Correct status code returned");
        JsonPath j=response.jsonPath();
        String a = j.get("referenceNo");
        Assert.assertEquals(j.getString("list[0].referenceNo"),p.getProperty("ccsIdOrContNoOrContApptNo"));*/

       s.SetSearchPayload("ccsIdOrContNoOrContApptNo",p.getProperty("ccsIdOrContNoOrContApptNo"));
        Search s1 = SearchRequest(p.getProperty("ccsIdOrContNoOrContApptNo"));
        Response response = RestCalls.post(file);
        StatusCode.assertStatusCode(response.statusCode(), StatusCode.CODE_200);
        StatusCode.assert_Response(response,s1);
        StatusCode.assert_Headers(response,"Content-Type");
    }

    @Test
    public void SearchContApptBy_Status() throws IOException {

        Search payload = Payloads.SearchRequestFromPoJo();
        Response response = RestCalls.post(payload);
        ObjectMapper mapper = new ObjectMapper();
        String jsonString = mapper.writeValueAsString(payload);
        System.out.println(jsonString);
        System.out.println("API response body = " + response.getBody().asString());
        StatusCode.assertStatusCode(response.statusCode(), StatusCode.CODE_200);

    }

    @Test
   /* public void SearchContApptBy_ApptType() throws IOException {

        String a = payload.get("SearchApi.Json");
        mapper1 =  objectMapper.readValue(new File(SEARCH_API_JSON),
             new TypeReference<Map<String,Object>>(){});

        mapper1.put("status","[OK]");
        Response response = RestCalls.post(mapper1);
        String jsonString = objectMapper.writeValueAsString(mapper1);
        System.out.println(jsonString);
        System.out.println("API response body = " + response.getBody().asString());
       // StatusCode.assertStatusCode(response.statusCode(), StatusCode.CODE_200);


    }
*/


    public Search SearchRequest(String ccsIdOrContNoOrContApptNo){
        System.out.println("inside playlist builder");
        return Search.builder().
                ccsIdOrContNoOrContApptNo(ccsIdOrContNoOrContApptNo).build();
    }

    public void assertSearchcall(String response, Search request){
        assertThat(response,equalTo(request.getCcsIdOrContNoOrContApptNo()));
    }


}
