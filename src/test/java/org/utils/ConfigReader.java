package org.utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ConfigReader {

    public static Properties properties;

    static {

        try{

            FileInputStream fileInputStream = new FileInputStream("src/test/java/org/resources/application.properties");
            properties = new Properties();
            properties.load(fileInputStream);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static String getProperties(String key){
        return properties.getProperty(key);
    }
}
