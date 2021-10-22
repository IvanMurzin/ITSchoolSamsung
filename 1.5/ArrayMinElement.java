package code;


import java.util.Scanner;

/*
Дан массив чисел. Написать функцию, которая ищет минимум в массиве
6
3 5 -1 9 -10 80

-10
 */
public class ArrayMinElement {

    public static int minArray(int[] a) {
        int min = a[0];
        for (int i = 0; i < a.length; ++i)
            if (a[i] < min) min = a[i];
        return min;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] a = new int[n];
        for (int i = 0; i < a.length; i++) a[i] = in.nextInt();
        int min = minArray(a);
        System.out.println(min);
    }
}
