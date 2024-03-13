package com.qa.Rest.api;

import com.qa.Rest.Payload.Payloads;
import com.qa.Rest.auto.BaseClass;
import io.restassured.response.Response;
import com.qa.Rest.utils.PropertyUtils;

import java.io.File;
import java.util.Properties;


public class RestCalls extends BaseClass {

    //public static Properties p1 = PropertyUtils.propertyLoader("\\src\\main\\resources\\Config.properties");


    /*public static Response post(File f){
        return RestResources.post(p1.getProperty("BaseURL"),TokenManager.getToken(),f);


    }*/

    public static Response post(String BaseURL,String Endpoint,Object p){
        return RestResources.post(BaseURL,Endpoint,p);

    }

    public static Response put(String BaseURL,String Endpoint,String queryParam){
        return RestResources.put(BaseURL,Endpoint,queryParam);

    }

    public static Response put(String BaseURL,String Endpoint){
        return RestResources.put(BaseURL,Endpoint);

    }

    public static Response delete(String BaseURL,String Endpoint){
        return RestResources.delete(BaseURL,Endpoint);

    }



    /*public static Response post(String p){
        return RestResources.post(p1.getProperty("BaseURL"),TokenManager.getToken(),p);


    }*/

    public static Response get(String BaseURL,String EndPoint){
        return RestResources.get(BaseURL,EndPoint);


    }










}
