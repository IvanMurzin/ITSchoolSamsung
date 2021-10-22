package code;
/*
Определить, является ли число простым

2 3 5 7 11 13 17...
 */


public class IsPrime {

    public static boolean isPrime(int a) {
        if (a == 1) return false;
        for (int i = 2; i <= Math.sqrt(a); i++)
            if (a % i == 0) return false;
        return true;
    }


    public static void main(String[] args) {
        for (int i = 1; i < 100; i++)
            System.out.println(i + " " + isPrime(i));

    }
}
