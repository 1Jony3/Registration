package com.example.registration.greeting;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;

import com.example.registration.domain.GreetingDialogFragment;
import com.example.registration.R;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void Greeting(View view){

        Bundle arguments = getIntent().getExtras();
        //сохраням в троки переданые аргументы
        String firstNameText = arguments.get("first name").toString();
        String lastNameText = arguments.get("last name").toString();
        //создаем диалоговое окно
        GreetingDialogFragment dialog = new GreetingDialogFragment();
        //передаем в инициализацию диалогового окна строку с именем и фамилией
        Bundle name = new Bundle();
        name.putString("name", firstNameText + " " + lastNameText);
        dialog.setArguments(name);
        //показываем диалоговое окно
        dialog.show(getSupportFragmentManager(), "tag1");
    }
}