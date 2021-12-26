package ru.ivanmurzin.awesomebird;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;

public class BirdModel {
    public Bitmap bird;
    public float x, y;
    private float speed = 0;
    private final float acceleration = 3;

    public BirdModel(Context context, int x) {
        this.x = x;
        bird = BitmapFactory.decodeResource(context.getResources(), R.drawable.bluebird_1);
    }

    public void fly() {
        speed = -40;
    }

    public void updatePosition() {
        y += speed;
        speed += acceleration;
    }
}
