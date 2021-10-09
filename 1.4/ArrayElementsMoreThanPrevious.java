package code;

/*
Два массив массив чисел. Вывести все элементы массивы,
которые больше предыдущего элемента

Input:
5
1 5 2 4 3
Output:
5 4
 */

import java.util.Scanner;

public class ArrayElementsMoreThanPrevious {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] array = new int[n];
        for (int i = 0; i < array.length; ++i) array[i] = in.nextInt();

        for (int i = 1; i < array.length; ++i) {
            if (array[i] > array[i - 1])
                System.out.print(array[i] + " ");
        }
    }
}
