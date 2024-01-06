package com.example.networkmeup.view.ModifyCV.ModifyCVEditLanguageKnowledge;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.networkmeup.R;
import com.example.networkmeup.dao.EmployeeDAO;
import com.example.networkmeup.daoMemory.EmployeeDAOMemory;
import com.example.networkmeup.domain.LanguageKnowledge;
import com.example.networkmeup.domain.Email;
import com.example.networkmeup.domain.Employee;
import com.example.networkmeup.utils.RecyclerViewAdapters.LanguageKnowledgeRecyclerViewAdapter;
import com.example.networkmeup.utils.RecyclerViewAdapters.SelectLanguageKnowledgeRecyclerViewAdapter;
import com.example.networkmeup.view.ModifyCV.ModifyCVEditLanguageKnowledge.AddNewLanguageKnowledge.AddNewLanguageKnowledgeActivity;
import com.example.networkmeup.view.ModifyCV.ModifyCVEditLanguageKnowledge.ChangeLanguageKnowledgeDetails.ChangeLanguageKnowledgeDetailsActivity;

import java.util.ArrayList;

public class ModifyCVEditLanguageKnowledgeActivity extends AppCompatActivity implements ModifyCVEditLanguageKnowledgeView {

    private ModifyCVEditLanguageKnowledgePresenter presenter;
    private String userEmail;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_modify_cv_edit_language_knowledge);

        // Get user token from intent extras
        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            userEmail = extras.getString("token");
        } else {
            userEmail = null;
        }

        // Initialize presenter with user token
        presenter = new ModifyCVEditLanguageKnowledgePresenter(this, userEmail);

        // Retrieve employee's language knowledge data
        EmployeeDAO employeeDAO = new EmployeeDAOMemory();
        Employee currEmployee = employeeDAO.getByEmail(new Email(userEmail));
        ArrayList<LanguageKnowledge> languageList = currEmployee.getCV().getLanguageKnowledge();

        // Set up RecyclerView
        RecyclerView recyclerView = findViewById(R.id.recyclerViewModifyCVEditLanguageKnowledge);
        SelectLanguageKnowledgeRecyclerViewAdapter adapter = new SelectLanguageKnowledgeRecyclerViewAdapter(this, languageList);
        adapter.setClickListener((view, position) -> presenter.onItemClick(position));

        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        // Add new language knowledge button click listener
        findViewById(R.id.btnModifyCVEditLanguageKnowledgeAddNew).setOnClickListener(view -> presenter.onAddNew());
    }

    @Override
    public void changeLanguageKnowledgeDetails(String userToken, int position) {
        Intent intent = new Intent(ModifyCVEditLanguageKnowledgeActivity.this, ChangeLanguageKnowledgeDetailsActivity.class);
        intent.putExtra("token", userToken);
        intent.putExtra("position", position);
        startActivity(intent);
    }

    @Override
    public void addNewLanguageKnowledge(String userToken) {
        Intent intent = new Intent(ModifyCVEditLanguageKnowledgeActivity.this, AddNewLanguageKnowledgeActivity.class);
        intent.putExtra("token", userToken);
        startActivity(intent);
    }
}
