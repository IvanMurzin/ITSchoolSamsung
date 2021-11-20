package ru.ivanmurzin.mathtrainer;

import org.junit.Test;

public class ExampleUnitTest {
    MathGenerator mathGenerator = new MathGenerator();

    @Test
    public void test1() {
        int random = mathGenerator.getRandom(10, -10);
        assert (-10 <= random && random <= 10);
    }

    @Test
    public void test2() {
        for (int i = 0; i < 10; i++) {
            int a = mathGenerator.getRandom(-5, 5);
            System.out.println(a);
        }
    }
}