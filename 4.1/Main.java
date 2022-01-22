package com.company;

import java.util.*;


public class Main {
    public static void main(String[] args) {
        MyArrayList<String> a = new MyArrayList<>();
        a.add("lol");
        a.add("1");
        a.add(1+"");
        System.out.println(a.get(1));
    }


    public static int binarySearch(int[] a, int key) {
        return mainBinSearch(a, key, 0, a.length - 1);
    }

    public static int mainBinSearch(int[] a, int key, int low, int hi) {
        if (low > hi) throw new IllegalArgumentException("Нижний индекс оказался выше");
        if (low < 0 || hi > a.length) throw new IllegalArgumentException("Индексы введены неверно");
        int mid = 0;
        int iters = 0;
        while (low <= hi) {
            ++iters;
            mid = (low + hi) / 2;
            int value = a[mid];
            if (value == key) {
                System.out.println(iters);
                return mid;
            } else if (value > key) hi = mid - 1;
            else low = mid + 1;
        }
        return -mid - 1;
    }
}

class Cat implements Comparable<Cat> {
    long tail;

    public Cat(long tail) {
        this.tail = tail;
    }

    @Override
    public String toString() {
        return "Cat{" +
                "tail=" + tail +
                '}';
    }

    @Override
    public int compareTo(Cat o) {
        if (tail < o.tail) return 1;
        if (tail == o.tail) return 0;
        return -1;
    }
}