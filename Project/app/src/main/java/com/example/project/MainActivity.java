package com.example.project;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.google.firebase.FirebaseApiNotAvailableException;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.google.firebase.analytics.connector.AnalyticsConnector;

public class MainActivity extends AppCompatActivity {

    private FirebaseAnalytics FBAnalytics = FirebaseAnalytics.getInstance(this);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}