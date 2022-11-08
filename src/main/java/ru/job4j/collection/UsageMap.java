package ru.job4j.collection;

import java.util.HashMap;

public class UsageMap {
    public static void main(String[] args) {
        HashMap<String, String> map = new HashMap<>();
        map.put("post@mail.com", "Иванов А.А.");
        map.put("mail@mail.com", "Сидоров А.А.");
        map.put("post@mail.com", "Петров А.А.");
        for (String key : map.keySet()) {
            String value = map.get(key);
            System.out.println(key + " " + value);
        }
    }
}
