package com.example.networkmeup.view.ModifyCV;

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
import com.example.networkmeup.domain.LanguageKnowledge;
import com.example.networkmeup.domain.WorkExperience;
import com.example.networkmeup.utils.RecyclerViewAdapters.EducationRecyclerViewAdapter;
import com.example.networkmeup.utils.RecyclerViewAdapters.WorkExperienceRecyclerViewAdapter;
import com.example.networkmeup.view.ModifyCV.ModifyCVEditEducation.ModifyCVEditEducationActivity;
import com.example.networkmeup.view.ModifyCV.ModifyCVEditLanguageKnowledge.ModifyCVEditLanguageKnowledgeActivity;
import com.example.networkmeup.view.ModifyCV.ModifyCVEditWorkExperience.ModifyCVEditWorkExperienceActivity;

import java.util.ArrayList;

public class ModifyCVActivity extends AppCompatActivity implements ModifyCVView{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_modify_cv);

        //modify cv employee activity requires a login token from the employee home page (token = email)
        Bundle extras = getIntent().getExtras();

        String userEmail = null;
        if(extras!=null){
            //obtain user token
            userEmail = extras.getString("token");
        }
        //pass user token to presenter
        final ModifyCVPresenter presenter = new ModifyCVPresenter(this, userEmail);


        //grab recycler views
        RecyclerView educationRecyclerView = findViewById(R.id.recyclerViewModifyCVEducation);
        RecyclerView workExperienceRecyclerView = findViewById(R.id.recyclerViewModifyCVWorkExperience);
        RecyclerView languageKnowledgeRecyclerView = findViewById(R.id.recyclerViewModifyCVLanguageKnowledge);

        //create dao object to obtain lists' data
        EmployeeDAO employeeDAO = new EmployeeDAOMemory();

        //obtain current employee's cv data lists (education, work experience, language knowledge)
        Employee currEmployee = employeeDAO.getByEmail(new Email(userEmail));
        ArrayList<Education> educationList = currEmployee.getCV().getEducation();
        ArrayList<WorkExperience> workExperienceList = currEmployee.getCV().getWorkExperiences();
        ArrayList<LanguageKnowledge> langKnowledgeList = currEmployee.getCV().getLanguageKnowledge();

        //create recycler view adapters
        EducationRecyclerViewAdapter educationRecyclerViewAdapter = new EducationRecyclerViewAdapter(this, educationList);
        WorkExperienceRecyclerViewAdapter workExperienceRecyclerViewAdapter = new WorkExperienceRecyclerViewAdapter(this, workExperienceList);


        //attach RecyclerView Adapters to the respective RecyclerViews
        educationRecyclerView.setAdapter(educationRecyclerViewAdapter);
        educationRecyclerView.setLayoutManager(new LinearLayoutManager(this));

        workExperienceRecyclerView.setAdapter(workExperienceRecyclerViewAdapter);
        workExperienceRecyclerView.setLayoutManager(new LinearLayoutManager(this));

        //button listeners
        //when edit education list is pressed
        findViewById(R.id.btnModifyCVEditEducation).setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        //When Login button is pressed
                        presenter.onEditEducation();
                    }
                }
        );

        //when edit education list is pressed
        findViewById(R.id.btnModifyCVEditWorkExperience).setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        //When Login button is pressed
                        presenter.onEditWorkExperience();
                    }
                }
        );

        //when edit education list is pressed
        findViewById(R.id.btnModifyCVEditLangKnowledge).setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        //When Login button is pressed
                        presenter.onEditLanguageKnowledge();
                    }
                }
        );
    }

    @Override
    public void editEducation(String userToken) {
        Intent intent = new Intent(ModifyCVActivity.this, ModifyCVEditEducationActivity.class);
        intent.putExtra("token", userToken);
        startActivity(intent);
    }

    @Override
    public void editWorkExperience(String userToken) {
        Intent intent = new Intent(ModifyCVActivity.this, ModifyCVEditWorkExperienceActivity.class);
        intent.putExtra("token", userToken);
        startActivity(intent);
    }

    @Override
    public void editLanguageKnowledge(String userToken) {
        Intent intent = new Intent(ModifyCVActivity.this, ModifyCVEditLanguageKnowledgeActivity.class);
        intent.putExtra("token", userToken);
        startActivity(intent);
    }
}