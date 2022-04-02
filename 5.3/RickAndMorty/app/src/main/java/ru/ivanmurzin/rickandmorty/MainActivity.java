package ru.ivanmurzin.rickandmorty;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;

import java.util.ArrayList;

import ru.ivanmurzin.rickandmorty.controller.APIController;
import ru.ivanmurzin.rickandmorty.databinding.ActivityMainBinding;
import ru.ivanmurzin.rickandmorty.model.CharacterData;
import ru.ivanmurzin.rickandmorty.view.MyAdapter;

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
    }
}