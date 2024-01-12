package com.qa.Rest.utils;

import java.io.*;
import java.util.Properties;

public class PropertyUtils {

    Properties properties = new Properties();
    BufferedReader reader;
    public static Properties propertyLoader(String filePath) {
        Properties properties = new Properties();
        BufferedReader reader;
        try {
            reader = new BufferedReader(new FileReader(filePath));
            try {
                properties.load(reader);
                reader.close();
            } catch (IOException e) {
                e.printStackTrace();
                throw new RuntimeException("failed to load properties file "+ filePath);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            throw new RuntimeException("properties file not found at " + filePath);
        }
        return properties;
    }

    public static Properties PropertyWriter(String filePath,String ResultPath) throws FileNotFoundException {
        Properties props = new Properties();

        /*try {
            FileWriter myWriter = new FileWriter(filePath);
            myWriter.write("allure.results.directory="+ResultPath);
            myWriter.flush();
            myWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }*/

        try (FileInputStream in = new FileInputStream(filePath)) {
            props.load(in);
        } catch (IOException e) {
            e.printStackTrace();
        }

        try (FileOutputStream out = new FileOutputStream(filePath)) {
            props.setProperty("allure.results.directory",ResultPath);
            props.store(out, null);

        } catch (IOException ioException) {
            ioException.printStackTrace();
        } ;
        return props;

    }


    }


