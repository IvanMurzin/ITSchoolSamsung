package code;

import java.util.Scanner;
/*
Дан массив чисел. Необходимо циклически сдвинуть элементы массива
на 1 елемент влево

Input:
5
1 2 3 4 5
Output:
2 3 4 5 1
 */


public class ArrayElementCycleMove {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] array = new int[n];
        for (int i = 0; i < array.length; ++i) array[i] = in.nextInt();

        for (int i = 0; i < array.length - 1; i++) {
            int temp = array[i];
            array[i] = array[i + 1];
            array[i + 1] = temp;
        }

        for (int i : array) System.out.print(i + " ");
    }
}
