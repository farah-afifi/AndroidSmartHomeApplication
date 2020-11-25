package com.example.project;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class SignUp extends AppCompatActivity {

    EditText Email;
    EditText Password1;
    EditText Password2;
    Button SignUp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);
        Email = (EditText) findViewById(R.id.EmailSignUp);
        Password1 = (EditText) findViewById(R.id.Password1);
        Password2 = (EditText) findViewById(R.id.Password2);
        SignUp = (Button) findViewById(R.id.SignUpBTN);
    }


}