package com.qa.Rest.auto;

import com.qa.Rest.POJO.Search;
import com.qa.Rest.api.TokenManager;
import com.qa.Rest.utils.PropertyUtils;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.testng.annotations.Test;

import java.io.*;
import java.nio.file.Files;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.io.IOException;
import java.nio.file.Path;
import java.util.Properties;

public class SearchCall {


    public Map<String, Object> jsonData = new LinkedHashMap<>();
    public String a;

    Map<String, String> map
            = new HashMap<String, String>();
    BufferedReader br = null;

    //public Properties p = PropertyUtils.propertyLoader("C:\\Users\\tausi\\OneDrive - DP World\\Desktop\\Taqdis\\DP_World\\VBS_ApiAutomation\\src\\main\\resources\\Data.properties");
    String filePath
            = "\\src\\main\\java\\com\\qa\\Rest\\Payload\\SearchApi.Json";
    public File file = new File(filePath);


    public void SetSearchPayload(String Filter,String Data) throws IOException {


        try {
            /*String filePath
                    = "C:\\Users\\tausi\\OneDrive - DP World\\Desktop\\Taqdis\\DP_World\\VBS_ApiAutomation\\src\\main\\java\\com\\qa\\Rest\\Payload\\SearchApi.Json";
            // create file object
            File file = new File(filePath);*/

            // create BufferedReader object from the File
            br = new BufferedReader(new FileReader(file));

            String line = null;

            // read file line by line
            while ((line = br.readLine()) != null) {

                String c = line;
                if(c.contains("{") || c.contains("}"))
                {
                    jsonData.put(c,"");
                }
                // split the line by :
                String[] parts = line.split(":");

                //System.out.println(line);

                if ((!line.contains("{")) && (!line.contains("}"))) {
                    if (line.contains(Filter)) {
                        // first part is name, second is number
                        a = parts[0].trim();
                        a= "  "+a;
                        String Value = Data;
                        Value= ":"+" "+'"' + Value + '"'+",";
                        jsonData.put(a, Value);
                    } else {
                        a = parts[0].trim();
                        a= "  "+a;
                        String Value = parts[1].trim();
                        Value= ":"+" "+Value;
                        jsonData.put(a, Value);

                    }

               }
            }
        }

        catch (Exception e) {
            e.printStackTrace();
        }
        finally {

            // Always close the BufferedReader
            if (br != null) {
                try {
                    br.close();
                }
                catch (Exception e) {
                }
            }
        }

        File log = new File("C:\\Users\\tausi\\OneDrive - DP World\\Desktop\\Taqdis\\DP_World\\VBS_ApiAutomation\\src\\main\\java\\com\\qa\\Rest\\Payload\\SearchApi.Json");
        FileWriter fileWriter = new FileWriter(log, false);


        for (Map.Entry<String, Object> entry :
                jsonData.entrySet()) {
            System.out.println(entry.getKey()
                    + entry.getValue());
            String t = entry.getKey()
                    + entry.getValue();
            File log1 = new File("C:\\Users\\tausi\\OneDrive - DP World\\Desktop\\Taqdis\\DP_World\\VBS_ApiAutomation\\src\\main\\java\\com\\qa\\Rest\\Payload\\SearchApi.Json");
            FileWriter fileWriter1 = new FileWriter(log1, true);
            /*FileWriter fWriter = new FileWriter(
                    "C:\\Users\\tausi\\OneDrive - DP World\\Desktop\\Taqdis\\DP_World\\VBS_ApiAutomation\\src\\main\\java\\com\\qa\\Rest\\Payload\\SearchApicopy.Json");*/
            fileWriter1.write(t);
            fileWriter1.write(System.getProperty("line.separator"));
            fileWriter1.flush();

            fileWriter1.close();

        }







    }






        /*jsonData.put("username", "admin");
        jsonData.put("age", 30);
        jsonData.put("email", "aqh@gmail.com");
        jsonData.put("password", "password");
*/






        /*s. setCcsIdOrContNoOrContApptNo("");
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
        s.setOrder("");*/

    }



