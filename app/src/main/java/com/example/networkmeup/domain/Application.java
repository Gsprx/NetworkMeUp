package com.example.networkmeup.domain;

public class Application {
    private Employee applicant;
    private static Integer classCount = 0;
    private Integer ID;
    private boolean status;
    private String coverLetter;


    public Application(Employee applicant, String coverLetter){
        validateData(applicant, coverLetter);
        this.applicant = applicant;
        this.coverLetter = coverLetter;
        classCount++;
        this.ID = classCount;
    }

    private void validateData(Employee employee, String coverLetter){
        if(employee == null){
            throw new NullPointerException("Employee field cannot be null.");
        }
        if(coverLetter == null){
            throw new NullPointerException("Cover letter field cannot be null.");
        }
        return;
    }
    public boolean getStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public Employee getEmployee() {
        return applicant;
    }

    public Integer getID() {
        return ID;
    }


    //ONLY FOR TESTING PURPOSES!!!
    public void setID(Integer id){
        this.ID = id;
    }
    //ONLY FOR TESTING PURPOSES!!!

    public String getCoverLetter() {
        return coverLetter;
    }
}
