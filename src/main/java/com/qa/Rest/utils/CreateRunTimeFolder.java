package com.qa.Rest.utils;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.Files;
import java.text.SimpleDateFormat;
import java.util.Date;

public class CreateRunTimeFolder  {



    public  void createFolder(String folderPath) {
        Path path = Paths.get(folderPath);

        try {
            // Create directories if they don't exist
            Files.createDirectories(path);
            System.out.println("Folder created: " + path.toString());
        } catch (Exception e) {
            System.err.println("Failed to create folder: " + path.toString());
            e.printStackTrace();
        }
    }
}
