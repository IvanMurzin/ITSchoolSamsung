package ru.ivanmurzin;

import javax.swing.*;
import java.awt.*;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        Square square = new Square(50, 50, 100);
        square.color = Color.RED;

        Rectangle rectangle = new Rectangle(100, 10, 50, 120);
        rectangle.color = Color.MAGENTA;

        Figure[] figures = {square, rectangle};

        Canvas canvas = new Canvas(Color.PINK, 500, 500, figures);

        JFrame application = new JFrame();
        application.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        application.add(canvas);
        application.setSize(500, 500);
        application.setVisible(true);

        int x = 50;
        int y = 50;
        while (true) {
            Thread.sleep(5);
            square = new Square(x, y, 100);
            square.color = Color.RED;

            rectangle = new Rectangle(100, 10, 50, 120);
            rectangle.color = Color.MAGENTA;

            Figure[] figs = {square, rectangle};

            canvas.setFigures(figs);
            canvas.repaint();
            x = (x + 1) % 500;
            y = (y + 1) % 500;
        }
    }
}
