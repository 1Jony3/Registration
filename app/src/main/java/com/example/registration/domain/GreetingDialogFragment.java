package com.example.registration.domain;

import android.app.AlertDialog;
import android.app.Dialog;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.DialogFragment;

public class GreetingDialogFragment extends DialogFragment {
    @NonNull
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        //принимаем в строку переданный аргумент
        String first = getArguments().getString("name");

        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        return builder
                .setMessage(first + ", welcome") //выводим в диалоговое окно переданный аргумент
                .setPositiveButton("OK", null) //одна кнопка, которая будет закрывать диалоговое окно
                .create();
    }
}
