package ru.ivanmurzin.rickandmorty.view;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import ru.ivanmurzin.rickandmorty.MainActivity;
import ru.ivanmurzin.rickandmorty.R;
import ru.ivanmurzin.rickandmorty.controller.AuthController;
import ru.ivanmurzin.rickandmorty.databinding.ActivitySignInBinding;

public class SignInActivity extends AppCompatActivity {

    ActivitySignInBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivitySignInBinding.inflate(getLayoutInflater());
        try {
            Thread.sleep(500);
        } catch (InterruptedException ignored) {
        }
        setTheme(R.style.Theme_RickAndMorty);

        AuthController authController = new AuthController();
        if (authController.isRegistered()) {
            startActivity(new Intent(SignInActivity.this, MainActivity.class));
            finish();
        }

        setContentView(binding.getRoot());
        binding.enter.setOnClickListener(view -> {
            String email = binding.email.getText().toString();
            String password = binding.password.getText().toString();
            if (email.isEmpty() || password.isEmpty()) {
                Toast.makeText(this, "Поля должны быть заполнены!", Toast.LENGTH_SHORT).show();
                return;
            }
            authController.signIn(email, password, task -> {
                if (task.isSuccessful()) {// start main activity
                    Toast.makeText(this, task.getResult().getUser().getEmail(), Toast.LENGTH_SHORT).show();
                    startActivity(new Intent(SignInActivity.this, MainActivity.class));
                    finish();
                } else
                    Toast.makeText(this, task.getException().getMessage(), Toast.LENGTH_SHORT).show();
            });
        });

        binding.notSignedUp.setOnClickListener(view -> {
            startActivity(new Intent(SignInActivity.this, SignUpActivity.class));
            finish();
        });
    }
}