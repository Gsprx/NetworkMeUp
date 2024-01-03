package com.example.networkmeup.view.ModifyCV.ModifyCVEditWorkExperience;

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
import com.example.networkmeup.domain.WorkExperience;
import com.example.networkmeup.utils.RecyclerViewAdapters.SelectWorkExperienceRecyclerViewAdapter;
import com.example.networkmeup.view.ModifyCV.ModifyCVEditWorkExperience.AddNewWorkExperience.AddNewWorkExperienceActivity;
import com.example.networkmeup.view.ModifyCV.ModifyCVEditWorkExperience.ChangeWorkExperienceDetails.ChangeWorkExperienceDetailsActivity;

import java.util.ArrayList;

public class ModifyCVEditWorkExperienceActivity extends AppCompatActivity implements ModifyCVEditWorkExperienceView {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_modify_cv_edit_work_experience);
        Bundle extras = getIntent().getExtras();

        final String userEmail;
        if(extras!=null){
            //obtain user token
            userEmail = extras.getString("token");
        }
        else{
            userEmail = null;
        }

        final ModifyCVEditWorkExperiencePresenter presenter = new ModifyCVEditWorkExperiencePresenter(this, userEmail);

        //get employee data to pass to recycler view
        EmployeeDAO employeeDAO = new EmployeeDAOMemory();
        Employee currEmployee = employeeDAO.getByEmail(new Email(userEmail));
        ArrayList<WorkExperience> workexpList = currEmployee.getCV().getWorkExperiences();

        //get recycler view reference
        RecyclerView recyclerView = findViewById(R.id.recyclerViewModifyCVEditWorkExperience);
        //create recycler view adapter
        SelectWorkExperienceRecyclerViewAdapter adapter = new SelectWorkExperienceRecyclerViewAdapter(this, workexpList);
        adapter.setClickListener(new SelectWorkExperienceRecyclerViewAdapter.ItemClickListener() {
            //click listener for rows in recycler view list
            @Override
            public void onItemClick(View view, int position) {
                presenter.onItemClick(position);
            }
        });
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        //when add new button is pressed
        findViewById(R.id.btnModifyCVEditWorkExperienceAddNew).setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        //When Login button is pressed
                        presenter.onAddNew();
                    }
                }
        );
    }


    @Override
    public void changeWorkExperienceDetails(String userToken, int position){
        Intent intent = new Intent(ModifyCVEditWorkExperienceActivity.this, ChangeWorkExperienceDetailsActivity.class);
        intent.putExtra("token", userToken);
        intent.putExtra("position", position);
        startActivity(intent);
    }

    @Override
    public void addNewWorkExperience(String userToken) {
        Intent intent = new Intent(ModifyCVEditWorkExperienceActivity.this, AddNewWorkExperienceActivity.class);
        intent.putExtra("token", userToken);
        startActivity(intent);
    }

}