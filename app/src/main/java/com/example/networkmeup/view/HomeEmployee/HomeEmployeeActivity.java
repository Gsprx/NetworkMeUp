package com.example.networkmeup.view.HomeEmployee;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.networkmeup.R;
import com.example.networkmeup.view.EditAccountEmployee.EditAccountEmployeeActivity;
import com.example.networkmeup.view.Login.LoginEmployee.LoginEmployeeActivity;
import com.example.networkmeup.view.ModifyCV.ModifyCVActivity;
import com.example.networkmeup.view.SearchJobs.SearchJobsActivity;
import com.example.networkmeup.view.SignUp.SignUpActivity;
import com.example.networkmeup.view.StartPage.StartPageActivity;

public class HomeEmployeeActivity extends AppCompatActivity implements HomeEmployeeView{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_employee);

        //homepage employee activity requires a login token from the user that logged in (token = email)
        Bundle extras = getIntent().getExtras();

        String userEmail = null;
        if(extras!=null){
            //obtain user token
            userEmail = extras.getString("token");
        }
        //pass user token to presenter
        final HomeEmployeePresenter presenter = new HomeEmployeePresenter(this, userEmail);


        //when modify CV button is pressed
        findViewById(R.id.btnHomeEmployeeModifyCV).setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        //When Login button is pressed
                        presenter.onModifyCV();
                    }
                }
        );

        //when search jobs button is pressed
        findViewById(R.id.btnHomeEmployeeSearchJobs).setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        //When Login button is pressed
                        presenter.onSearchJobs();
                    }
                }
        );

        //when edit account button is pressed
        findViewById(R.id.btnHomeEmployeeEditAccount).setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        //When Login button is pressed
                        presenter.onEditAccount();
                    }
                }
        );
        // when back button is pressed
        findViewById(R.id.backbuttonHomeEmployee).setOnClickListener(
                new View.OnClickListener(){
                    public void onClick(View v){
                        Intent intent = new Intent(HomeEmployeeActivity.this, LoginEmployeeActivity.class);
                        intent.setFlags(Intent.FLAG_ACTIVITY_REORDER_TO_FRONT);
                        startActivity(intent);
                    }
                }
        );
    }

    //error message specifically for login token errors
    public void showTokenErrorMessage(String message) {
        new AlertDialog.Builder(HomeEmployeeActivity.this)
                .setCancelable(false)
                .setTitle("Login Token Error")
                .setMessage(message)
                .setPositiveButton(R.string.ok,
                        new DialogInterface.OnClickListener(){
                            public void onClick (DialogInterface dialog,int id) {

                                Intent intent = new Intent(HomeEmployeeActivity.this, LoginEmployeeActivity.class);
                                startActivity(intent);
                            }}).create().show();
    }

    //
    //    methods to start new activities must pass the userToken
    //    using intent.putExtra("token", userToken);
    //
    @Override
    public void modifyCV(String userToken) {
        Intent intent = new Intent(HomeEmployeeActivity.this, ModifyCVActivity.class);
        intent.putExtra("token", userToken);
        startActivity(intent);
    }

    @Override
    public void searchJobs(String userToken) {
        Intent intent = new Intent(HomeEmployeeActivity.this, SearchJobsActivity.class);
        intent.putExtra("token", userToken);
        startActivity(intent);
    }

    @Override
    public void editAccount(String userToken) {
        Intent intent = new Intent(HomeEmployeeActivity.this, EditAccountEmployeeActivity.class);
        intent.putExtra("token", userToken);
        startActivity(intent);
    }

}