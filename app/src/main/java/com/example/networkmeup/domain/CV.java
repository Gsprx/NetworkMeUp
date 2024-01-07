package com.example.networkmeup.domain;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * Represents a Curriculum Vitae (CV) containing information about education, work experiences, skills, and language knowledge.
 */
public class CV implements Serializable {
    private String additionalSkillset; // Additional skillset information
    private ArrayList<Education> education; // List of educational experiences
    private ArrayList<WorkExperience> workExperiences; // List of work experiences
    private ArrayList<LanguageKnowledge> languageKnowledge; // List of language knowledge


    /**
     * Constructor to initialize CV with empty lists for education, work experiences, and language knowledge.
     */
    public CV(){
        education = new ArrayList<>();
        workExperiences = new ArrayList<>();
        languageKnowledge = new ArrayList<>();
        additionalSkillset = "";
    }

    /**
     * Validates the input parameter to ensure it is not null.
     * @param obj The object to be validated.
     * @throws NullPointerException if the input object is null.
     */
    private void validateInput(Object obj){
        if (obj == null){
            throw new NullPointerException("Field cannot be null.");
        }
    }

    /**
     * Retrieves the additional skillset information from the CV.
     * @return The additional skillset information.
     */
    public String getAdditionalSkillset() {
        return additionalSkillset;
    }

    /**
     * Sets the additional skillset information in the CV.
     * @param additionalSkillset The additional skillset to be set.
     * @throws NullPointerException if the input additionalSkillset is null.
     */
    public void setAdditionalSkillset(String additionalSkillset) {
        validateInput(additionalSkillset);
        this.additionalSkillset = additionalSkillset;
    }

    /**
     * Retrieves the list of educational experiences from the CV.
     * @return The list of educational experiences.
     */
    public ArrayList<Education> getEducation() {
        return education;
    }

    /**
     * Adds an educational experience to the CV.
     * @param education The educational experience to be added.
     * @throws NullPointerException if the input education is null.
     */
    public void setEducation(Education education){
        validateInput(education);
        this.education.add(education);
    }

    /**
     * Retrieves the list of work experiences from the CV.
     * @return The list of work experiences.
     */
    public ArrayList<WorkExperience> getWorkExperiences() {
        return workExperiences;
    }

    /**
     * Adds a work experience to the CV.
     * @param workExperience The work experience to be added.
     * @throws NullPointerException if the input workExperience is null.
     */
    public void setWorkExperience(WorkExperience workExperience){
        validateInput(workExperience);
        this.workExperiences.add(workExperience);
    }

    /**
     * Retrieves the list of language knowledge from the CV.
     * @return The list of language knowledge.
     */
    public ArrayList<LanguageKnowledge> getLanguageKnowledge() {
        return languageKnowledge;
    }

    /**
     * Adds language knowledge to the CV.
     * @param languageKnowledge The language knowledge to be added.
     * @throws NullPointerException if the input languageKnowledge is null.
     */
    public void setLanguageKnowledge(LanguageKnowledge languageKnowledge){
        validateInput(languageKnowledge);
        this.languageKnowledge.add(languageKnowledge);
    }

}
