package com.example.networkmeup.domain;

import java.util.ArrayList;

public class CV {
    private String additionalSkillset;
    private ArrayList<Education> education;
    private ArrayList<WorkExperience> workExperiences;
    private ArrayList<LanguageKnowledge> languageKnowledge;


    public CV(){
        education = new ArrayList<>();
        workExperiences = new ArrayList<>();
        languageKnowledge = new ArrayList<>();
    }

    private void validateInput(Object obj){
        if (obj == null){
            throw new NullPointerException("Field cannot be null.");
        }
    }

    public String getAdditionalSkillset() {
        return additionalSkillset;
    }

    public void setAdditionalSkillset(String additionalSkillset) {
        validateInput(additionalSkillset);
        this.additionalSkillset = additionalSkillset;
    }

    public ArrayList<Education> getEducation() {
        return education;
    }

    public void setEducation(Education education){
        validateInput(education);
        this.education.add(education);
    }

    public ArrayList<WorkExperience> getWorkExperiences() {
        return workExperiences;
    }
    public void setWorkExperience(WorkExperience workExperience){
        validateInput(workExperience);
        this.workExperiences.add(workExperience);
    }

    public ArrayList<LanguageKnowledge> getLanguageKnowledge() {
        return languageKnowledge;
    }

    public void setLanguageKnowledge(LanguageKnowledge languageKnowledge){
        validateInput(languageKnowledge);
        this.languageKnowledge.add(languageKnowledge);
    }

}
