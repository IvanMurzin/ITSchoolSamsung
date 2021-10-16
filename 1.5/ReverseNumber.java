package code;

import java.util.Scanner;

public class ReverseNumber {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int number = in.nextInt();
        int result = 0;
        while (number > 0) {
            result = result * 10 + number % 10;
            number /= 10;
        }
        System.out.print(result);
    }
}