package com.example.networkmeup.view.StartPage;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

import com.example.networkmeup.R;
import com.example.networkmeup.view.Login.LoginActivity;
import com.example.networkmeup.view.SignUp.SignUpActivity;

public class StartPageActivity extends AppCompatActivity implements StartPageView {
    private static boolean initialized = false;
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

            );

        findViewById(R.id.btnStartPageSignUp).setOnClickListener(
            new View.OnClickListener(){
                @Override
                public void onClick(View v){
                    presenter.onSignUp();
                }
            }
            );


//        MEMORY INITIALIZATION METHOD
//        if(!initialized)
//        {
//            new MemoryInitializer().prepareData();
//            initialized = true;
//        }

    }
    public void login(){
        Intent intent = new Intent(StartPageActivity.this, LoginActivity.class);
        startActivity(intent);
    }

    public void signup(){
        Intent intent = new Intent(StartPageActivity.this, SignUpActivity.class);
        startActivity(intent);
    }
}