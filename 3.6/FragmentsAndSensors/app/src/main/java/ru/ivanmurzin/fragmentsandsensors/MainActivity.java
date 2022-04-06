package ru.ivanmurzin.fragmentsandsensors;

import android.hardware.SensorManager;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import ru.ivanmurzin.fragmentsandsensors.fragments.MyFragment1;
import ru.ivanmurzin.fragmentsandsensors.fragments.MyFragment2;
import ru.ivanmurzin.fragmentsandsensors.fragments.MyFragment3;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    Button b1;
    Button b2;
    Button b3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setupUI();

    }

    void setupUI() {
        b1 = findViewById(R.id.b1);
        b1.setOnClickListener(this);
        b2 = findViewById(R.id.b2);
        b2.setOnClickListener(this);
        b3 = findViewById(R.id.b3);
        b3.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();

        switch (view.getId()) {
            case R.id.b1:
                fragmentTransaction.replace(R.id.placeholder, new MyFragment1());
                break;
            case R.id.b2:
                fragmentTransaction.replace(R.id.placeholder, new MyFragment2());
                break;
            case R.id.b3:
                fragmentTransaction.replace(R.id.placeholder, new MyFragment3());
                break;
        }

        fragmentTransaction.commit();
    }
}