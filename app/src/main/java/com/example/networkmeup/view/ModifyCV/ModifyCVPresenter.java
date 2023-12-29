package com.example.networkmeup.view.ModifyCV;

import android.widget.Adapter;

import java.util.ArrayList;

public class ModifyCVPresenter {
    private ModifyCVView view;
    private String userToken;

    public ModifyCVPresenter(ModifyCVView view, String userToken) {
        this.view = view;
        this.userToken = userToken;
    }

    public void onEditEducation() {
        view.editEducation(userToken);
    }

    public void onEditWorkExperience() {
        view.editWorkExperience(userToken);
    }

    public void onEditLanguageKnowledge() {
        view.editLanguageKnowledge(userToken);
    }
}
