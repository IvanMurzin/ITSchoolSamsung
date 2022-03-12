package com.company;

import java.util.Scanner;
import java.util.TreeMap;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        TreeMap<String, TreeMap<String, Integer>> kents = new TreeMap<>();
        while (in.hasNext()) {
            String name = in.next();
            String buy = in.next();
            int count = in.nextInt();
            if (!kents.containsKey(name)) { // если в кентах нет нашего покупателя
                TreeMap<String, Integer> goods = new TreeMap<>();
                goods.put(buy, count);
                kents.put(name, goods);
            } else { // наш кент уже что-то покупал
                TreeMap<String, Integer> goods = kents.get(name);
                goods.put(buy, goods.getOrDefault(buy, 0) + count);
            }
        }

        for (String kentName : kents.keySet()) {
            System.out.println(kentName + ":");
            for (String buyName : kents.get(kentName).keySet()) {
                System.out.println(buyName + " " + kents.get(kentName).get(buyName));
            }
        }
    }
}



