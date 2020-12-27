package ru.job4j.collection;

import java.util.HashMap;
import java.util.Map;

public class UsageMap {
    public static void main(String[] args) {
        HashMap<String, String> map = new HashMap<>();
        map.put("johnsmith@com.com", "John Smith");
        map.put("amandamint@com.com", "Amanda Mint");
        for (Map.Entry<String, String> entry : map.entrySet()) {
            System.out.printf("Key is %s, value is %s" + System.lineSeparator(), entry.getKey(), entry.getValue());
        }
    }
}