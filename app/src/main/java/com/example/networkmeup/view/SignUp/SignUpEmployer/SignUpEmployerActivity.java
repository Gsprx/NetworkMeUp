package com.example.networkmeup.view.SignUp.SignUpEmployer;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import com.example.networkmeup.R;
import com.example.networkmeup.daoMemory.EmployerDAOMemory;
import com.example.networkmeup.domain.Email;
import com.example.networkmeup.domain.Password;
import com.example.networkmeup.domain.Phone;
import com.example.networkmeup.domain.TIN;
import com.example.networkmeup.view.Login.LoginEmployer.LoginEmployerActivity;
import com.example.networkmeup.view.SignUp.SignUpActivity;
import com.example.networkmeup.view.StartPage.StartPageActivity;

public class SignUpEmployerActivity extends AppCompatActivity implements SignUpEmployerView{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up_employer);

        final SignUpEmployerPresenter presenter = new SignUpEmployerPresenter(this, new EmployerDAOMemory());


        findViewById(R.id.btnSignupEmployerCreate).setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        //When Login button is pressed
                        presenter.onCreate();
                    }
                }
        );

        // when back button is pressed
        findViewById(R.id.backbuttonSignUpEmployer).setOnClickListener(
                new View.OnClickListener(){
                    public void onClick(View v){
                        Intent intent = new Intent(SignUpEmployerActivity.this, SignUpActivity.class);
                        intent.setFlags(Intent.FLAG_ACTIVITY_REORDER_TO_FRONT);
                        startActivity(intent);
                    }
                }
        );
    }

    @Override
    public Email getEmail() throws RuntimeException{
        return new Email(((EditText)findViewById(R.id.editTextSignUpEmployerEmail)).getText().toString().trim());
    }
    @Override
    public Phone getPhone() throws RuntimeException{
        return new Phone(((EditText)findViewById(R.id.editTextSignUpEmployerPhone)).getText().toString().trim());
    }
    @Override
    public Password getPassword() throws RuntimeException{
        return new Password(((EditText)findViewById(R.id.editTextSignupEmployerPassword)).getText().toString().trim());
    }

    @Override
    public TIN getTIN() throws RuntimeException {
        return new TIN(((EditText)findViewById(R.id.editTextSignUpEmployerTIN)).getText().toString().trim());
    }

    @Override
    public void showErrorMessage(String title, String message) {
        new AlertDialog.Builder(SignUpEmployerActivity.this)
                .setCancelable(true)
                .setTitle(title)
                .setMessage(message)
                .setPositiveButton(R.string.ok, null).create().show();
    }

    @Override
    //after a successful signup, return to start page
    public void successfullyFinishActivity(String message) {
        new AlertDialog.Builder(SignUpEmployerActivity.this)
                .setCancelable(false)
                .setTitle("Account Successfully Created!")
                .setMessage(message)

                //when the continue to login button is pressed, the employer login page opens for the user to login.
                .setPositiveButton(R.string.continue_to_login,
                        new DialogInterface.OnClickListener(){

                            public void onClick (DialogInterface dialog,int id) {

                                Intent intent = new Intent(SignUpEmployerActivity.this, LoginEmployerActivity.class);
                                startActivity(intent);
                            }}).create().show();
    }
}