package code;

/*
Выведите значение наименьшего из всех положительных элементов в массиве.
Известно, что в массиве есть хотя бы один положительный элемент.
 */

import java.util.Scanner;

public class MassiveManipulation {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int a[] = new int[n];
        for (int i = 0; i < n; i++) {
            int input = in.nextInt();
            a[i] = input;
        }
        int min = a[0];
        for (int i = 0; i < n; i++) {
            if (a[i] > 0 && a[i] < min || min < 0) {
                min = a[i];
            }
        }
        System.out.println(min);
    }
}

