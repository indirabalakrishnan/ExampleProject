package com.app.javaPrograms;

import org.testng.annotations.Test;

import java.util.*;
import java.util.stream.Collectors;

public class HashmapPrograms {
    public String testString = "My name is Indira Balakrishnan. I am a mother and I would love to learn new things and take up challenging roles";
    public String[] words = testString.split(" ");

    @Test
    public void HashMapTest() {
        HashMap<String, Integer> map = new HashMap<>();
        for (String word : words) {
            if (map.containsKey(word)) {
                map.put(word, map.get(word) + 1);
            } else map.put(word, 1);
        }

        System.out.println(map);

        for (String s : map.keySet()) {
            System.out.println(s + " : " + map.get(s));
        }
    }

    @Test
    public void reverseStringTest() {
        //Type 1
        String reverseString = "";
        StringBuilder stringBuilder = new StringBuilder();
        for (String word : words) {
            StringBuilder eachWord = new StringBuilder(word);
            stringBuilder = stringBuilder.append(eachWord.reverse()).append(" ");
        }
        reverseString = stringBuilder.toString();
        System.out.println(reverseString);

        //Type 2
        reverseString = "";
        for (String word : words) {
            StringBuilder eachWord = new StringBuilder(word);
            reverseString = reverseString + eachWord.reverse() + " ";
        }
        System.out.println(reverseString);
    }

    @Test
    public void countEachCharInString() {
        // Put each characters in the Hashmap
        char[] charArray = testString.toCharArray();
        HashMap<Character, Integer> hashMap = new HashMap<>();
        for (char c : charArray) {
            if (hashMap.containsKey(c)) {
                hashMap.put(c, hashMap.get(c) + 1);
            } else
                hashMap.put(c, 1);
        }

        // Iterator
        Iterator iterator = hashMap.entrySet().iterator();
        while (iterator.hasNext()) {
            Map.Entry<Character, Integer> e1 = (Map.Entry<Character, Integer>) iterator.next();
            System.out.println(e1.getKey());
            System.out.println(e1.getValue());
        }

        //Entry Set - search
        Set<Map.Entry<Character, Integer>> entrySet = hashMap.entrySet();
        for (Map.Entry<Character, Integer> entry : entrySet) {
            if (entry.getKey().equals('p')) {
                System.out.println("Ayyappan " + entry.getValue());
            }
        }

        // Printing hashmap
        System.out.println(hashMap.toString());

        //Get the length of the Key Set
        System.out.println(hashMap.entrySet().stream().count());

    }

    @Test
    public void getMaxMinValueInHashMap() {
        testString = testString.replace(" ", "").toLowerCase(Locale.ROOT);
        char[] charArray = testString.toCharArray();
        HashMap<Character, Integer> hashMap = new HashMap<>();
        for (char c : charArray) {
            if (hashMap.containsKey(c)) {
                hashMap.put(c, hashMap.get(c) + 1);
            } else
                hashMap.put(c, 1);
        }

        int max = hashMap.get(charArray[0]), min = hashMap.get(charArray[0]);

        //EntrySet
        Set<Map.Entry<Character, Integer>> entrySet = hashMap.entrySet();
        for (Map.Entry<Character, Integer> entry : entrySet) {
            if (entry.getValue() <= min)
                min = entry.getValue();
            if (entry.getValue() >= max)
                max = entry.getValue();
        }

        System.out.println(hashMap.containsValue(min));

        for (Map.Entry<Character, Integer> entry : entrySet) {
            if (entry.getValue() == min)
                System.out.println("Less occurances = " + entry.getKey() + " , " + entry.getValue());
            if (entry.getValue() == max)
                System.out.println("More occurances = " + entry.getKey() + " , " + entry.getValue());
        }
    }

    @Test
    public void checkPalindromeTest() {
        String a = "madam";
        if (a.equals(new StringBuilder(a).reverse().toString())) System.out.println("YES");
    }

    @Test
    public void checkCanWeFormPalindromeTest() {
        String a = "yyrrzzxxxy";
        Integer flag = 0;
        char[] c = a.toLowerCase(Locale.ROOT).toCharArray();
        HashMap<Character, Integer> hashMap = new HashMap<>();
        for (char c1 : c) {
            if (hashMap.containsKey(c1)) hashMap.put(c1, hashMap.get(c1) + 1);
            else hashMap.put(c1, 1);
        }
        Set<Map.Entry<Character, Integer>> entrySet = hashMap.entrySet();
        for (Map.Entry<Character, Integer> entry : entrySet) {
            if (entry.getValue() % 2 == 0) continue;
            else flag++;
            if (flag == 2) break;
        }
        if (flag == 0 || flag == 1) System.out.println("Can form Palindrome");
        else System.out.println("Cannot form Palindrome");
    }

    @Test
    public void streamPrintTest() {
        testString = testString.replace(" ", "").toLowerCase(Locale.ROOT);
        char[] charArray = testString.toCharArray();
        HashMap<Character, Integer> hashMap = new HashMap<>();
        for (char c : charArray) {
            if (hashMap.containsKey(c)) {
                hashMap.put(c, hashMap.get(c) + 1);
            } else
                hashMap.put(c, 1);
        }
        System.out.println(hashMap);

        //returns the count of key-value pair in hashmap
        System.out.println(hashMap.entrySet().stream().count());

        //Streams and prints the entries in hashmap
        //below 2 gives the same output
        hashMap.entrySet().forEach(System.out::println);
        hashMap.entrySet().stream().forEach(System.out::println);
    }

    @Test
    public void streamFilterTest(){
        HashMap<String, String> hashMap = new HashMap<>();
        hashMap.put("Rani", "Balakrishnan");
        hashMap.put("Raje", "Murugesh");
        hashMap.put("Jaya", "Gopinath");
        hashMap.put("Indira", "Rajesh");
        hashMap.put("Rishaan", "Rajesh");
        hashMap.put("Riyaan", "Rajesh");
//        hashMap.entrySet().stream().forEach(System.out::println);

        System.out.println(hashMap.entrySet().stream().filter(e -> e.getValue().equals("Rajesh")).map(Map.Entry::getKey).findFirst().get());
        System.out.println(hashMap.entrySet().stream().filter(e -> e.getValue().equals("Rajesh")).map(Map.Entry::getKey).collect(Collectors.toList()));
    }
}
