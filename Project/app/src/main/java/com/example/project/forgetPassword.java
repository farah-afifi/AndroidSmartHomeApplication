package com.example.project;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.auth.SignInMethodQueryResult;

public class forgetPassword extends AppCompatActivity {

    private EditText Email;
    private Button ResetPassword;

    private FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forget_password);

        mAuth = FirebaseAuth.getInstance();
        mAuth.addAuthStateListener(authStateListener);

       Email = (EditText) findViewById(R.id.Email1);
       ResetPassword = (Button) findViewById(R.id.resetPassword);
    }

    FirebaseAuth.AuthStateListener authStateListener = new FirebaseAuth.AuthStateListener() {
        @Override
        public void onAuthStateChanged(@NonNull FirebaseAuth firebaseAuth) {
            FirebaseUser firebaseUser = firebaseAuth.getCurrentUser();

        }
    };

    private void checkEmail(String email){
        mAuth.fetchSignInMethodsForEmail(email).addOnCompleteListener(new OnCompleteListener<SignInMethodQueryResult>() {
            @Override
            public void onComplete(@NonNull Task<SignInMethodQueryResult> task) {
                boolean check = !task.getResult().getSignInMethods().isEmpty();
                if(!check){
                    Toast.makeText(forgetPassword.this, "This email is already registered with another account,please try another email.",
                            Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    public void resetPassword(View view) {
        String email = Email.getText().toString();
        if (TextUtils.isEmpty(email)) {
            Toast.makeText(getApplication(), "Enter your mail address", Toast.LENGTH_SHORT).show();
            return;
        }
        checkEmail(email);
        mAuth.sendPasswordResetEmail(email)
                .addOnCompleteListener(new OnCompleteListener<Void>() {
                    @Override
                    public void onComplete(@NonNull Task<Void> task) {
                        if (task.isSuccessful()) {
                            Toast.makeText(forgetPassword.this, "We send you an e-mail to reset your email", Toast.LENGTH_SHORT).show();

                        }
                    }
                });
    }
}