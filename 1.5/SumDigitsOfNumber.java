package code;


import java.util.Scanner;

/*
Написать метод, который возвращает!! сумму цифр числа

123
6

9841
22
 */
public class SumDigitsOfNumber {

    static int statistic = 0;

    public static int sumDigits(int n) { // int n = n;
        statistic++;
        int sum = 0;
        while (n > 0) {
            sum += n % 10;
            n /= 10;
        }
        return sum;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        System.out.println("My number before counting: " + n);
        int sum = sumDigits(n);
        int sum1 = sumDigits(1234);
        int sum2 = sumDigits(1232334);
        int sum3 = sumDigits(123342344);
        System.out.println("Statistic: " + statistic);
        System.out.println("My number after counting: " + n);
        System.out.println("Sum: " + sum);

    }
}
