package ru.ivanmurzin.classesandwheretheylive;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button button1 = findViewById(R.id.button1);
        Button button2 = findViewById(R.id.button2);
        Button button3 = findViewById(R.id.button3);

        button1.setOnClickListener(v -> Log.d("RRR", "Я кнопка 1"));
        button2.setOnClickListener(v -> Log.d("RRR", "Я кнопка 2"));
        button3.setOnClickListener(v -> Log.d("RRR", "Я кнопка 3"));
    }
}