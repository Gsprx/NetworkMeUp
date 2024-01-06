package com.example.networkmeup.view.ModifyCV.ModifyCVEditEducation;

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
import com.example.networkmeup.utils.RecyclerViewAdapters.SelectEducationRecyclerViewAdapter;
import com.example.networkmeup.view.ModifyCV.ModifyCVActivity;
import com.example.networkmeup.view.ModifyCV.ModifyCVEditEducation.AddNewEducation.AddNewEducationActivity;
import com.example.networkmeup.view.ModifyCV.ModifyCVEditEducation.ChangeEducationDetails.ChangeEducationDetailsActivity;

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

        //get employee data to pass to recycler view
        EmployeeDAO employeeDAO = new EmployeeDAOMemory();
        Employee currEmployee = employeeDAO.getByEmail(new Email(userEmail));
        ArrayList<Education> educationList = currEmployee.getCV().getEducation();

        //get recycler view reference
        RecyclerView recyclerView = findViewById(R.id.recyclerViewModifyCVEditEducation);
        //create recycler view adapter
        SelectEducationRecyclerViewAdapter adapter = new SelectEducationRecyclerViewAdapter(this, educationList);
        adapter.setClickListener(new SelectEducationRecyclerViewAdapter.ItemClickListener() {
            //click listener for rows in recycler view list
            @Override
            public void onItemClick(View view, int position) {
                presenter.onItemClick(position);
            }
        });
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        //when add new button is pressed
        findViewById(R.id.btnModifyCVEditEducationAddNew).setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        //When Login button is pressed
                        presenter.onAddNew();
                    }
                }
        );
        // when back button is pressed
        findViewById(R.id.backbuttonModifyCVEditEducation).setOnClickListener(
                new View.OnClickListener(){
                    public void onClick(View v){
                        Intent intent = new Intent(ModifyCVEditEducationActivity.this, ModifyCVActivity.class);
                        intent.setFlags(Intent.FLAG_ACTIVITY_REORDER_TO_FRONT);
                        startActivity(intent);
                    }
                }
        );
    }
    @Override
    public void changeEductionDetails(String userToken, int position){
        Intent intent = new Intent(ModifyCVEditEducationActivity.this, ChangeEducationDetailsActivity.class);
        intent.putExtra("token", userToken);
        intent.putExtra("position", position);
        startActivity(intent);
    }

    @Override
    public void addNewEducation(String userToken) {
        Intent intent = new Intent(ModifyCVEditEducationActivity.this, AddNewEducationActivity.class);
        intent.putExtra("token", userToken);
        startActivity(intent);
    }

}