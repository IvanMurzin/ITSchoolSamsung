package ru.ivanmurzin.mathtrainer;

public class MathGenerator {

    private int result;

    public String getProblem() {
        int a = getRandom(-50, 50);
        int b = getRandom(0, 50);
        char sign = getRandomSign();
        if (sign == '+') {
            result = a + b;
            return a + " + " + b;
        } else {
            result = a - b;
            return a + " - " + b;
        }
    }

    public char getRandomSign() {
        int a = getRandom(3, 1); // 1 2
        if (a == 1)
            return '+';
        return '-';
    }

    public String getResult() {
        return String.valueOf(result);
    }

    public String getNoiseResult() {
        return String.valueOf(result + getRandom(-5, 5));
    }

    public int getRandom(int max, int min) {
        int random = 0;
        while (random == 0)
            random = (int) (Math.random() * (max - min) + min);
        return random;
    }
}
