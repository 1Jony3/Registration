package com.example.registration;


import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;

public class ErrorsData {

    RegistrationActivity registrationActivity;

    public ErrorsData(RegistrationActivity registrationActivity) {
        this.registrationActivity = registrationActivity;
    }

    private void WriteErrorNoEmpty(TextInputLayout value){
        value.setError("empty");
        value.setErrorEnabled(true);
    }

    private void WriteErrorLotsOfLetters(TextInputLayout value, int let){
        value.setError("letters more than " + let);
        value.setErrorEnabled(true);
    }

    protected boolean LotsOfLetters(){
        TextInputEditText firstText = registrationActivity.findViewById(R.id.textFirstName);
        TextInputLayout firstLayout = registrationActivity.findViewById(R.id.textInputLayoutFirstName);
        String firstNameText = firstText.getText().toString();
        if (firstNameText.length() > 10) WriteErrorLotsOfLetters(firstLayout, 10);


        TextInputEditText lastText = registrationActivity.findViewById(R.id.lastName);
        TextInputLayout lastLayout = registrationActivity.findViewById(R.id.textInputLayoutLastName);
        String lastNameText = lastText.getText().toString();
        if (lastNameText.length() > 20) WriteErrorLotsOfLetters(lastLayout, 20);

        return (firstNameText.length() <= 10) && (lastNameText.length() <= 10);

    }

    protected boolean noEmpty() {
        TextInputEditText firstText = registrationActivity.findViewById(R.id.textFirstName);
        TextInputLayout firstLayout = registrationActivity.findViewById(R.id.textInputLayoutFirstName);
        String firstNameText = firstText.getText().toString();
        if (firstNameText.equals("")) WriteErrorNoEmpty(firstLayout);


        TextInputEditText lastText = registrationActivity.findViewById(R.id.lastName);
        TextInputLayout lastLayout = registrationActivity.findViewById(R.id.textInputLayoutLastName);
        String lastNameText = lastText.getText().toString();
        if (lastNameText.equals("")) WriteErrorNoEmpty(lastLayout);

        TextInputEditText passText = registrationActivity.findViewById(R.id.pass);
        TextInputLayout passLayout = registrationActivity.findViewById(R.id.textInputLayoutPass);
        String pass = passText.getText().toString();
        if (pass.equals("")) WriteErrorNoEmpty(passLayout);

        TextInputEditText doublePassText = registrationActivity.findViewById(R.id.doublePass);
        TextInputLayout doublePassLayout = registrationActivity.findViewById(R.id.textInputLayoutPassDouble);
        String doublePass = doublePassText.getText().toString();
        if (doublePass.equals("")) WriteErrorNoEmpty(doublePassLayout);

        return (!firstNameText.equals("")) && (!lastNameText.equals("")) && (!pass.equals("")) && (!doublePass.equals(""));
    }

    private void WriteErrorEqualsPasswords(){
        TextInputLayout doublePass = registrationActivity.findViewById(R.id.textInputLayoutPassDouble);
        doublePass.setError("incorrect password");
        doublePass.setErrorEnabled(true);
    }

    protected boolean EqualsPasswords() {
        TextInputEditText passText = registrationActivity.findViewById(R.id.pass);
        String pass = passText.getText().toString();

        TextInputEditText doublePassText = registrationActivity.findViewById(R.id.doublePass);
        String doublePass = doublePassText.getText().toString();

        if (pass.equals(doublePass)) return true;
        else { WriteErrorEqualsPasswords();return false;}

    }


    private void WriteErrorCorrectPasswords(){
        TextInputLayout pass = registrationActivity.findViewById(R.id.textInputLayoutPass);
        pass.setError("the password must contain the characters '*', '/' and be greater than 5");
        pass.setErrorEnabled(true);
    }

    protected boolean CorrectPasswords() {
        TextInputEditText passText = registrationActivity.findViewById(R.id.pass);
        String pass = passText.getText().toString();

        if (pass.length() > 5 && (pass.contains("/") || pass.contains("*"))) return true;
        else {
            WriteErrorCorrectPasswords();
            return false;
        }

    }

    protected void noError(){
        TextInputLayout pass = registrationActivity.findViewById(R.id.textInputLayoutPass);
        pass.setErrorEnabled(false);
        TextInputLayout doublePass = registrationActivity.findViewById(R.id.textInputLayoutPassDouble);
        doublePass.setErrorEnabled(false);
        TextInputLayout firstLayout = registrationActivity.findViewById(R.id.textInputLayoutFirstName);
        firstLayout.setErrorEnabled(false);
        TextInputLayout lastLayout = registrationActivity.findViewById(R.id.textInputLayoutLastName);
        lastLayout.setErrorEnabled(false);
    }

}
