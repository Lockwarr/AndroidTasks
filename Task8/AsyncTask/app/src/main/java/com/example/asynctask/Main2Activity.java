package com.example.asynctask;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;

import java.util.Random;

public class Main2Activity extends AppCompatActivity {

    private ProgressBar progressBar, progressBar2, progressBar3;
    private Button button;
    private TextView textView1;

    private boolean function1;
    private boolean function2;

    final int min = 0;
    final int max = 100;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        progressBar = findViewById(R.id.progressBar);
        progressBar2 = findViewById(R.id.progressBar2);
        progressBar3 = findViewById(R.id.progressBar3);

        textView1 = findViewById(R.id.textView1);

        button = findViewById(R.id.button);

        textView1.setVisibility(View.INVISIBLE);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                textView1.setVisibility(View.INVISIBLE);
                DownloadImage taskOne = new DownloadImage();
                LoginProcess taskTwo = new LoginProcess();
                progressBar3.setVisibility(ProgressBar.VISIBLE);
                taskOne.execute();
                taskTwo.execute();
            }
        });
    }

    private boolean tasksOneDone() {
        return function1;
    }

    private boolean tasksTwoDone() {
        return function2;
    }

    private void onFinish() {
        textView1.setVisibility(View.VISIBLE);
        progressBar3.setVisibility(View.INVISIBLE);
        //Ако изписва постоянно "Не успешно", това не е защото нещо не работи, а заради random числото
        //в по-долните функции и вероятността в двете функции то е да е четно
        if (tasksOneDone() && tasksTwoDone()) {
            textView1.setText("Успешно");
            textView1.setTextColor(Color.GREEN);
        } else {
            textView1.setText("Не успешно");
            textView1.setTextColor(Color.RED);
        }
    }

    private class DownloadImage extends AsyncTask<Void, Integer, Boolean> {

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            progressBar.setVisibility(ProgressBar.VISIBLE);
        }

        @Override
        protected Boolean doInBackground(Void... voids) {
            Random random = new Random();
            int count = random.nextInt(2) + 3;
            for (int i = 0; i < count; i++) {
                publishProgress((i * 100) / count);
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            return true;
        }

        @Override
        protected void onProgressUpdate(Integer... values) {
            super.onProgressUpdate(values);
            progressBar.setProgress(values[0]);
        }

        @Override
        protected void onPostExecute(Boolean result) {
            super.onPostExecute(result);
            progressBar.setProgress(0);
            progressBar.setVisibility(ProgressBar.INVISIBLE);
            final int random = new Random().nextInt((max - min) + 1) + min;
            if(random%2==0) {
                function1 = result;
            } else {
                function1 = !result;
            }
            tasksOneDone();
        }
    }

    private class LoginProcess extends AsyncTask<Void, Integer, Boolean> {
        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            progressBar2.setVisibility(ProgressBar.VISIBLE);
        }

        @Override
        protected Boolean doInBackground(Void... voids) {
            Random random = new Random();

            int count = random.nextInt(3) + 2;
            for (int i = 0; i < count; i++) {
                publishProgress((i * 100) / count);
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            return true;
        }

        @Override
        protected void onProgressUpdate(Integer... values) {
            super.onProgressUpdate(values);
            progressBar2.setProgress(values[0]);
        }

        @Override
        protected void onPostExecute(Boolean result) {
            super.onPostExecute(result);
            progressBar2.setProgress(0);
            progressBar2.setVisibility(ProgressBar.INVISIBLE);
            final int random = new Random().nextInt((max - min) + 1) + min;
            if(random%2==0) {
                function2 = result;
            } else {
                function2 = !result;
            }
            tasksTwoDone();
            onFinish();
        }
    }
}
