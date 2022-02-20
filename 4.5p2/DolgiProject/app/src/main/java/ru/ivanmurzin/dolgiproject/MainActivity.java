package ru.ivanmurzin.dolgiproject;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;

import java.util.List;
import java.util.Random;

import ru.ivanmurzin.dolgiproject.data.Debt;
import ru.ivanmurzin.dolgiproject.data.DebtsDataStorage;
import ru.ivanmurzin.dolgiproject.data.DebtsDataStorageSP;
import ru.ivanmurzin.dolgiproject.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    ActivityMainBinding binding;
    DebtsDataStorage dataStorage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        dataStorage = new DebtsDataStorageSP(this);
        resetAdapter();
        binding.floatingButton.setOnClickListener(view -> {
            dataStorage.saveData(new Debt("Random guy", new Random().nextFloat()));
            resetAdapter();
        });
    }

    private void resetAdapter() {
        List<Debt> debts = dataStorage.getAllData();
        binding.recyclerView.setLayoutManager(new LinearLayoutManager(this));
        binding.recyclerView.setAdapter(new MyAdapter(debts));
    }
}