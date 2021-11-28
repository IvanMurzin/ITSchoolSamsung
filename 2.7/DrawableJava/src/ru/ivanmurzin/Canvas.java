package ru.ivanmurzin;

import javax.swing.*;
import java.awt.*;

public class Canvas extends JPanel {
    Color bgColor;
    int bgWidth;
    int bgHeight;
    Figure[] figures;

    public void setFigures(Figure[] figures) {
        this.figures = figures;
    }

    public Canvas(Color bgColor, int bgWidth, int bgHeight, Figure[] figures) {
        this.bgColor = bgColor;
        this.bgWidth = bgWidth;
        this.bgHeight = bgHeight;
        this.figures = figures;
    }

    @Override
    public void paint(Graphics canvas) {
        canvas.setColor(bgColor);
        canvas.fillRect(0, 0, bgWidth, bgHeight);
        for (Figure figure : figures) {
            canvas.setColor(figure.color);
            figure.draw(canvas);
        }
        super.paintComponents(canvas);
    }
}
