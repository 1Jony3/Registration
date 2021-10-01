package com.example.registration;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.DatePicker;

import com.google.android.material.textfield.TextInputEditText;

public class RegistrationActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration);

        DatePicker datePicker = (DatePicker)this.findViewById(R.id.datePicker);
        // Месяц начиная с нуля
        datePicker.init(2000, 0, 1, new DatePicker.OnDateChangedListener() {
            @Override
            public void onDateChanged(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
                String date = "Дата: " + view.getDayOfMonth() + "/" + (view.getMonth() + 1) + "/" + view.getYear();
            }
        });
    }

    private boolean noEmty() {
        TextInputEditText firstText = findViewById(R.id.textFirstName);
        String firstNameText = firstText.getText().toString();

        TextInputEditText lastText = findViewById(R.id.lastName);
        String lastNameText = lastText.getText().toString();

        TextInputEditText passText = findViewById(R.id.pass);
        String pass = passText.getText().toString();

        TextInputEditText doublePassText = findViewById(R.id.doublePass);
        String doublePass = doublePassText.getText().toString();

        return (!firstNameText.equals("")) && (!lastNameText.equals("")) && (!pass.equals("")) && (!doublePass.equals(""));
    }

    private void WriteError(){

    }

    private boolean EqualsPasswords() {
        TextInputEditText passText = findViewById(R.id.pass);
        String pass = passText.getText().toString();

        TextInputEditText doublePassText = findViewById(R.id.doublePass);
        String doublePass = doublePassText.getText().toString();

        if (pass.equals(doublePass)) return true;
        else { WriteError();return false;}

    }


    public void Registration(View view) {

        if (noEmty() && EqualsPasswords()) {

            TextInputEditText firstText = findViewById(R.id.textFirstName);
            String firstNameText = firstText.getText().toString();

            TextInputEditText lastText = findViewById(R.id.lastName);
            String lastNameText = lastText.getText().toString();

            Intent intent = new Intent(this, MainActivity.class);

            intent.putExtra("first name", firstNameText);
            intent.putExtra("last name", lastNameText);

            startActivity(intent);
        }
    }
}