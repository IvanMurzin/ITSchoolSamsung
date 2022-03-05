package ru.ivanmurzin.sharedpreferences;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.Random;

import ru.ivanmurzin.sharedpreferences.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {
    ActivityMainBinding binding;
    SharedPreferences storage;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        storage = getApplicationContext().getSharedPreferences("storage", Context.MODE_PRIVATE);
        updateCat();
        setContentView(binding.getRoot());
        binding.saveButton.setOnClickListener(view -> {
            Random r = new Random();
            Cat cat = new Cat(r.nextLong() % 10 + 15, r.nextInt() % 10 + 10, r.nextBoolean() + "", r.nextBoolean());
            SharedPreferences.Editor editor = storage.edit();
            editor.putString("cat", cat.toString());
            editor.apply();
            updateCat();
        });
    }

    private void updateCat() {
        String stringCat = storage.getString("cat", "Кошек больше нет...");
        binding.greetings.setText(stringCat);
        Cat cat = Cat.getFromString(stringCat);
        Toast.makeText(this, "Cat " + cat.name + " with tail " + cat.tail + " is dead? " + cat.dead, Toast.LENGTH_LONG).show();
    }
}