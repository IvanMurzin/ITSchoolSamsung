package ru.ivanmurzin.awesomebird;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.view.MotionEvent;
import android.view.SurfaceHolder;
import android.view.SurfaceView;

import androidx.annotation.NonNull;

public class GameView extends SurfaceView implements SurfaceHolder.Callback {
    private BirdModel bird;
    private PipesModel pipes;
    final private Bitmap background;
    final static private int fps = 60;

    private SurfaceHolder surfaceHolder;
    private DrawThread drawThread;


    public GameView(Context context) {
        super(context);
        background = BitmapFactory.decodeResource(context.getResources(), R.drawable.back);
        getHolder().addCallback(this);
    }

    @Override
    public void surfaceCreated(@NonNull SurfaceHolder surfaceHolder) {
        // при создании
        bird = new BirdModel(getContext(), 200);
        pipes = new PipesModel(getContext(), getWidth(), getHeight());
        this.surfaceHolder = surfaceHolder;

        // запустить игровой поток
        drawThread = new DrawThread();
        drawThread.start();
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        bird.fly();
        return super.onTouchEvent(event);
    }

    private void drawFrames(Canvas canvas) {
        canvas.drawBitmap(background, null, new Rect(0, 0, getWidth(), getHeight()), null);
        canvas.drawBitmap(bird.bird, bird.x, bird.y, null);
        canvas.drawBitmap(pipes.topPipe, pipes.x, 0, null);
        canvas.drawBitmap(pipes.bottomPipe, pipes.x, getHeight() - pipes.bottomPipe.getWidth(), null);
    }

    private void update() {
        bird.updatePosition();
        pipes.updatePosition();
    }


    private class DrawThread extends Thread {
        private volatile boolean running = true;

        @Override
        public void run() {
            while (running) {
                Canvas canvas = surfaceHolder.lockCanvas();
                try {
                    Thread.sleep(1000 / fps);
                    // что-нить рисовать
                    drawFrames(canvas);
                    // что-нить обновить
                    update();

                    if (pipes.isCollision(bird)) running = false;

                } catch (Exception e) {
                } finally {
                    surfaceHolder.unlockCanvasAndPost(canvas);
                }
            }
        }
    }

    @Override
    public void surfaceChanged(@NonNull SurfaceHolder surfaceHolder, int i, int i1, int i2) {
        // при изменении ориентации
    }

    @Override
    public void surfaceDestroyed(@NonNull SurfaceHolder surfaceHolder) {
        // при уничтожении
        drawThread.running = false;
        boolean retry = true;
        while (retry) {
            try {
                drawThread.join();
                retry = false;
            } catch (Exception e) {
            }
        }
    }
}
