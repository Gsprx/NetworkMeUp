package com.example.networkmeup.view.Login;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.example.networkmeup.R;

public class LoginActivity extends AppCompatActivity implements LoginView{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
    }
}