package ru.ivanmurzin.awesomebird;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Rect;

public class PipesModel {
    public Bitmap topPipe;
    public Bitmap bottomPipe;
    public float x;
    private final float xSpeed = 10;
    private int xMax;
    private int yMax;
    private final int spacerSize = 300;
    private int ySpacer;

    public PipesModel(Context context, int xMax, int yMax) {
        this.xMax = xMax;
        this.yMax = yMax;
        topPipe = BitmapFactory.decodeResource(context.getResources(), R.drawable.pipe_rotated);
        bottomPipe = BitmapFactory.decodeResource(context.getResources(), R.drawable.pipe);
        x = xMax;
        generatePipes();
    }

    private void generatePipes() {
        ySpacer = random(yMax / 4, yMax * 3 / 4); // рандомный сдвиг по у
        Rect topRect = new Rect(0, 0, topPipe.getWidth(), ySpacer - spacerSize);
        Rect bottomRect = new Rect(0, 0, bottomPipe.getWidth(), yMax - ySpacer - spacerSize);

        Bitmap topPlaceholder = Bitmap.createBitmap(
                topPipe.getWidth(),
                ySpacer - spacerSize,
                Bitmap.Config.ARGB_8888);
        Bitmap bottomPlaceholder = Bitmap.createBitmap(
                bottomPipe.getWidth(),
                yMax - ySpacer - spacerSize,
                Bitmap.Config.ARGB_8888);


        Canvas canvas = new Canvas(topPlaceholder);
        canvas.drawBitmap(topPipe, null, topRect, null);

        canvas = new Canvas(bottomPlaceholder);
        canvas.drawBitmap(bottomPipe, null, bottomRect, null);

        topPipe = topPlaceholder;
        bottomPipe = bottomPlaceholder;

    }

    public void updatePosition() {
        x -= xSpeed;
        if (x < -bottomPipe.getWidth()) {
            x = xMax;
            generatePipes();
        }
    }

    public boolean isCollision(BirdModel bird) {
        if (x - 10 < bird.x && x + bottomPipe.getWidth() > bird.x) {
            if (bird.y - topPipe.getHeight() < 0) return true;
            if (bird.y > yMax - bottomPipe.getWidth()) return true;
        }
        return false;
    }

    private int random(int min, int max) {
        return min + (int) (Math.random() * (max - min));
    }
}
