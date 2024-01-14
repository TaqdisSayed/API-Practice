package com.qa.Rest.auto;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.qa.Rest.utils.CreateRunTimeFolder;
import com.qa.Rest.utils.PropertyUtils;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.testng.annotations.BeforeClass;


import io.restassured.response.Response;
import java.text.SimpleDateFormat;
import java.util.*;


public class BaseClass {
    CreateRunTimeFolder createRunTimeFolder = new CreateRunTimeFolder();
    String timestamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());
    String folderPath = "folders/" + timestamp; // You can change the directory as needed
    public Properties p = PropertyUtils.propertyLoader("\\src\\main\\resources\\Data.properties");
    public  Response response;
    public static final Logger logger = LogManager.getLogger(BaseClass.class);


    public Map<String, String> payload
            = new HashMap<>();

    public static  final String SEARCH_API_JSON = "C:\\Users\\tausi\\OneDrive - DP World\\Desktop\\Taqdis\\DP_World\\VBS_ApiAutomation\\src\\main\\java\\com\\qa\\Rest\\Payload\\SearchApi.Json";

    /*public ObjectMapper objectMapper = new ObjectMapper();

    public Map<String, Object> mapper1;*/


    @BeforeClass
    public void setup() {
        // Initialize Log4j
        System.setProperty("log4j.configurationFile", "C:\\Users\\tausi\\OneDrive - DP World\\Desktop\\Taqdis\\DP_World\\VBS_ApiAutomation\\log4j.xml");
    }


    /*@BeforeSuite(alwaysRun = true)
    public void setup()
    {
        *//*createRunTimeFolder.createFolder(folderPath);
        String path = "allure-results/"+timestamp;
        try {
            PropertyUtils.PropertyWriter("C:\\Users\\tausi\\OneDrive - DP World\\Desktop\\Taqdis\\DP_World\\VBS_ApiAutomation\\src\\test\\resources\\allure.properties",path);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }*//*

    }*/


}
