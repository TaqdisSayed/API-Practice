package com.dpworld.test;

import com.qa.Rest.POJO.Search;
import com.qa.Rest.Payload.Payloads;
import com.qa.Rest.api.RestCalls;
import com.qa.Rest.auto.BaseClass;
import com.qa.Rest.auto.SearchCall;
import io.restassured.response.Response;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;
import java.net.URI;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Map;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;


public class ReportsTest extends BaseClass {




       /*  @Test
        public void GetReports()
        {
            String a = p1.getProperty("ReportsURL");
            Response response=RestCalls.get(p1.getProperty("ReportsURL"),p1.getProperty("ReportsEndpoint"),p1.getProperty("QueryParam"));
            logger.info("API " + response.prettyPrint().toString());
            Path absolutePath = Paths.get(System.getProperty("user.dir"));
            System.out.println("Absolute Path: " + absolutePath);
            Assertions.assertStatusCode(response.statusCode(),Assertions.StatusCODE_200);
        }
      @Test
    public void GenearteReports()
    {
        Response response=RestCalls.get(p1.getProperty("GenerateURL"),p1.getProperty("GenerateEndPoint"),"");
        logger.info("API " + response.prettyPrint().toString());
        Path absolutePath = Paths.get(System.getProperty("user.dir"));
        System.out.println("Absolute Path: " + absolutePath);
        Assertions.assertStatusCode(response.statusCode(),Assertions.StatusCODE_200);
    }


@Test
    public void createRelativePath()
    {
        try {

            // Two absolute paths
            File absolutePath1 = new File("C:\\Users\\tausi\\OneDrive - DP World\\Desktop\\Taqdis\\DP_World\\VBS_ApiAutomation\\src\\main\\resources\\Configcopy.properties");
            System.out.println("Absolute Path1: " + absolutePath1);
            File absolutePath2 = new File("C:\\Users\\tausi\\OneDrive - DP World\\Desktop\\Taqdis\\DP_World\\VBS_ApiAutomation");
            System.out.println("Absolute Path2: " + absolutePath2);

            // convert the absolute path to URI
            URI path1 = absolutePath1.toURI();
            URI path2 = absolutePath2.toURI();

            // create a relative path from the two paths
            URI relativePath = path2.relativize(path1);

            // convert the URI to string
            String path = relativePath.getPath();

            System.out.println("Relative Path: " + path);


        } catch (Exception e) {
            e.getStackTrace();
        }

    }
*/


    }
