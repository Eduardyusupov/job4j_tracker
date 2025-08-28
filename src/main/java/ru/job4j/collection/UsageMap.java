package ru.job4j.collection;

import java.util.HashMap;

public class UsageMap {

    public static void main(String[] args) {
        HashMap<String, String> hashMap = new HashMap<>();
        hashMap.put("usupov-1992@yandex.ru", "Юсупов Эдуард Ирикович");
        hashMap.put("usupov-1992@yandex.ru", "Иван Агапов");
        hashMap.put("mayle@yandex.ru", "Maйкл Майколович");
        hashMap.put("marat@yandex.ru", "Marat Maratovic");
        for (String key : hashMap.keySet()) {
            System.out.println(hashMap.get(key));
        }
    }
}
