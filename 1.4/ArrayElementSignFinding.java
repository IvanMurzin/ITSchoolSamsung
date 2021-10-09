package code;

import java.util.Scanner;

/*
Дан массив чисел. Если в нем есть два соседних элемента одинакого знака,
то вывести эти числа. Если пар несколько, то вывести первую.
Input:
7
-1 0 2 3 -1 -2 8 9
Output:
2 3
 */
public class ArrayElementSignFinding {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] array = new int[n];
        for (int i = 0; i < array.length; ++i) array[i] = in.nextInt();

        for (int i = 0; i < array.length - 1; ++i) {
            if (array[i] * array[i + 1] > 0) {
                System.out.println(array[i] + " " + array[i + 1]);
                break;
            }
        }
    }
}
// 2 * 3 > 0
// -2 * -3 > 0