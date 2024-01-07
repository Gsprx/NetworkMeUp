package com.example.networkmeup.view.ModifyCV.ModifyCVEditLanguageKnowledge.AddNewLanguageKnowledge;

import com.example.networkmeup.domain.LanguageKnowledge;
import com.example.networkmeup.domain.LevelOfKnowledge;

public interface AddNewLanguageKnowledgeView {
    public void successfulAdd(String message, String userToken);
    public String getDescription();
    public int getLanguage();
    public LevelOfKnowledge getLevelOfKnowledge();
}
