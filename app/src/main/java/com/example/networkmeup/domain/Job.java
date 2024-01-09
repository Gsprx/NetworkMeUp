package com.example.networkmeup.domain;


import java.io.Serializable;
import java.util.ArrayList;
import java.util.Objects;

/**
 * The Job class represents a job listing, containing details and requirements for a job position.
 */

// class Job implements Serializable for the ability to be passed through activities using Intent.putExtra method.
public class Job implements Serializable {
    private String title; // Title of the job
    private String description; // Description of the job
    private Availability availability = Availability.Available; // Availability status of the job
    private ArrayList<Application> applications; // List of applications for this job
    private ArrayList<Education> reqEducation; // List of required education for the job
    private ArrayList<WorkExperience> reqWorkExperience; // List of required work experience for the job
    private ArrayList<LanguageKnowledge> reqLanguageKnowledge; // List of required language knowledge for the job

    /**
     * Constructor to create a Job object with a specified title and description.
     * Initializes lists for applications, required education, work experience, and language knowledge.
     * @param title The title of the job.
     * @param description The description of the job.
     * @throws NullPointerException if the title or description is null.
     */
    public Job(String title, String description){
        validateData(title,description);
        applications = new ArrayList<>();
        reqEducation = new ArrayList<>();
        reqWorkExperience = new ArrayList<>();
        reqLanguageKnowledge = new ArrayList<>();
    }

    /**
     * Validates and sets the title and description for the job.
     * @param title The title of the job to validate and set.
     * @param description The description of the job to validate and set.
     * @throws NullPointerException if the title or description is null.
     */
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

    /**
     * Determines if a CV meets the requirements of this job.
     * @param cv The CV to be evaluated against the job requirements.
     * @return true if the CV meets all the job requirements, false otherwise.
     */
    public boolean acceptCV(CV cv){

        // Iterates through each required education for the job
        for(Education reqEducation : reqEducation){

            boolean found = false; // Initializes a flag to track if a matching or greater education is found

            // Iterates through each education in the applicant's CV
            for(Education applicantEducation : cv.getEducation()){
                // Compares the applicant's education against the required education
                if (applicantEducation.compare(reqEducation) >= 0){
                    found = true; // Sets the flag to true if a matching or greater education is found
                    break; // Breaks the loop as the requirement is met
                }
            }
            // If no matching or greater education is found, the CV is insufficient for this job requirement
            if (found == false){
                return false; // Returns false indicating insufficient education for this job requirement
            }
        }

        // Similar logic for checking required work experience and language knowledge

        // Iterates through each required work experience for the job
        for(WorkExperience reqWorkExperience : reqWorkExperience){

            boolean found = false; // Initializes a flag to track if a matching or greater work experience is found

            // Iterates through each work experience in the applicant's CV
            for(WorkExperience applicantWorkExperience : cv.getWorkExperiences()){
                // Compares the applicant's work experience against the required work experience
                if (applicantWorkExperience.compare(reqWorkExperience) >= 0){
                    found = true; // Sets the flag to true if a matching or greater work experience is found
                    break; // Breaks the loop as the requirement is met
                }
            }
            // If no matching or greater work experience is found, the CV is insufficient for this job requirement
            if (found == false){
                return false; // Returns false indicating insufficient work experience for this job requirement
            }
        }

        // Iterates through each required language knowledge for the job
        for(LanguageKnowledge reqLanguageKnowledge : reqLanguageKnowledge){

            boolean found = false; // Initializes a flag to track if a matching or greater language knowledge is found

            // Iterates through each language knowledge in the applicant's CV
            for(LanguageKnowledge applicantLanguageKnowledge : cv.getLanguageKnowledge()){
                // Compares the applicant's language knowledge against the required language knowledge
                if (applicantLanguageKnowledge.compare(reqLanguageKnowledge) >= 0){
                    found = true; // Sets the flag to true if a matching or greater language knowledge is found
                    break; // Breaks the loop as the requirement is met
                }
            }
            // If no matching or greater language knowledge is found, the CV is insufficient for this job requirement
            if (found == false){
                return false; // Returns false indicating insufficient language knowledge for this job requirement
            }
        }
        // Returns true if the CV satisfies all job requirements for education, work experience, and language knowledge
        return true;
    }

    /**
     * Validates if an object is null.
     * @param obj The object to be validated.
     * @throws NullPointerException if the object is null.
     */
    private void validateObject(Object obj){
        if (obj == null){
            throw new NullPointerException("Object cannot be null");
        }
        return;
    }

    /**
     * Adds required education for the job.
     * @param edu The required education to add.
     * @throws NullPointerException if the education is null.
     */
    public void addReqEducation (Education edu){
        validateObject(edu);
        this.reqEducation.add(edu);
    }

    /**
     * Adds required language knowledge to the job.
     * @param languageKnowledge The language knowledge required to be added.
     * @throws NullPointerException if the language knowledge is null.
     */
    public void addReqLanguageKnowledge(LanguageKnowledge languageKnowledge){
        validateObject(languageKnowledge);
        this.reqLanguageKnowledge.add(languageKnowledge);
    }

    /**
     * Adds required work experience to the job.
     * @param workExperience The work experience required to be added.
     * @throws NullPointerException if the work experience is null.
     */
    public void addReqWorkExperience(WorkExperience workExperience){
        validateObject(workExperience);
        this.reqWorkExperience.add(workExperience);
    }

    /**
     * Retrieves the title of the job.
     * @return The title of the job.
     */
    public String getTitle() {
        return title;
    }

    /**
     * Retrieves the description of the job.
     * @return The description of the job.
     */
    public String getDescription() {
        return description;
    }

    /**
     * Sets the availability status of the job.
     * @param availability The availability status to be set for the job.
     * @throws NullPointerException if the availability status is null.
     */
    public void setAvailability(Availability availability){
        validateObject(availability);
        this.availability = availability;
    }

    /**
     * Retrieves the availability status of the job.
     * @return The availability status of the job.
     */
    public Availability getAvailability() {
        return availability;
    }

    /**
     * Retrieves the list of applications for the job.
     * @return The list of applications for the job.
     */
    public ArrayList<Application> getApplications() {
        return applications;
    }

    /**
     * Adds an application to the list for this job.
     * @param application The application to be added for this job.
     * @throws NullPointerException if the application is null.
     */
    public void addApplication(Application application){
        validateObject(application);
        //replace an existing old application with a newer one if two applications have the same id
        applications.removeIf(appl -> Objects.equals(appl.getID(), application.getID()));
        this.applications.add(application);
    }

    /**
     * Retrieves the list of required education for the job.
     * @return The list of required education for the job.
     */
    public ArrayList<Education> getReqEducation() {
        return reqEducation;
    }

    /**
     * Retrieves the list of required work experiences for the job.
     * @return The list of required work experiences for the job.
     */
    public ArrayList<WorkExperience> getReqWorkExperience() {
        return reqWorkExperience;
    }

    /**
     * Retrieves the list of required language knowledge for the job.
     * @return The list of required language knowledge for the job.
     */
    public ArrayList<LanguageKnowledge> getReqLanguageKnowledge() {
        return reqLanguageKnowledge;
    }

    public void setTitle(String title) {
        validateObject(title);
        this.title = title;
    }

    public void setDescription(String description) {
        validateObject(description);
        this.description = description;
    }

    @Override
    public boolean equals(Object obj){
        Job job = (Job) obj;
        return job.getTitle().equals(this.getTitle()) && job.getDescription().equals(this.getDescription());
    }
}
