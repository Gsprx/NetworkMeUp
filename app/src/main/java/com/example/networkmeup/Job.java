package com.example.networkmeup;

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

        for(Education reqEduaction : reqEducation){
            //for each required education we do the following:

            boolean found = false; //if we find a matching (or greater) education becomes true, else remains false.
            for(Education applicantEducation : cv.getEducation()){
                if (applicantEducation.compare(reqEduaction) >= 0){
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
}
