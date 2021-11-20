package ru.ivanmurzin.mathtrainer;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends Activity {

    TextView problem;
    TextView text1;
    TextView text2;
    TextView text3;
    MathGenerator mathGenerator = new MathGenerator();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setupUI();
        reset(problem);
    }

    private void setupUI() {
        MyClicker myClicker = new MyClicker();
        problem = findViewById(R.id.problem);
        text1 = findViewById(R.id.text1);
        text1.setOnClickListener(myClicker);
        text2 = findViewById(R.id.text2);
        text2.setOnClickListener(myClicker);
        text3 = findViewById(R.id.text3);
        text3.setOnClickListener(myClicker);
    }

    private void generateAnswers() {
        int position = mathGenerator.getRandom(4, 1);
        text1.setBackgroundColor(getColor(R.color.still));
        text2.setBackgroundColor(getColor(R.color.still));
        text3.setBackgroundColor(getColor(R.color.still));
        if (position == 1) {
            text1.setText(mathGenerator.getResult());
            text2.setText(mathGenerator.getNoiseResult());
            text3.setText(mathGenerator.getNoiseResult());
        } else if (position == 2) {
            text1.setText(mathGenerator.getNoiseResult());
            text2.setText(mathGenerator.getResult());
            text3.setText(mathGenerator.getNoiseResult());
        } else {
            text1.setText(mathGenerator.getNoiseResult());
            text2.setText(mathGenerator.getNoiseResult());
            text3.setText(mathGenerator.getResult());
        }
    }

    public void reset(View view) {
        problem.setText(mathGenerator.getProblem());
        generateAnswers();
    }

    class MyClicker implements View.OnClickListener {

        @Override
        public void onClick(View v) {
            TextView textView = (TextView) v;
            String text = textView.getText().toString();
            if (text.equals(mathGenerator.getResult())) {
                v.setBackgroundColor(getColor(R.color.green));
                Toast.makeText(v.getContext(), "Правильно!", Toast.LENGTH_SHORT).show();
                reset(problem);
            } else
                v.setBackgroundColor(getColor(R.color.red));
        }
    }
}