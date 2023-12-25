package com.example.networkmeup.domain;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.example.networkmeup.R;

/**
 * The MainActivity class represents the main activity of an Android application.
 * It extends the AppCompatActivity class, serving as the entry point of the app.
 */
public class MainActivity extends AppCompatActivity {

    /**
     * Called when the activity is first created.
     * It sets the content view to the layout defined in activity_main.xml.
     * @param savedInstanceState A Bundle object containing the activity's previously saved state, if any.
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}