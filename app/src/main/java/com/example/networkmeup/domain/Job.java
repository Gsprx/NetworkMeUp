package com.example.networkmeup.domain;

import java.util.ArrayList;

enum Availability{
    Available,
    Temporarily_Unavailable,
    Closed
}
public class Job {
    private String title;
    private String description;
    private Availability availability;
    private ArrayList<Application> applications;
    private ArrayList<Education> reqEducation;
    private ArrayList<WorkExperience> reqWorkExperience;
    private ArrayList<LanguageKnowledge> reqLanguageKnowledge;

    public Job(String title, String description){
        validateData(title,description);
        applications = new ArrayList<>();
        reqEducation = new ArrayList<>();
        reqWorkExperience = new ArrayList<>();
        reqLanguageKnowledge = new ArrayList<>();
    }

    private void validateData(String title, String description){
        if(title == null){
            throw new NullPointerException("Job title cannot be null.");
        }
        if(description == null){
            throw new NullPointerException("Job description cannot be null.");
        }
        this.title = title;
        this.description = description;
    }

    public boolean acceptCV(CV cv){

        for(Education reqEducation : reqEducation){
            //for each required education we do the following:

            boolean found = false; //if we find a matching (or greater) education becomes true, else remains false.
            for(Education applicantEducation : cv.getEducation()){
                if (applicantEducation.compare(reqEducation) >= 0){
                    found = true;
                    break;
                }
            }
            if (found == false){
                return false; //insufficient education
            }
        }

        for(WorkExperience reqWorkExperience : reqWorkExperience){
            //for each required work experience we do the following:

            boolean found = false; //if we find a matching (or greater) work experience becomes true, else remains false.
            for(WorkExperience applicantWorkExperience : cv.getWorkExperiences()){
                if (applicantWorkExperience.compare(reqWorkExperience) >= 0){
                    found = true;
                    break;
                }
            }
            if (found == false){
                return false; //insufficient work experience
            }
        }

        for(LanguageKnowledge reqLanguageKnowledge : reqLanguageKnowledge){
            //for each required language knowledge we do the following:

            boolean found = false; //if we find a matching (or greater) language knowledge becomes true, else remains false.
            for(LanguageKnowledge applicantLanguageKnowledge : cv.getLanguageKnowledge()){
                if (applicantLanguageKnowledge.compare(reqLanguageKnowledge) >= 0){
                    found = true;
                    break;
                }
            }
            if (found == false){
                return false; //insufficient language knowledge
            }
        }

        return true; //sufficient in every requirement
    }

    private void validateObject(Object obj){
        if (obj == null){
            throw new NullPointerException("Object cannot be null");
        }
        return;
    }

    public void addReqEducation (Education edu){
        validateObject(edu);
        this.reqEducation.add(edu);
    }

    public void addReqLanguageKnowledge(LanguageKnowledge languageKnowledge){
        validateObject(languageKnowledge);
        this.reqLanguageKnowledge.add(languageKnowledge);
    }

    public void addReqWorkExperience(WorkExperience workExperience){
        validateObject(workExperience);
        this.reqWorkExperience.add(workExperience);
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public void setAvailability(Availability availability){
        validateObject(availability);
        this.availability = availability;
    }
    public Availability getAvailability() {
        return availability;
    }

    public ArrayList<Application> getApplications() {
        return applications;
    }

    public void addApplication(Application application){
        validateObject(application);
        this.applications.add(application);
    }

    public ArrayList<Education> getReqEducation() {
        return reqEducation;
    }

    public ArrayList<WorkExperience> getReqWorkExperience() {
        return reqWorkExperience;
    }

    public ArrayList<LanguageKnowledge> getReqLanguageKnowledge() {
        return reqLanguageKnowledge;
    }
}
