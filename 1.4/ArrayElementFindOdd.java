package code;

import java.util.Scanner;

/*
* Вывести все четные элементы массива

Input:
7
1 2 2 3 3 3 4
Output:
2 2 4
 */
public class ArrayElementFindOdd {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] array = new int[n];
        for (int i = 0; i < array.length; ++i) array[i] = in.nextInt();
        for (int i = 0; i < array.length; ++i) {
            if (array[i] % 2 == 0)
                System.out.print(array[i] + " ");
        }
    }
}
