package com.example.asynctask;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.graphics.Color;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private Button button1;
    private EditText editText;
    private TextView textView;
    private Button button2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        button1 = findViewById(R.id.button1);
        button2 = findViewById(R.id.button2);
        editText = findViewById(R.id.editText);
        textView = findViewById(R.id.textView);


        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AsyncTask2 AsT = new AsyncTask2();
                String number = editText.getText().toString();
                int counter = Integer.parseInt(number);
                AsT.execute(counter);
                textView.setText("");

            }
        });

        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this, Main2Activity.class));
            }
        });


    }


    private class AsyncTask2 extends AsyncTask<Integer, Integer, String> {

        ProgressDialog progressDialog;

        protected void onPreExecute() {
            super.onPreExecute();
            progressDialog = ProgressDialog.show(MainActivity.this,
                    "", "");
        }

        protected String doInBackground(Integer... integers) {
            for (int i = integers[0]; i > 0; i--) {
                try {
                    Thread.sleep(1000);
                    publishProgress(i);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            return "Done";
        }

        protected void onProgressUpdate(Integer... values) {
            textView.setText("" + values[0]);
            progressDialog.setMessage(String.valueOf(values[0]));

        }

        protected void onPostExecute(String result) {
            super.onPostExecute(result);
            textView.setText(result);
            textView.setText("Завършено");
            textView.setTextColor(Color.GREEN);
            progressDialog.dismiss();
        }
    }
}
