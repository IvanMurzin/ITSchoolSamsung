package ru.ivanmurzin.rickandmorty.view;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import ru.ivanmurzin.rickandmorty.MainActivity;
import ru.ivanmurzin.rickandmorty.controller.AuthController;
import ru.ivanmurzin.rickandmorty.databinding.ActivitySignUpBinding;

public class SignUpActivity extends AppCompatActivity {

    ActivitySignUpBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivitySignUpBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        binding.alreadySignedUp.setOnClickListener(view -> {
            startActivity(new Intent(SignUpActivity.this, SignInActivity.class));
            finish();
        });

        AuthController authController = new AuthController();
        binding.register.setOnClickListener(view -> {
            String email = binding.email.getText().toString();
            String password = binding.password.getText().toString();
            String confirmPassword = binding.confirmPassword.getText().toString();
            if (email.isEmpty() || password.isEmpty() || confirmPassword.isEmpty()) {
                Toast.makeText(this, "Поля должны быть заполнены!", Toast.LENGTH_SHORT).show();
                return;
            }
            if (!password.equals(confirmPassword)) {
                Toast.makeText(this, "Пароли должны совпадать!", Toast.LENGTH_SHORT).show();
                return;
            }
            authController.registerNewUser(email, password, task -> {
                if (task.isSuccessful()) {// start main activity
                    Toast.makeText(this, task.getResult().getUser().getEmail(), Toast.LENGTH_SHORT).show();
                    startActivity(new Intent(SignUpActivity.this, MainActivity.class));
                    finish();
                } else
                    Toast.makeText(this, task.getException().getMessage(), Toast.LENGTH_SHORT).show();
            });
        });
    }
}