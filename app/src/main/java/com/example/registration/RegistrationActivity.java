package com.example.registration;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.DatePicker;

import com.example.registration.greeting.MainActivity;
import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;

public class RegistrationActivity extends AppCompatActivity {

    ErrorsData errorsData = new ErrorsData(this);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration);
        //созраням дату рождения в строку
        DatePicker datePicker = (DatePicker)this.findViewById(R.id.datePicker);
        datePicker.init(2000, 0, 1, new DatePicker.OnDateChangedListener() {
            @Override
            public void onDateChanged(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
                String date = "Дата: " + view.getDayOfMonth() + "/" + (view.getMonth() + 1) + "/" + view.getYear();
            }
        });
    }


    public void Registration(View view) {
        //все поля изначально без ошибок
        errorsData.noError();

        if (errorsData.noEmpty() && //проверка на пустоту полей, если пусто выводится ошибка под полем
                errorsData.CorrectPasswords() && //пароль должен содержать '*', '/' и быть больше 5, иначе выводится ошибка под полем
                errorsData.EqualsPasswords() &&// если пароль и подтвержление не равны, то выводится ошибка под полем
            errorsData.LotsOfLetters() //имя не должно быть больше 10, а фамилия больше 20, иначе ошибка
        )
        {
            //сохраняем имя и фамилию
            TextInputEditText firstText = findViewById(R.id.textFirstName);
            String firstNameText = firstText.getText().toString();

            TextInputEditText lastText = findViewById(R.id.lastName);
            String lastNameText = lastText.getText().toString();

            Intent intent = new Intent(this, MainActivity.class);
            //передаем на MainActivity
            intent.putExtra("first name", firstNameText);
            intent.putExtra("last name", lastNameText);

            startActivity(intent);
        }
    }
}