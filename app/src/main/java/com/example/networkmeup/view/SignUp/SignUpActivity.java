package com.example.networkmeup.view.SignUp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.networkmeup.R;
import com.example.networkmeup.view.Login.LoginActivity;
import com.example.networkmeup.view.SignUpEmployee.SignUpEmployeeActivity;
import com.example.networkmeup.view.SignUpEmployer.SignUpEmployerActivity;
import com.example.networkmeup.view.StartPage.StartPageActivity;

public class SignUpActivity extends AppCompatActivity implements  SignUpView{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

        final SignUpPresenter presenter = new SignUpPresenter(this);

        //Employee selected during signup screen
        findViewById(R.id.btnSignupSelectEmployee).setOnClickListener(
                new View.OnClickListener(){
            @Override
            public void onClick(View v){
                presenter.onEmployee();
            }
        });

        //Employer selected during signup screen
        findViewById(R.id.btnSignupSelectEmployer).setOnClickListener(
                new View.OnClickListener(){
                    @Override
                    public void onClick(View v){
                        presenter.onEmployer();
                    }
                });
    }


    //Start employee registration activity
    @Override
    public void employee() {
        Intent intent = new Intent(SignUpActivity.this, SignUpEmployeeActivity.class);
        startActivity(intent);

    }
    //Start employer registration activity
    @Override
    public void employer() {
        Intent intent = new Intent(SignUpActivity.this, SignUpEmployerActivity.class);
        startActivity(intent);
    }
}