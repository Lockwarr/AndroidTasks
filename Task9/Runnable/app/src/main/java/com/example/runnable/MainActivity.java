package com.example.runnable;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button button = findViewById(R.id.validateButton);
        EditText passwordField = (EditText)findViewById(R.id.passwordEditText);

        button.setOnClickListener(v -> {
            LoginTask loginTask = new LoginTask(this, passwordField.getText().toString());
            Thread thread = new Thread(loginTask);
            thread.start();
        });
    }
}
