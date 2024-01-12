
import io.restassured.response.Response;
import com.qa.Rest.auto.SearchCall;
import org.testng.annotations.Test;
import com.qa.Rest.api.RestCalls;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;


import java.io.IOException;

;

public class SearchContApptTest extends SearchCall  {
    Response response;
   SearchCall s= new SearchCall();
    /*Properties p = PropertyUtils.propertyLoader("C:\\Users\\tausi\\OneDrive - DP World\\Desktop\\Taqdis\\DP_World\\VBS_ApiAutomation\\src\\main\\resources\\Data.properties");
    String filePath
            = "C:\\Users\\tausi\\OneDrive - DP World\\Desktop\\Taqdis\\DP_World\\VBS_ApiAutomation\\src\\main\\java\\com\\qa\\Rest\\Payload\\SearchApi.Json";
    File file = new File(filePath);*/


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


      /*  s.SetSearchPayload("ccsIdOrContNoOrContApptNo",p.getProperty("ccsIdOrContNoOrContApptNo"));
        Response response = RestCalls.post(file);
        assertStatusCode(response.statusCode(), StatusCode.CODE_200);*/



    }

    /*public void assertStatusCode(int actualStatusCode, StatusCode statusCode){
        assertThat(actualStatusCode, equalTo(statusCode.code));
    }
*/
}
