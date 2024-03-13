package com.qa.Rest.utils;

import java.io.*;
import java.nio.file.Files;
import java.util.Properties;

public class PropertyUtils {

    Properties properties = new Properties();
    BufferedReader reader;

    public static Properties propertyLoader(String filePath) {
        Properties properties = new Properties();
        BufferedReader reader;
        try {
            //reader = new BufferedReader(new FileReader(filePath));
            FileInputStream input = new FileInputStream(filePath);
            try {
                properties.load(input);
                input.close();
            } catch (IOException e) {
                e.printStackTrace();
                throw new RuntimeException("failed to load properties file " + filePath);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            throw new RuntimeException("properties file not found at " + filePath);
        }
        return properties;
    }

    public static Properties PropertyWriter(String filePath, String key,String Value) throws IOException {
        {
            FileInputStream in = new FileInputStream(filePath);
            Properties props = new Properties();
            props.load(in);
            in.close();
            FileOutputStream out = new FileOutputStream(filePath,false);
            props.setProperty(key,Value);
            props.store(out, null);
            out.close();
        }
        /*try {
            FileWriter myWriter = new FileWriter(filePath,true);
           // myWriter.write("allure.results.directory="+ResultPath);
            myWriter.write(ResultPath);
            myWriter.flush();
            myWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        try (FileInputStream in = new FileInputStream(filePath)) {
            props.load(in);
        } catch (IOException e) {
            e.printStackTrace();
        }

        *//*try (FileOutputStream out = new FileOutputStream(filePath)) {
            props.setProperty("allure.results.directory",ResultPath);
            props.store(out, null);

        } catch (IOException ioException) {
            ioException.printStackTrace();
        } ;*//*
        return props;*/

         return null;
        }



    public static String readDataFile(String file_path,String key) throws IOException {
        FileInputStream fis = new FileInputStream(file_path);
        Properties prop = new Properties();
        prop.load(fis);
        return prop.getProperty(key);
    }



    }


