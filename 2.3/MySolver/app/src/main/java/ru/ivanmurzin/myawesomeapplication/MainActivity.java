package ru.ivanmurzin.myawesomeapplication;


import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends Activity {

    private void log(String message){
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
        Log.d("MyLoggerTag", message);
    }

    EditText aField;
    EditText bField;
    EditText cField;
    Button button;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setupUI();
        log("created");
    }


    public void click(View view) {
        double a = Double.parseDouble(aField.getText().toString());
        double b = Double.parseDouble(bField.getText().toString());
        double c = Double.parseDouble(cField.getText().toString());
        double result = (c-b)/a;
        Toast.makeText(this, result+"", Toast.LENGTH_SHORT).show();

    }

    private void setupUI(){
        aField = findViewById(R.id.a_field);
        bField = findViewById(R.id.b_field);
        cField = findViewById(R.id.c_field);
        button = findViewById(R.id.button);
    }











    @Override
    protected void onStart() {
        super.onStart();
        log("started");

    }

    @Override
    protected void onResume() {
        super.onResume();
        log("resumed");
    }

    @Override
    protected void onPause() {
        super.onPause();
        log("paused");
    }

    @Override
    protected void onStop() {
        super.onStop();
        log("stopped");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        log("destroyed");
    }
}