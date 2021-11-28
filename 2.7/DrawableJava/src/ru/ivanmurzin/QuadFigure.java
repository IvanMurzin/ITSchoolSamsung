package ru.ivanmurzin;

import java.awt.*;

public class QuadFigure extends Figure {

    int x1, x2, x3, x4;
    int y1, y2, y3, y4;


    public QuadFigure(int x1, int y1, int x2, int y2, int x3, int y3, int x4, int y4) {
        this.x1 = x1;
        this.x2 = x2;
        this.x3 = x3;
        this.x4 = x4;
        this.y1 = y1;
        this.y2 = y2;
        this.y3 = y3;
        this.y4 = y4;
    }

    @Override
    public void draw(Graphics canvas) {
        canvas.setColor(color);
        canvas.drawLine(x1, y1, x2, y2);
        canvas.drawLine(x2, y2, x3, y3);
        canvas.drawLine(x3, y3, x4, y4);
        canvas.drawLine(x4, y4, x1, y1);
        canvas.drawLine(x1, y1, x3, y3);
        canvas.drawLine(x2, y2, x4, y4);
    }
}
