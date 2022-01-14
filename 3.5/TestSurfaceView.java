package ru.kirillisachenko.awesomebird;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.view.MotionEvent;
import android.view.SurfaceHolder;
import android.view.SurfaceView;

import java.util.ArrayList;

class TestSurfaceView extends SurfaceView implements SurfaceHolder.Callback {
    private SurfaceHolder surfaceHolder;
    private Thread myThread;

    public TestSurfaceView(Context context) {
        super(context);
        getHolder().addCallback(this);
    }

    @Override
    public void surfaceChanged(SurfaceHolder holder, int format, int width, int height) {
    }

    @Override
    public void surfaceCreated(SurfaceHolder holder) {
        surfaceHolder = holder;
        myThread = new MyThread();
        myThread.start();
    }

    @Override
    public void surfaceDestroyed(SurfaceHolder holder) {
    }

    class MyCircle {
        float x, y, radius;
        Paint paint;

        MyCircle(float x, float y, float radius, Paint paint) {
            this.x = x;
            this.y = y;
            this.radius = radius;
            this.paint = paint;
        }

        void draw(Canvas canvas) {
            canvas.drawCircle(x, y, radius, paint);
        }

        void update(float dx) {
            radius += dx;
        }
    }

    MyCircle circle;

    class MyThread extends Thread {
        boolean running = true;

        @Override
        public void run() {
            while (running) {
                try {
                    Canvas canvas = surfaceHolder.lockCanvas();
                    canvas.drawColor(Color.BLUE);
                    if (circle != null) {
                        circle.draw(canvas);
                        circle.update(5);
                    }
                    Thread.sleep(1000);
                    surfaceHolder.unlockCanvasAndPost(canvas);
                } catch (Exception e) {
                }
            }
        }
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        float x = event.getX();
        float y = event.getY();
        Paint paint = new Paint();
        paint.setColor(Color.YELLOW);
        circle = new MyCircle(x, y, 0, paint);
        return super.onTouchEvent(event);
    }
}