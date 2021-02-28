package com.example.runnable;

import android.app.Activity;
import android.widget.TextView;

public class LoginTask implements Runnable{

    private String password;
    private Activity activity;

    public LoginTask(Activity activity, String password) {
        this.activity = activity;
        this.password = password;
    }

    @Override
    public void run() {
        activity.runOnUiThread(new Runnable() {
            @Override public void run() {
                TextView resultField = (TextView)activity.findViewById(R.id.resultTextView);

                boolean flag = true;
                if(password.length() < 16)
                    flag = false;

                for(int i = 0; i < password.length(); i++) {

                    String charAt = password.substring(i, i + 1);

                    if ((i+1) % 7 == 0 && !charAt.matches("[A-Z]*"))
                        flag = false;

                    if ((i+1) % 3 == 0 && !charAt.matches("[0-9]*"))
                        flag = false;

                    if ((i+1) % 8 == 0 && !charAt.matches("[!@#$%&*]"))
                        flag = false;
                }

                if(flag)
                    resultField.setText("Correct password");
                else
                    resultField.setText("Incorrect password");

            }
        });
    }
}
