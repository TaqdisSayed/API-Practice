package com.qa.Rest.auto;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.qa.Rest.utils.CreateRunTimeFolder;
import com.qa.Rest.utils.PropertyUtils;
import io.restassured.response.Response;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.json.JSONObject;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.lang.reflect.Method;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;


public class ExcelReader {

    public static ObjectMapper objectMapper = new ObjectMapper();

    public static Map<String, Object> mapper1;

    public static ObjectNode objNode;

    public static ArrayNode namesNode;

    public static String jsonRequest;

    public static JSONObject jsonObject;

    public void ReadExcel() throws IOException {

        String excelFilePath = "C:\\Users\\tausi\\OneDrive - DP World\\Desktop\\Taqdis\\DP_World\\VBS_ApiAutomation\\src\\test\\java\\TestData\\Create.xlsx";

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

        for( k= 0;k<=rowCount-1;k++)
        {
            a = sheet.getRow(k).getCell(0).getStringCellValue();
            if(a.equals(RowID))
            {
                for(int j=0;j<=columnCount-1;j++)
                {

                    for (int i=0;i<=k;i=i+k)
                    {
                        a = sheet.getRow(i).getCell(j).getStringCellValue();
                        System.out.println(a);
                        String key=null;
                        String value= null;
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

    }



