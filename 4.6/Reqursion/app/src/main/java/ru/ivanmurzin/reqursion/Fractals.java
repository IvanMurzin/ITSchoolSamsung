package ru.ivanmurzin.reqursion;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.os.Handler;
import android.view.View;

import java.util.Random;


public class Fractals extends View {

    Handler handler;

    int width, height;
    Paint paint, bgPaint;

    public Fractals(Context context) {
        super(context);
        handler = new Handler();
    }

    int mainRadius = 500;

    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);
        width = w;
        height = h;
        paint = new Paint();
        bgPaint = new Paint();
        paint.setStyle(Paint.Style.FILL_AND_STROKE);
        paint.setColor(Color.MAGENTA);
        paint.setStrokeWidth(3);
        paint.setStyle(Paint.Style.STROKE);

    }

    private void drawCircles(Canvas canvas, int x, int y, int radius) {
        paint.setColor(getRandomColor());
        canvas.drawCircle(x, y, radius, paint);
        if (radius > 50) {
            drawCircles(canvas, x, y - radius, radius / 2);
            drawCircles(canvas, x, y + radius, radius / 2);
            drawCircles(canvas, x - radius, y, radius / 2);
            drawCircles(canvas, x + radius, y, radius / 2);
        }
    }

    int decrement = 30;

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        handler.postDelayed(() -> {
            bgPaint.setColor(getRandomColor());
        }, 3000);
        canvas.drawRect(0, 0, width, height, bgPaint);

        drawCircles(canvas, width / 2, height / 2, mainRadius);
        mainRadius -= decrement;
        if (mainRadius > 50) {
            if (mainRadius > 500) decrement = -decrement;
            handler.postDelayed(this::invalidate, 100);
        } else {
            decrement = -decrement;
            invalidate();
        }
    }

    int getRandomColor() {
        int[] colors = {Color.RED, Color.GREEN, Color.MAGENTA, Color.BLUE, Color.BLACK, Color.DKGRAY, Color.CYAN, Color.LTGRAY, Color.GRAY, Color.YELLOW};
        return colors[new Random().nextInt(colors.length)];
    }
}
