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
        Toast.makeText(this, message,Toast.LENGTH_SHORT).show();
        Log.d("MyLoggerTag", message);

    }
    Button button;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
//        setupUI();
        log("created");
        button = findViewById(R.id.button);

    }

    public void click(View view) {
        button.setVisibility(View.INVISIBLE);
    }


//    private void setupUI(){
//        aField = findViewById(R.id.a_field);
//        bField = findViewById(R.id.b_field);
//        cField = findViewById(R.id.c_field);
//        button = findViewById(R.id.button);
//    }


}