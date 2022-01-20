package ru.itschool;

import java.util.ArrayList;

class Cat implements Comparable<Cat> {
    int color;
    String name;
    long hungry;
    int tailLength;

    @Override
    public int compareTo(Cat o) {
        if (this.hungry == o.hungry) return 0;
        if (this.hungry > o.hungry) return 1;
        return -1;
    }

    void meow() {
        System.out.println("Хочу кушать!");
    }

    Cat(long hungry) {
        this.hungry = hungry;
    }

    @Override
    public String toString() {
        return "Cat{" +
                "color=" + color +
                ", name='" + name + '\'' +
                ", hungry=" + hungry +
                ", tailLength=" + tailLength +
                '}';
    }
}


public class Main {


    public static <T extends Number> void printArray(T[] array) {
        for (int i = 0; i < array.length; i++) {
            System.out.println((array[i]));
        }
    }

    public static <T extends Comparable<T>> T min(T[] array) {
        T min = array[0];
        for (int i = 1; i < array.length; i++) {
            if (array[i].compareTo(min) < 0) min = array[i];
        }
        return min;
    }

    public static <T extends Comparable<T>> T max(T[] array) {
        T max = array[0];
        for (int i = 1; i < array.length; i++) {
            if (array[i].compareTo(max) > 0) max = array[i];
        }
        return max;
    }


    public static Pair<Integer, Integer> getMinAndMax(Integer[] a) {
        Integer min = min(a);
        Integer max = max(a);
        return new Pair<>(min, max);
    }

    public static void main(String[] args) {
//        Integer[] a = {324, 2342, 23, 234, -123, -3, 1, 2, 3};
//        Double[] b = {1., 2., 3.};
//        String[] c = {"s", "1", "2", "2112"};
//        Cat[] cats = {new Cat(10), new Cat(100), new Cat(-10), new Cat(9)};
//        System.out.println(min(cats));
//
//        System.out.println(getMinAndMax(a));
//
//        method(new Generic<>("lala"));


        ArrayList<Integer> arrayList = new ArrayList<>();
        ArrayList<String> arrayListString = new ArrayList<>();
        arrayListString.add("asd");

    }


    public static void method(Generic<?> generic) {

    }
}


class NumberPair<T1 extends Comparable<T2>, T2 extends Comparable<T1>> {
    T1 t1;
    T2 t2;

    public NumberPair(T1 t1, T2 t2) {
        this.t1 = t1;
        this.t2 = t2;
    }

    public T1 getFirst() {
        return t1;
    }

    public T2 getSecond() {
        return t2;
    }

}


class Pair<T1, T2> {

    @Override
    public String toString() {
        return "Pair{" +
                "t1=" + t1 +
                ", t2=" + t2 +
                '}';
    }

    T1 t1;
    T2 t2;

    public Pair(T1 t1, T2 t2) {
        this.t1 = t1;
        this.t2 = t2;
    }

    public T1 getFirst() {
        return t1;
    }

    public T2 getSecond() {
        return t2;
    }
}

class SuperGeneric {
    Object t;

    public SuperGeneric(Object t) {
        this.t = t;
    }

    public Object getT() {
        return t;
    }

    void print() {
        System.out.println("Value T:" + t.toString());
        System.out.println("Type  T:" + t.getClass().getName());
    }
}


class Generic<T> {
    T t; // объявило объект типа t

    public Generic(T t) {
        this.t = t;
    }

    public T getT() {
        return t;
    }

    public void print() {
        System.out.println("Value T:" + t.toString());
        System.out.println("Type  T:" + t.getClass().getName());
    }
}