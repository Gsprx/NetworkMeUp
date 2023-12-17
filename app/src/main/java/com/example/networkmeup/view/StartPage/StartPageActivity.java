package com.example.networkmeup.view.StartPage;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

import com.example.networkmeup.R;
import com.example.networkmeup.view.Login.LoginActivity;

public class StartPageActivity extends AppCompatActivity implements StartPageView {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start_page);

        final StartPagePresenter presenter = new StartPagePresenter(this);

        findViewById(R.id.btnStartPageLogin).setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        //When Login button is pressed
                        presenter.onLogin();
                    }
                }
        );}
    public void login(){
        Intent intent = new Intent(StartPageActivity.this, LoginActivity.class);
        startActivity(intent);
    }
}
