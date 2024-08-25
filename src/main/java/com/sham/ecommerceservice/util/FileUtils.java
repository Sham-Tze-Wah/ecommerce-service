package com.sham.ecommerceservice.util;

import com.sham.ecommerceservice.pojo.ProductFilterParam;

import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class FileUtils {

    public static void readFiles(File file) throws FileNotFoundException {
        String fileName = file.getName();
        int fileExtensionIndex = fileName.lastIndexOf(".");
        if(fileExtensionIndex == -1){
            throw new FileNotFoundException("Unable to find the file extension");
        }
        String fileExtension = ".".concat(fileName.substring(fileExtensionIndex, fileName.length()-1));

        switch(fileExtension) {
            case ".xlsx", ".xls" -> {
                System.out.println("File extension is for Excel file");
            }
            case ".txt" -> {
                System.out.println("File extension is for Text file");
            }
            case ".word" -> {
                System.out.println("File extension is for Word file");
            }
            case ".csv" -> {
                System.out.println("File extension is for Csv file");
            }
            default -> {
                System.out.println("The file extension is not supported yet.");
            }
        }
    }
}
