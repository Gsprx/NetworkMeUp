package com.example.networkmeup.view.ManageJobPositions.ChangeJobDetails.EditReqLangKnowledge.AddNewReqLangKnowledge;

import com.example.networkmeup.domain.Job;
import com.example.networkmeup.domain.LevelOfKnowledge;

public interface AddNewReqLangKnowledgeView {
        void successfulAdd(String message, String userToken, Job job);
        String getDescription();
        public int getLanguage();
        public LevelOfKnowledge getLevelOfKnowledge();

}
