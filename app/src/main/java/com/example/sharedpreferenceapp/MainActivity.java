package com.example.sharedpreferenceapp;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends Activity {
    SharedPreferences sharedpreferences;
    TextView btn_name;
    TextView btn_email;

    public static final String mypreference = "mypref";
    public static final String Name = "nameKey";
    public static final String Email = "emailKey";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        btn_name = (TextView) findViewById(R.id.btn_name);
        btn_email = (TextView) findViewById(R.id.btn_email);
        sharedpreferences = getSharedPreferences(mypreference,Context.MODE_PRIVATE);

        if (sharedpreferences.contains(Name)) {
            btn_name.setText(sharedpreferences.getString(Name,""));
        }
        if (sharedpreferences.contains(Email)) {
            btn_email.setText(sharedpreferences.getString(Email, ""));
        }
    }

    public void Save(View view) {
        String name = btn_name.getText().toString();
        String email = btn_email.getText().toString();
        SharedPreferences.Editor editor = sharedpreferences.edit();
        editor.putString(Name, name);
        editor.putString(Email, email);
        editor.commit();
    }

    public void clear(View view) {
        btn_name = (TextView) findViewById(R.id.btn_name);
        btn_email = (TextView) findViewById(R.id.btn_email);
        btn_name.setText("");
        btn_email.setText("");

    }

    public void Get(View view) {
        btn_name = (TextView) findViewById(R.id.btn_name);
        btn_email = (TextView) findViewById(R.id.btn_email);
        sharedpreferences = getSharedPreferences(mypreference, Context.MODE_PRIVATE);

        if (sharedpreferences.contains(Name)) {
            btn_name.setText(sharedpreferences.getString(Name, ""));
        }
        if (sharedpreferences.contains(Email)) {
            btn_email.setText(sharedpreferences.getString(Email, ""));

        }
    }
}

