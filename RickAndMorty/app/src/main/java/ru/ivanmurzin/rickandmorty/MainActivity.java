package ru.ivanmurzin.rickandmorty;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;

import java.util.ArrayList;

import ru.ivanmurzin.rickandmorty.controller.APIController;
import ru.ivanmurzin.rickandmorty.controller.AuthController;
import ru.ivanmurzin.rickandmorty.databinding.ActivityMainBinding;
import ru.ivanmurzin.rickandmorty.model.CharacterData;
import ru.ivanmurzin.rickandmorty.view.MyAdapter;
import ru.ivanmurzin.rickandmorty.view.SignInActivity;

public class MainActivity extends AppCompatActivity {
    ActivityMainBinding binding;
    Handler handler;
    ArrayList<CharacterData> data;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        binding.recycler.setLayoutManager(new LinearLayoutManager(this));
        Thread thread = new Thread(() -> {
            APIController controller = new APIController();
            data = controller.getAllCharacters();
            handler.sendEmptyMessage(0);
        });
        handler = new Handler(message -> {
            binding.recycler.setAdapter(new MyAdapter(data));
            return false;
        });
        thread.start();

        AuthController authController = new AuthController();
        binding.logout.setOnClickListener(view -> {
            authController.logout();
            startActivity(new Intent(MainActivity.this, SignInActivity.class));
            finish();
        });

        binding.userEmail.setText(authController.getUser().getEmail());
    }
}