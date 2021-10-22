package code;

import java.util.Scanner;

/*
Дан массив чисел и надо посчтитать сумму цифр всех его элементов

5
12 14 10 9 3

21
 */
public class ArrayElementsDigitsSum {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] a = new int[n];
        for (int i = 0; i < n; i++) a[i] = in.nextInt();

        int globalSum = 0;
        for (int i : a) {
            globalSum += SumDigitsOfNumber.sumDigits(i);
        }
        System.out.println(globalSum);
    }
}
