package utils;

import org.yaml.snakeyaml.Yaml;
import java.io.*;
import java.util.HashMap;
import java.util.LinkedHashMap;

public class ReadYaml {
    HashMap<String, Object> data = new HashMap<>();

    public ReadYaml() throws IOException {
        readYamlFile();
    }

    public String getUserName(){
        return data.get("username").toString();
    }

    public String getPassword(){
        return data.get("password").toString();
    }

    public void readYamlFile() throws IOException {
        final String propertyFilePath= "resource/users.yml";
        BufferedReader reader = new BufferedReader(new FileReader(propertyFilePath));
        Yaml yaml = new Yaml();
        data = yaml.load(reader);
    }

//    public JiraCredentials readYamlFileWithObject() throws FileNotFoundException {
//        final String propertyFilePath= "resource/users.yml";
//        BufferedReader reader = new BufferedReader(new FileReader(propertyFilePath));
//        Yaml yaml = new Yaml();
//        JiraCredentials jiraCredentials =  yaml.load(reader);
//        return jiraCredentials;
//    }
}
