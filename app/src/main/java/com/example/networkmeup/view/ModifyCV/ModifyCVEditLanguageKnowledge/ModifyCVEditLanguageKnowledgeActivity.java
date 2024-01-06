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
import com.example.networkmeup.domain.Education;
import com.example.networkmeup.domain.Email;
import com.example.networkmeup.domain.Employee;
import com.example.networkmeup.domain.LanguageKnowledge;
import com.example.networkmeup.utils.RecyclerViewAdapters.LanguageKnowledgeRecyclerViewAdapter;
import com.example.networkmeup.view.ModifyCV.ModifyCVEditLanguageKnowledge.AddNewLanguageKnowledge.AddNewLanguageKnowledgeActivity;
import com.example.networkmeup.view.ModifyCV.ModifyCVEditLanguageKnowledge.ChangeLanguageKnowledgeDetails.ChangeLanguageKnowledgeDetailsActivity;

import java.util.ArrayList;

public class ModifyCVEditLanguageKnowledgeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_modify_cv_edit_language_knowledge);
    }
}