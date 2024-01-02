package com.example.networkmeup.view.ManageJobPositions.AddNewJob;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.example.networkmeup.R;

public class AddNewJobActivity extends AppCompatActivity implements AddNewJobView {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_new_job);

        Bundle extras = getIntent().getExtras();

        final String userEmail;
        if(extras!=null){
            //obtain user token
            userEmail = extras.getString("token");
        }
        else{
            userEmail = null;
        }

        final  AddNewJobPresenter presenter = new AddNewJobPresenter(this, userEmail);

    }
}