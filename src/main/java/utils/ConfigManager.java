package utils;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class ConfigManager {

    private static ConfigManager configManager;
    private static final Properties properties =  new Properties();
    private final String propertyFilePath= "resource/config.properties";

    private ConfigManager() throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader(propertyFilePath));
        properties.load(reader);
    }

    public static ConfigManager getInstance(){
        if(configManager == null){
            synchronized (ConfigManager.class){
                try{
                    configManager = new ConfigManager();
                } catch (IOException exception){
                    exception.printStackTrace();
                }
            }
        }
        return configManager;
    }

    public String getString(String key){
        return System.getProperty(key, properties.getProperty(key));
    }
}