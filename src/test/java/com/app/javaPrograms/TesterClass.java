package com.app.javaPrograms;

import org.apache.commons.lang3.RandomStringUtils;
import utils.ConfigManager;
import utils.JiraCredentials;
import utils.ReadYaml;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.SQLOutput;
import java.sql.Timestamp;
import java.util.Date;
import java.util.Random;

public class TesterClass {
    public static void main(String[] args) throws IOException {
        Date date = new Date();
        System.out.println(date);
        System.out.println(System.currentTimeMillis());
        System.out.println(new Timestamp(System.currentTimeMillis()));
//        System.out.println(Math.random());
//        Random random = new Random();
//        System.out.println(random.nextInt());
//        System.out.println(generateRandomNosBetweenGivenNumbers());
//        random.ints(5, 50, 90).forEach(System.out::println);
//        System.out.println(RandomStringUtils.random(5, true, true));
//        System.out.println(generateRandomString());
//        System.out.println(getUrl());
//        ReadYaml readYaml = new ReadYaml();
//        System.out.println(readYaml.getUserName());
//        System.out.println(readYaml.getPassword());
    }

    public static int generateRandomNosBetweenGivenNumbers(){
        double num = Math.random();
        int min = 1000;
        int max = 2000;
        return (int)(num * (max-min+1)+min);
    }

    public static String generateRandomString(){
        return RandomStringUtils.random(5, true, true);
    }

    public static String getUrl(){
        return ConfigManager.getInstance().getString("baseURL");
    }
}
