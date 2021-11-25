package ru.ivanmurzin.contextintent;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class NotMainActivity extends Activity implements View.OnClickListener {

    TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.not_main_activity);
        Button button = findViewById(R.id.button);
        Button result = findViewById(R.id.result);
        button.setOnClickListener(this);
        result.setOnClickListener(this);
        textView = findViewById(R.id.text);
        String myText = getIntent().getStringExtra("my text");
        if (myText != null) {
            textView.setText(myText);
        }
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.button:
                Intent intent = new Intent(this, MainActivity.class);
                startActivity(intent);
                break;
            case R.id.result:
                Intent intent1 = new Intent();
                intent1.putExtra("teeext", "what a terrible failure");
                setResult(RESULT_OK, intent1);
                finish();
        }
    }
}
