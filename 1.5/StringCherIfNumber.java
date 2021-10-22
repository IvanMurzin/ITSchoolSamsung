package code;

import java.util.Scanner;

/*
На вход подается строчка. Необходимо проверить,
является ли она числом

123 -> yes
123-321 -> no
 */
public class StringCherIfNumber {

    static char[] digits = {'1', '2', '3', '4', '5', '6', '7', '8', '9', '0'};

    public static boolean isDigit(char c) { //4
        for (char digit : digits)
            if (digit == c) return true;

        System.out.println("Я ничего не нашел :С " + c + " Это не цифра");
        return false;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String number = in.next();
        boolean isNumber = true;

        int start = 0;
        if (number.charAt(0) == '-') start = 1;

        for (int i = start; i < number.length(); i++) {
            char character = number.charAt(i);
            if (!isDigit(character)) {
                System.out.println("Ложь, это не число");
                isNumber = false;
                break;
            }
        }
        if (isNumber)
            System.out.println("Все хорошо, это число");
    }
}
