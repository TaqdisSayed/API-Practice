package com.qa.Rest.Payload;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.qa.Rest.POJO.AppointmentType;
import com.qa.Rest.POJO.LineId;
import com.qa.Rest.POJO.Search;
import com.qa.Rest.POJO.Status;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.json.JSONObject;


import java.awt.*;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;


public class Payloads {

    public static ObjectMapper objectMapper = new ObjectMapper();

    public static Map<String, Object> mapper1;

    public static ObjectNode objNode;

    public static ArrayNode namesNode;

    public static String jsonRequest;

    public static JSONObject jsonObject;


    public static Search SearchRequestFromPoJo() {
        System.out.println("inside playlist builder");
        return Search.
                builder().
                ccsIdOrContNoOrContApptNo("CAMCR000035Y").
                apptDateTo("").
                apptDateFrom("").
                subContractCompanyId("").
                subContractCompanyName("").
                apptDateTo("").
                truckingCompanyName("")
                // appointmentType(AppointmentType.builder().methods(new String[]{"",""}).build())
                .appointmentType(new String[]{})
                .clientCode("").
                driverPortPassId("").
                lineId(new String[]{}).
                //lineId(LineId.builder().id(new String[]{"",""}).build()).
                        passNo("").
                order("").
                grade("").
                pageNo("").
                pageSize("").
                site("").
                referenceNo("").
                status(new String[]{}).
                //status(Status.builder().st(new String[]{"",""}).build()).
                        truckId("").
                truckVisitAppointmentNo("").
                build();


    }


    public static void ReadExcel(String file) throws IOException {

        String excelFilePath = "src\\test\\java\\TestData\\Create.xlsx";

        String RowID = "1";

        FileInputStream inputStream = new FileInputStream(excelFilePath);
        Workbook workbook = new XSSFWorkbook(inputStream) ;
        // Assuming you are reading the first sheet. Change the index if needed.
        Sheet sheet = workbook.getSheetAt(0);

        int rowCount = sheet.getPhysicalNumberOfRows();

        int columnCount = sheet.getRow(0).getPhysicalNumberOfCells();

        String a = null;
        int k =0;
        int row =0;
        String key=null;
        String value= null;
        for( k= 0;k<=rowCount-1;k++)
        {
            a = sheet.getRow(k).getCell(0).getStringCellValue();
            if(a.equals(RowID))
            {
                for(int j=1;j<=columnCount-1;j++)
                {

                    for (int i=0;i<=k;i=i+k)
                    {
                        a = sheet.getRow(i).getCell(j).getStringCellValue();
                        //System.out.println(a);


                        if(i==0){
                            key = a;
                        }else{
                            value = a;
                            mapper1.put(key,value);
                        }


                    }
                }







            }
        }

    }



    public static Map<String, Object> setgetPayload(String jsonPayload, String Attribute_type, String key, String value) throws IOException {
        mapper1 = objectMapper.readValue(new File(jsonPayload),
                new TypeReference<Map<String, Object>>() {
                });


        String type = Attribute_type;
        switch (type) {
            case "Array":
                System.out.println("Array");
                objNode = objectMapper.createObjectNode();
                namesNode = objNode.arrayNode();
                namesNode.add(value);
                mapper1.put(key, namesNode);
                jsonRequest = objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(mapper1);
                System.out.println(jsonRequest);
                break;
            case "NonArray":
                System.out.println("NonArray");
                mapper1.put(key, namesNode);
                jsonRequest = objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(mapper1);
                System.out.println(jsonRequest);
                break;
            case "Array2":
                System.out.println("Wednesday");
                break;
        }


        return mapper1;


    }


    public static Map<String, Object> setgetPayload(String Json, String TestData) throws IOException {
        mapper1 = objectMapper.readValue(new File(Json),
                new TypeReference<Map<String, Object>>() {
                });
        ReadExcel(TestData);
        /*mapper1.put("bookingNo","NOISO");
        mapper1.put("truckId","DTKS74");
        mapper1.put("driverPortPassId","234449877");*/
        //mapper1.put("appointmentDate","26/01/2024  20:00");
        jsonRequest = objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(mapper1);
        System.out.println(jsonRequest);
         return mapper1;

    }
}