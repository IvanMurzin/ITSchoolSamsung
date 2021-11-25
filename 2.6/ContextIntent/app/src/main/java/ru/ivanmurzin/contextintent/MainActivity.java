package ru.ivanmurzin.contextintent;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends Activity implements View.OnClickListener {

    EditText editText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button button = findViewById(R.id.button);
        button.setOnClickListener(this);
        Button buttonOpenFile = findViewById(R.id.open_file);
        buttonOpenFile.setOnClickListener(this);
        Button buttonGimmeResult = findViewById(R.id.gimme_result);
        buttonGimmeResult.setOnClickListener(this);
        Button sendInfo = findViewById(R.id.send_info);
        sendInfo.setOnClickListener(this);
        editText = findViewById(R.id.edit_text);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.button:
                Intent intent = new Intent(this, NotMainActivity.class);
                startActivity(intent);
                finish();
                break;
            case R.id.open_file:
                Intent intentOpenFile = new Intent(Intent.ACTION_OPEN_DOCUMENT);
                intentOpenFile.setType("*/*");
                startActivityForResult(intentOpenFile, 123);
                break;
            case R.id.send_info:
                String text = editText.getText().toString();
                Intent intentWithInfo = new Intent(this, NotMainActivity.class);
                intentWithInfo.putExtra("my text", text);
                startActivity(intentWithInfo);
                break;
            case R.id.gimme_result:
                Intent intentGimmeResult =new Intent(this, NotMainActivity.class);
                startActivityForResult(intentGimmeResult, 321);
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode == RESULT_OK) {
            if (requestCode == 123) {
                Log.d("RRR", data.getData().toString());
            }
            if (requestCode == 321) {
                Toast.makeText(this, data.getStringExtra("teeext"), Toast.LENGTH_SHORT).show();
            }
        }
    }
}