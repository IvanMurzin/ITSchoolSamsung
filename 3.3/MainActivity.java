package ru.ivanmurzin.threadsandasyncs;

import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    Button startInMainThread, startInAnotherThread;
    ProgressBar progressBar;
    TextView text;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        startInMainThread = findViewById(R.id.start1);
        startInAnotherThread = findViewById(R.id.start2);
        progressBar = findViewById(R.id.progress_bar);
        text = findViewById(R.id.text_main);

        startInMainThread.setOnClickListener(v -> {
            // запустим функцию в главном потоке
            try {
                Toast.makeText(MainActivity.this, "Я начал в главном потоке", Toast.LENGTH_SHORT).show();
                Thread.sleep(10 * 1000); // имитация загрузки
                Toast.makeText(MainActivity.this, "Я загрузился", Toast.LENGTH_SHORT).show();
            } catch (Exception e) {
            }
        });

        startInAnotherThread.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // запустим функцию в другом потоке
                LoadImage loadImage = new LoadImage();
                loadImage.execute();
            }
        });
    }


    private class LoadImage extends AsyncTask<Void, Integer, Void> {
        @Override
        protected void onPreExecute() {
            Toast.makeText(MainActivity.this, "Я начал выполняться", Toast.LENGTH_SHORT).show();
            super.onPreExecute();
        }

        @Override
        protected Void doInBackground(Void... voids) {
            try {
                for (int i = 0; i < 10; i++) {
                    Thread.sleep(1000);
                    publishProgress(i * 10);
                }
            } catch (Exception e) {
            }
            publishProgress(100);
            return null;
        }

        @Override
        protected void onPostExecute(Void unused) {
            Toast.makeText(MainActivity.this, "Я закончил выполняться", Toast.LENGTH_SHORT).show();
            super.onPostExecute(unused);
        }

        @Override
        protected void onProgressUpdate(Integer... values) {
            super.onProgressUpdate(values);
            progressBar.setProgress(values[0]);
            text.setText("Выполнено " + values[0] + "% из 100");
        }
    }
}