package com.dpworld.test;

import com.qa.Rest.Payload.Payloads;
import com.qa.Rest.api.RestCalls;
import com.qa.Rest.auto.BaseClass;
import com.qa.Rest.auto.ExcelReader;
import com.qa.Rest.utils.PropertyUtils;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.Map;
import java.util.Properties;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;


public class CreatePUMApptTest extends BaseClass {

    Map<String, Object> mapper1;
    ExcelReader e = new ExcelReader();



    @DataProvider(name = "RowID")
    public Object[][] RowID() {
        return new Object[][]{
                {"1"},
                {"2"},
                {"Rejected"},
                {"Cancelled"},
                {"Partially_Approved"}
        };
    }

     @Test(dataProvider = "RowID",priority = 1)
    public void MsadminCreatePUM (String RowID) throws IOException {
        mapper1 = Payloads.setgetPayload(CREATE_JSON,CREATE_TESTDATA,RowID);
        Response response = RestCalls.post(p1.getProperty("BaseURL"),p1.getProperty("CreateEndPoint"),mapper1);
        logger.info("API Create response body = " + response.getBody().asString());
        Assertions.assertStatusCode(response.statusCode(), Assertions.StatusCODE_200);
        Assertions.assert_Status(response,Assertions.AWAITING_APPROVAL);
         PropertyUtils.PropertyWriter(DataFile,"PUM_AwaitingApproval_ReferenceNo_"+RowID,Assertions.fetch_ReferenceNo(response));
        SearchContApptTest.SearchContApptBy_RefNo(Assertions.fetch_ReferenceNo(response),Assertions.AWAITING_APPROVAL);
      }

      @Test(priority = 2)
    public void MsadminRejectPum () throws IOException {

        Response response = RestCalls.put(p1.getProperty("BaseURL"),p1.getProperty("RejectEndPoint")+PropertyUtils.readDataFile(DataFile,"PUM_AwaitingApproval_ReferenceNo_Rejected"),"yes");
          logger.info("API Reject response body = " + response.getBody().asString());
          Assertions.assertStatusCode(response.statusCode(), Assertions.StatusCODE_200);
          Assertions.assert_Status(response,Assertions.REJECTED);
    }

    @Test(priority = 4)
    public void MsadminCancelPum () throws IOException
    {
        String a = PropertyUtils.readDataFile(DataFile,"PUM_AwaitingApproval_ReferenceNo_Cancelled");
        Response response = RestCalls.delete(p1.getProperty("BaseURL"),p1.getProperty("CancelEndPoint")+PropertyUtils.readDataFile(DataFile,"PUM_AwaitingApproval_ReferenceNo_Cancelled"));
        logger.info("API Cancel response body = " + response.getBody().asString());
        Assertions.assertStatusCode(response.statusCode(), Assertions.StatusCODE_200);
        Assertions.assert_Status(response,Assertions.CANCELLED);
    }

    @Test(priority = 3)
    public void MsadminApprovePum () throws IOException, InterruptedException {
        //String a = PropertyUtils.readDataFile(DataFile,"PUM_AwaitingApproval_ReferenceNo_Cancelled");
        Response response = RestCalls.put(p1.getProperty("BaseURL"),p1.getProperty("ApproveEndPoint")+PropertyUtils.readDataFile(DataFile,"PUM_AwaitingApproval_ReferenceNo_1"));
        logger.info("API Approve response body = " + response.getBody().asString());
        Assertions.assertStatusCode(response.statusCode(), Assertions.StatusCODE_200);
        Assertions.assert_Status(response,Assertions.PENDING);
        /*Thread.sleep(2000);
        SearchContApptTest.SearchContApptBy_RefNo(Assertions.fetch_ReferenceNo(response),Assertions.OK);*/
    }

    @Test(priority = 5)
    public void MsadminCancelRejectedPUM () throws IOException
    {
        String a = PropertyUtils.readDataFile(DataFile,"PUM_AwaitingApproval_ReferenceNo_Rejected");
        Response response = RestCalls.delete(p1.getProperty("BaseURL"),p1.getProperty("CancelEndPoint")+PropertyUtils.readDataFile(DataFile,"PUM_AwaitingApproval_ReferenceNo_Rejected"));
        logger.info("API Cancel response body = " + response.getBody().asString());
        Assertions.assertStatusCode(response.statusCode(), Assertions.StatusCODE_200);
        Assertions.assert_Status(response,Assertions.CANCELLED);
    }












        /*public Search SearchRequest (String ccsIdOrContNoOrContApptNo){
            System.out.println("inside playlist builder");
            return Search.builder().
                    ccsIdOrContNoOrContApptNo(ccsIdOrContNoOrContApptNo).build();
        }

        public void assertSearchcall (String response, Search request){
            assertThat(response, equalTo(request.getCcsIdOrContNoOrContApptNo()));
        }*/


    }
