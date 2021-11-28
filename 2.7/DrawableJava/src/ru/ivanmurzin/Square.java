package ru.ivanmurzin;

public class Square extends Rectangle {

    public Square(int x, int y, int a) {
        super(x, y, x + a, y + a);
    }
}
