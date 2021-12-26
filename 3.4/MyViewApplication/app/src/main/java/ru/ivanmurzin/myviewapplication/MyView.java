package ru.ivanmurzin.myviewapplication;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.view.MotionEvent;
import android.view.View;

import java.util.ArrayList;
import java.util.List;

public class MyView extends View {
    public MyView(Context context) {
        super(context);
    }

    int a = 0;

    @Override
    protected void onDraw(Canvas canvas) {
        Paint paint = new Paint();
        switch (a) {
            case 0:
                canvas.drawRGB(255, 0, 0);
                break;
            case 1:
                canvas.drawRGB(0, 255, 0);
                break;
            default:
                canvas.drawRGB(0, 0, 255);
        }
        paint.setColor(Color.CYAN);
//        paint.setColor(Color.rgb(213, 123, 12));
//        paint.setColor(Color.parseColor("#00FAAA"));
        canvas.drawCircle(getWidth() / 2, getWidth() / 2, 100, paint);
        paint.setStyle(Paint.Style.STROKE);
        canvas.drawRect(50, 100, 200, 300, paint);
        paint.setColor(Color.MAGENTA);
        paint.setTextSize(80);
        canvas.drawText("Хвала булочке!", 233, 123, paint);
        float rotateCenterX = 200;
        float rotateCenterY = 200;
        float rotateAngle = 45;
        canvas.rotate(-rotateAngle, rotateCenterX, rotateCenterY);
        paint.setStyle(Paint.Style.FILL_AND_STROKE);
        paint.setColor(Color.LTGRAY);
        canvas.drawText("YOY", 0, 450, paint);
        canvas.rotate(rotateAngle, rotateCenterX, rotateCenterY);
        for (int i = 0; i < X.size(); i++) {
            canvas.drawCircle(X.get(i), Y.get(i), 50, paint);
        }
        super.onDraw(canvas);
    }

    List<Float> X = new ArrayList<Float>();
    List<Float> Y = new ArrayList<Float>();

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        a = (a + 1) % 3;
        float x = event.getX();
        float y = event.getY();
        X.add(x);
        Y.add(y);
        invalidate();
        return super.onTouchEvent(event);
    }
}
