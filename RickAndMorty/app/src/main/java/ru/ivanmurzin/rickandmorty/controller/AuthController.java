package ru.ivanmurzin.rickandmorty.controller;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class AuthController {
    private final FirebaseAuth auth;

    public AuthController() {
        auth = FirebaseAuth.getInstance();
    }

    public boolean isRegistered() {
        return auth.getCurrentUser() != null;
    }

    public FirebaseUser getUser() {
        return auth.getCurrentUser();
    }

    public void registerNewUser(String email, String password, OnCompleteListener<AuthResult> listener) {
        auth.createUserWithEmailAndPassword(email, password).addOnCompleteListener(listener);
    }

    public void signIn(String email, String password, OnCompleteListener<AuthResult> listener) {
        auth.signInWithEmailAndPassword(email, password).addOnCompleteListener(listener);
    }

    public void logout(){
        auth.signOut();
    }
}
