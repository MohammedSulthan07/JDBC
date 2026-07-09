package com.hibernate.config;


import com.hibernate.exception.InternalServiceException;

import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;
import java.util.List;
import java.util.Properties;

public class PropertiesConfig {

    private static final Properties properties=new Properties();
    private static final PropertiesConfig instance=new PropertiesConfig();

    private PropertiesConfig(){
        List<String> filesToLoad= Arrays.asList("message.properties");
        filesToLoad.forEach(file->{
            InputStream in=getClass().getClassLoader().getResourceAsStream(file);
            if (in!=null) {
                try {
                    properties.load(in);
                } catch (IOException e) {
                    throw new InternalServiceException(e.getMessage());
                }
            }else{
                throw new InternalServiceException("File failed to Load: " + file);
            }
        });
    }
    public static PropertiesConfig getInstance(){
        return instance;
    }

    public static String getProperty(String key) {
        return properties.getProperty(key);
    }
}