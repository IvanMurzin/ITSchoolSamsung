package ru.ivanmurzin.animations;

import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.annotation.SuppressLint;
import android.graphics.Rect;
import android.graphics.drawable.AnimationDrawable;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.util.DisplayMetrics;
import android.view.ContextMenu;
import android.view.Display;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.RelativeLayout;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.res.ResourcesCompat;

import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;

import ru.ivanmurzin.animations.databinding.ActivityMainBinding;


public class MainActivity extends AppCompatActivity {
    private ActivityMainBinding binding;
    private static final int[] LEAVES = {
            R.drawable.one,
            R.drawable.two,
            R.drawable.three,
            R.drawable.four,
            R.drawable.five,
            R.drawable.six,
    };
    private final Rect displaySize = new Rect();
    private float scale;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        registerForContextMenu(binding.button);
        animateCatWithJava();


        Display display = getWindowManager().getDefaultDisplay();
        display.getRectSize(displaySize);

        DisplayMetrics metrics = new DisplayMetrics();
        display.getMetrics(metrics);
        scale = metrics.density;

        new Timer().schedule(new TimerTask() {
            @Override
            public void run() {
                handler.sendEmptyMessage(0);
            }
        }, 0, 100);
    }

    @SuppressLint("HandlerLeak")
    private final Handler handler = new Handler() {
        @Override
        public void handleMessage(@NonNull Message msg) {
            super.handleMessage(msg);
            int leaveIndex = new Random().nextInt(LEAVES.length);
            Drawable leave = ResourcesCompat.getDrawable(getResources(), LEAVES[leaveIndex], null);
            LayoutInflater inflater = LayoutInflater.from(MainActivity.this);
            ImageView imageView = (ImageView) inflater.inflate(R.layout.some_image_view, null);
            imageView.setImageDrawable(leave);
            binding.mainLayout.addView(imageView);

            RelativeLayout.LayoutParams animationLayout = (RelativeLayout.LayoutParams) imageView.getLayoutParams();
            animationLayout.setMargins(0, (int) (-150 * scale), 0, 0);
            animationLayout.width = (int) (60 * scale);
            animationLayout.height = (int) (60 * scale);

            startAnimation(imageView);
        }
    };

    public void startAnimation(ImageView aniView) {
        aniView.setPivotX(aniView.getWidth() / 2f);
        aniView.setPivotY(aniView.getHeight() / 2f);
        final ValueAnimator animator = ValueAnimator.ofFloat(0, 1);
        animator.setInterpolator(new AccelerateInterpolator());
        animator.setDuration(2000);
        animator.addUpdateListener(
                new ValueAnimator.AnimatorUpdateListener() {
                    final int angle = 50 + (int) (Math.random() * 1010);
                    final int moveLength = new Random().nextInt(displaySize.right);

                    @Override
                    public void onAnimationUpdate(ValueAnimator valueAnimator) {
                        float value = (Float) valueAnimator.getAnimatedValue();
                        aniView.setRotation(angle * value);
                        aniView.setTranslationX(moveLength * value);
                        aniView.setTranslationY((displaySize.bottom + (150 * scale)) * value);
                    }
                }
        );
        animator.start();
    }

    public void animateCatWithJava() {
        BitmapDrawable frame1 = (BitmapDrawable) ResourcesCompat.getDrawable(getResources(), R.drawable.one, null);
        BitmapDrawable frame2 = (BitmapDrawable) ResourcesCompat.getDrawable(getResources(), R.drawable.two, null);
        BitmapDrawable frame3 = (BitmapDrawable) ResourcesCompat.getDrawable(getResources(), R.drawable.three, null);
        BitmapDrawable frame4 = (BitmapDrawable) ResourcesCompat.getDrawable(getResources(), R.drawable.four, null);
        BitmapDrawable frame5 = (BitmapDrawable) ResourcesCompat.getDrawable(getResources(), R.drawable.five, null);
        BitmapDrawable frame6 = (BitmapDrawable) ResourcesCompat.getDrawable(getResources(), R.drawable.six, null);
        AnimationDrawable animationDrawable = new AnimationDrawable();
        animationDrawable.addFrame(frame1, 200);
        animationDrawable.addFrame(frame2, 200);
        animationDrawable.addFrame(frame3, 200);
        animationDrawable.addFrame(frame4, 200);
        animationDrawable.addFrame(frame5, 200);
        animationDrawable.addFrame(frame6, 200);
        binding.imageView.setBackground(animationDrawable);
        binding.start.setOnClickListener(view -> animationDrawable.start());
    }


    public void animateCat() {
        binding.imageView.setBackgroundResource(R.drawable.animation);
        AnimationDrawable animationDrawable = (AnimationDrawable) binding.imageView.getBackground();
        binding.start.setOnClickListener(view -> animationDrawable.start());
    }

    public void animateImageWithObjectAnimator() {
        ObjectAnimator objectAnimator = ObjectAnimator.ofFloat(binding.imageView, "rotation", 360, 0).setDuration(3000);
        binding.start.setOnClickListener(view -> objectAnimator.start());
    }

    public void animateImageWithValueAnimator() {
        ValueAnimator valueAnimator = ValueAnimator.ofInt(5 * 360, 0);
        valueAnimator.setInterpolator(new AccelerateInterpolator());
        valueAnimator.setDuration(3000);
        binding.start.setOnClickListener(view -> valueAnimator.start());
        valueAnimator.addUpdateListener(valueAnimator1 -> {
            int updateValue = (int) valueAnimator1.getAnimatedValue();
            binding.imageView.setRotation(updateValue);
        });
    }


    final int ALPHA_ID = 1;
    final int SCALE_ID = 2;
    final int TRANSLATE_ID = 3;
    final int ROTATE_ID = 4;
    final int COMBO_ID = 5;

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        menu.add(0, ALPHA_ID, 0, "alpha");
        menu.add(0, SCALE_ID, 0, "scale");
        menu.add(0, TRANSLATE_ID, 0, "translate");
        menu.add(0, ROTATE_ID, 0, "rotate");
        menu.add(0, COMBO_ID, 0, "combo");
        super.onCreateContextMenu(menu, v, menuInfo);
    }

    @Override
    public boolean onContextItemSelected(@NonNull MenuItem item) {
        Animation animation = null;
        switch (item.getItemId()) {
            case ALPHA_ID:
                animation = AnimationUtils.loadAnimation(this, R.anim.myalpha);
                break;
            case SCALE_ID:
                animation = AnimationUtils.loadAnimation(this, R.anim.myscale);
                break;
            case TRANSLATE_ID:
                animation = AnimationUtils.loadAnimation(this, R.anim.mytranslate);
                break;
            case ROTATE_ID:
                animation = AnimationUtils.loadAnimation(this, R.anim.myrotate);
                break;
            case COMBO_ID:
                animation = AnimationUtils.loadAnimation(this, R.anim.mycombo);
                break;
        }
        binding.button.startAnimation(animation);
        return super.onContextItemSelected(item);
    }
}