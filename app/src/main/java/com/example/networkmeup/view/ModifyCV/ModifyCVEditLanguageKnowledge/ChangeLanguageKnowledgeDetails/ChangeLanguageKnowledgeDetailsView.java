package com.example.networkmeup.view.ModifyCV.ModifyCVEditLanguageKnowledge.ChangeLanguageKnowledgeDetails;

import com.example.networkmeup.domain.LanguageKnowledge;
import com.example.networkmeup.domain.LevelOfKnowledge;

public interface ChangeLanguageKnowledgeDetailsView {
    public String getDescription();
    public int getLanguage();
    public LevelOfKnowledge getLevelOfKnowledge();
    public void successfulDelete(String message, String userToken);
    public void successfulSave(String message, String userToken);
}
