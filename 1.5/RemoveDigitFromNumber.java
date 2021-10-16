package code;

import java.util.Scanner;

/*
Из натурального числа удалить заданную цифру.
Число и цифру вводить с клавиатуры. Например, задано число 5683.
Требуется удалить из него цифру 8. Получится число 563.
 */
public class RemoveDigitFromNumber {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int number = in.nextInt();
        int removeDigit = in.nextInt();
        int i = 1;
        int result = 0; // ответ
        while (number > 0) {
            int last = number % 10; // последняя цифра числа
            if (last != removeDigit){
                result += last * i;
                i *= 10;
            }
            number /= 10;
        }
        System.out.println(result);
    }
}

/*
        Scanner in = new Scanner(System.in);
        String number = in.next();
        String removeDigit = in.next();
        System.out.println(number.replace(removeDigit, ""));
 */