package code;

import java.util.Scanner;

/*
Дан массив чисел. Необходимо переставить соседние элементы местами.
Если элементов нечетное число, то поледний элемент остается на своем месте
Input:
5
1 2 3 4 5
Output:
2 1 4 3 5

Input:
6
1 2 3 4 5 6
Output:
2 1 4 3 6 5
 */

public class ArrayElementSwapNeighbors {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] array = new int[n];
        for (int i = 0; i < array.length; ++i) array[i] = in.nextInt();

        for (int i = 0; i < array.length - 1; i += 2) {
            int temp = array[i];
            array[i] = array[i + 1];
            array[i + 1] = temp;
        }
        for (int element : array) System.out.print(element + " ");
    }
}