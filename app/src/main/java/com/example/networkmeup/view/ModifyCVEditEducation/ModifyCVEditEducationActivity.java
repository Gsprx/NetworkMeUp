package com.example.networkmeup.view.ModifyCVEditEducation;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.networkmeup.R;
import com.example.networkmeup.dao.EmployeeDAO;
import com.example.networkmeup.daoMemory.EmployeeDAOMemory;
import com.example.networkmeup.domain.Education;
import com.example.networkmeup.domain.Email;
import com.example.networkmeup.domain.Employee;
import com.example.networkmeup.utils.RecyclerViewAdapters.EditEducationRecyclerViewAdapter;
import com.example.networkmeup.view.ModifyCVEditEducation.ChangeEducationDetails.ChangeEducationDetailsActivity;

import java.util.ArrayList;

public class ModifyCVEditEducationActivity extends AppCompatActivity implements ModifyCVEditEducationView{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_modify_cv_edit_education);

        Bundle extras = getIntent().getExtras();

        final String userEmail;
        if(extras!=null){
            //obtain user token
            userEmail = extras.getString("token");
        }
        else{
            userEmail = null;
        }

        final ModifyCVEditEducationPresenter presenter = new ModifyCVEditEducationPresenter(this, userEmail);

        EmployeeDAO employeeDAO = new EmployeeDAOMemory();
        Employee currEmployee = employeeDAO.getByEmail(new Email(userEmail));
        ArrayList<Education> educationList = currEmployee.getCV().getEducation();

        RecyclerView recyclerView = findViewById(R.id.recyclerViewModifyCVEditEducation);
        EditEducationRecyclerViewAdapter adapter = new EditEducationRecyclerViewAdapter(this, educationList);
        adapter.setClickListener(new EditEducationRecyclerViewAdapter.ItemClickListener() {
            //click listener for rows in recycler view list
            @Override
            public void onItemClick(View view, int position) {
                presenter.onItemClick(position);
            }
        });
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
    }
    @Override
    public void changeEductionDetails(String userToken, int position){
        Intent intent = new Intent(ModifyCVEditEducationActivity.this, ChangeEducationDetailsActivity.class);
        intent.putExtra("token", userToken);
        intent.putExtra("position", position);
        startActivity(intent);
    }

    //
    // ADD A METHOD FOR EDUCATION CREATION HERE

    //
}