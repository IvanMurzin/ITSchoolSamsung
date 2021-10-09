package code;


/*
Проверить строчку, является ли она палиндромом
Input:
blaalb
Output:
yes

Input:
bla1alb
Output:
yes

Input:
Pelmen
Output:
no
 */

// bla1alb
// 123451

import java.util.Scanner;

public class CheckStringPalindrome {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String str = in.next();
        int n = str.length();
        boolean isBroken = false;
        for (int i = 0; i < n; i++) {
            if (str.charAt(i) != str.charAt(n - 1 - i)) {
                System.out.println("no");
                isBroken = true;
                break;
            }
        }
        if (!isBroken) System.out.println("yes");
    }
}

