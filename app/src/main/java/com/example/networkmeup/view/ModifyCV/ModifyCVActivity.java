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
import com.example.networkmeup.utils.RecyclerViewAdapters.EducationRecyclerViewAdapter;
import com.example.networkmeup.view.HomeEmployee.HomeEmployeeActivity;
import com.example.networkmeup.view.ModifyCVEditEducation.ModifyCVEditEducationActivity;
import com.example.networkmeup.view.ModifyCVEditLanguageKnowledge.ModifyCVEditLanguageKnowledgeActivity;
import com.example.networkmeup.view.ModifyCVEditWorkExperience.ModifyCVEditWorkExperienceActivity;

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
        RecyclerView educationRecyclerView = findViewById(R.id.recyclerViewEducation);
        RecyclerView workExperienceRecyclerView = findViewById(R.id.recyclerViewWorkExperience);
        RecyclerView languageKnowledgeRecyclerView = findViewById(R.id.recyclerViewLanguageKnowledge);

        //create dao object to obtain lists' data
        EmployeeDAO employeeDAO = new EmployeeDAOMemory();

        //obtain current employee's cv data lists (education, work experience, language knowledge)
        ArrayList<Education> educationList = employeeDAO.getByEmail(new Email(userEmail)).getCV().getEducation();

        //create recycler view adapters
        EducationRecyclerViewAdapter educationRecyclerViewAdapter = new EducationRecyclerViewAdapter(this, educationList);

        //attach RecyclerView Adapters to the respective RecyclerViews
        educationRecyclerView.setAdapter(educationRecyclerViewAdapter);
        educationRecyclerView.setLayoutManager(new LinearLayoutManager(this));


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