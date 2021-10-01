package com.example.registration;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;

import com.google.android.material.textfield.TextInputEditText;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void Greeting(View view){



        Bundle arguments = getIntent().getExtras();

        String firstNameText = arguments.get("first name").toString();
        String lastNameText = arguments.get("last name").toString();

        GreetingDialogFragment dialog = new GreetingDialogFragment();

        Bundle name = new Bundle();
        name.putString("name", firstNameText + " " + lastNameText);
        dialog.setArguments(name);

        dialog.show(getSupportFragmentManager(), "tag1");

    }
}