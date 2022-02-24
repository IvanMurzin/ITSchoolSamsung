package ru.ivanmurzin.reqursion;

import org.junit.Test;

public class ExampleUnitTest {

    double nPow(double x, int n) {
        if (n == 0) return 1.;
        if (n > 0)
            return x * nPow(x, n - 1);
        if (n < 0)
            return 1. / nPow(x, -n);
        return -1;
    }

    double nPowFor(double x, int n) {
        double result = 1;
        if (n == 0) return 1;
        if (n > 0) {
            for (int i = 0; i < n; i++)
                result *= x;
            return result;
        }
        n = -n;
        for (int i = 0; i < n; i++)
            result *= x;
        return 1. / result;
    }

    long nFib(int n) {
        if (n == 0 || n == 1)
            return 1;
        return nFib(n - 1) + nFib(n - 2);
    }


    @Test
    public void main() {
        double x = 1.000000001;
        int n = 5_000_000;
        System.err.println("\n-----------------\n");
        for (int i = 0; i < 3000; i++) {
            System.out.println("Fibonacci(" + i + ")=" + nFib(i));
        }
        System.err.println("\n-----------------\n");
    }
}