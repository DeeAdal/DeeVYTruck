package com.deeVYTruck.Utilis;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ConfigurationReader {
    // 1 Create the object of Properties class
    // We need properties class to use methods coming from class like load(), getProperty("key")
    // It is static because we are using it in static method
    // It is private because I will be using it only in this class
    private static Properties properties = new Properties();

    // We want to open the properties file and load to properties object ONLY ONCE before reading
    // having static block because static runs first

    static {
        try {
            // 2 Create the object of FileInputStream
            // We need this object to open file as a stream in Java memory
            FileInputStream file = new FileInputStream("config.properties");

            // 3 Load the Properties object using FileInputStream object
            // Load "properties" object with the "file" we opened using FileInputStream
            properties.load(file);

            //close the file after loading. If we do not close the file, we use memory space like Scanner
            file.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * This method is used to read value from a configuration.properties file
     * @param keyword --> key name in configuration.properties file
     * @return --> value for the key. returns null if key is not found
     * driver.get(ConfigurationReader.getProperty("env"))
     */
    public static String getProperty(String keyword) {

        return properties.getProperty(keyword);
    }

}
