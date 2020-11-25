package com.example.project;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

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

    public void SignUpCLK(View view) {
        String email = Email.getText().toString();
        String pass = Password1.getText().toString();
        String pass2 = Password2.getText().toString();

        String regex = "^[\\w!#$%&'*+/=?`{|}~^-]+(?:\\.[\\w!#$%&'*+/=?`{|}~^-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,6}$";
        Pattern pattern = Pattern.compile(regex);

        Matcher matcher = pattern.matcher(email);
        if( !matcher.matches()){
            Toast.makeText(this,"Please enter a correct email" ,Toast.LENGTH_LONG ).show();
        }
        else if(!pass.equals(pass2)){
            Toast.makeText(this,"Passwords don't match! Please re-enter the password" ,Toast.LENGTH_LONG ).show();
        }
        else{
            Toast.makeText(this,"An email has been sent to this email, Please confirm it" ,Toast.LENGTH_LONG ).show();
            finish();
        }



    }
}