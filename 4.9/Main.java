package com.company;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;


// дана строчка, нужно вывести самый часто встречаемый символ и сколько раз он встречается в строке


public class Main {

    public static void findLiterals(String string) {
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < string.length(); i++) {
//            if (!map.containsKey(string.charAt(i)))
//                map.put(string.charAt(i), 1);
//            else
//                map.put(string.charAt(i), map.get(string.charAt(i)) + 1);
            map.put(string.charAt(i), map.getOrDefault(string.charAt(i), 0) + 1);
        }
        int max = -1;
        Map.Entry<Character, Integer> maxPair = null;
        for (Map.Entry<Character, Integer> pair : map.entrySet()) {
            if (max < pair.getValue()) {
                max = pair.getValue();
                maxPair = pair;
            }
        }
        System.out.println(maxPair);
    }

    public static void main(String[] args) {
        TreeMap<Integer, String> map = new TreeMap<>();
        map.put(4, "1");
        map.put(5, "2");
        map.put(53, "3");
        map.put(3, "4");
        map.put(-3, "5");
        map.put(-3342, "6");
        map.put(3342, "7");
        for (Map.Entry<Integer, String> pair : map.entrySet()) {
            System.out.println(pair);
        }
    }
}




