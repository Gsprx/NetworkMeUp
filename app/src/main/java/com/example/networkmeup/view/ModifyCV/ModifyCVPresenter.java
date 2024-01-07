package com.example.networkmeup.view.ModifyCV;

import android.widget.Adapter;

import com.example.networkmeup.daoMemory.EmployeeDAOMemory;
import com.example.networkmeup.domain.Email;
import com.example.networkmeup.domain.Employee;

import java.util.ArrayList;

public class ModifyCVPresenter {
    private ModifyCVView view;
    private String userToken;

    public ModifyCVPresenter(ModifyCVView view, String userToken) {
        this.view = view;
        this.userToken = userToken;
    }

    public void onEditEducation() {
        save();
        view.editEducation(userToken);
    }

    public void onEditWorkExperience() {
        save();
        view.editWorkExperience(userToken);
    }

    public void onEditLanguageKnowledge() {
        save();
        view.editLanguageKnowledge(userToken);
    }

    //save changes made to additional skillset when changing activities
    public void save() {
        Employee currEmployee = new EmployeeDAOMemory().getByEmail(new Email(userToken));
        currEmployee.getCV().setAdditionalSkillset(view.getAdditionalSkillset());
    }
}
