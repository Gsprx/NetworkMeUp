package com.example.networkmeup.dao;


import com.example.networkmeup.domain.*;


/**
 * Initializer class serves as an abstract base class for initializing data
 * related to employees and employers.
 */
public abstract class Initializer {

    /**
     * Abstract method to erase existing data from the data source.
     */
    protected abstract void eraseData();

    /**
     * Method to prepare initial employee and employer data by creating instances
     * and storing them in the respective data access objects (DAOs).
     */
    public void prepareData(){
        // Remove previous data
        eraseData();

        // Initialize initial employees and their related data
        EmployeeDAO employeeDAO = getEmployeeDAO();

        // Employee 1
        Employee employee1 = new Employee(new Email("john.Brown12@gmail.com"), new Phone("6977264561"), new Password("JohnBrown!12"));
        employee1.setName("John Brown");
        employee1.setAddress("2754 Washington Avenue,  Wiggins, Mississippi(MS), 39577");

        // Construct CV for employee 1
        CV cv1 = new CV();

        // Education details
        cv1.setEducation(new Education("Personal Studies", new ExpertiseArea("Finance"), LevelOfStudies.Amateur));
        cv1.setEducation(new Education("My personal High School education", new ExpertiseArea("Other"), LevelOfStudies.High_School));

        // Language knowledge
        cv1.setLanguageKnowledge(new LanguageKnowledge("Naitive language, was born in America", new Language("English"), LevelOfKnowledge.Native));

        // Work experience
        cv1.setWorkExperience(new WorkExperience(2,"Worked during my high school studies", new ExpertiseArea("Tourism")));
        cv1.setAdditionalSkillset("Have obtained teamwork experience from 4 years of professional sports");
        employee1.setCV(cv1);

        // Employee 2
        Employee employee2 = new Employee(new Email("marygreen.188@gmail.com"), new Phone("6953619405"), new Password("Mary878Green*"));
        employee2.setName("Mary Green");
        employee2.setAddress("4, avenue René Carre, 37 898 Salmon-sur-Voisin");

        // Construct CV for employee 2
        CV cv2 = new CV();

        // Education details
        cv2.setEducation(new Education("Bachelor's Degree", new ExpertiseArea("Psychology"), LevelOfStudies.Bachelor));
        cv2.setEducation(new Education("High School expertise degree", new ExpertiseArea("Human Studies"), LevelOfStudies.High_School));

        // Language knowledge
        cv2.setLanguageKnowledge(new LanguageKnowledge("Born and raised in France", new Language("French"), LevelOfKnowledge.Native));
        cv2.setLanguageKnowledge(new LanguageKnowledge("Learned english during my bachelor's studies", new Language("English"), LevelOfKnowledge.Advanced));

        // Add employees to EmployeeDAO
        employeeDAO.save(employee1);
        employeeDAO.save(employee2);




        // Initialize initial employers and their related data
        EmployerDAO employerDAO = getEmployerDAO();

        // Employer 1
        Employer employer1 = new Employer(new Email("b.be@northfreedom.com"), new Phone("5693311692"), new Password("UwL[;3{[fQP:"), new TIN("000001010"));
        employer1.setCompanyName("Philips Co.");
        employer1.setSector("Technology & Electronics");

        // Create a job posting for Employer 1
        Job job1 = new Job("Finance Office - Part Time", "We are hiring for our new Finance Office position at Philips. This job is part time employment, Mon-Fri 16.00-20.00");
        job1.addReqEducation(new Education("Minimum Finance education", new ExpertiseArea("Finance"), LevelOfStudies.High_School));
        job1.addReqLanguageKnowledge(new LanguageKnowledge("Minimum knowledge to work and cooperate properly", new Language("English"), LevelOfKnowledge.Advanced));
        job1.addReqWorkExperience(new WorkExperience(1,"Required work experience for this sector to achieve a harmonic implementation in our systems", new ExpertiseArea("Finance")));
        employer1.addJob(job1);

        // Add employers to EmployerDAO
        employerDAO.save(employer1);

        //Initialize Expertise Area Data to be used in the app.
        ExpertiseArea expAr1 = new ExpertiseArea("Finance");
        ExpertiseArea expAr2 = new ExpertiseArea("Computer Science");
        ExpertiseArea expAr3 = new ExpertiseArea("Other");
        ExpertiseArea expAr4 = new ExpertiseArea("Psychology");
        ExpertiseArea expAr5 = new ExpertiseArea("Tourism");
        ExpertiseArea expAr6 = new ExpertiseArea("Human Studies");
        ExpertiseArea expAr7 = new ExpertiseArea("Business Management");
        ExpertiseArea expAr8 = new ExpertiseArea("Agriculture");

        //add exp area data to our database
        ExpertiseAreaDAO expertiseAreaDAO = getExpertiseAreaDAO();
        expertiseAreaDAO.add(expAr1);
        expertiseAreaDAO.add(expAr2);
        expertiseAreaDAO.add(expAr3);
        expertiseAreaDAO.add(expAr4);
        expertiseAreaDAO.add(expAr5);
        expertiseAreaDAO.add(expAr6);
        expertiseAreaDAO.add(expAr7);
        expertiseAreaDAO.add(expAr8);
    }

    /**
     * Abstract method to get the EmployeeDAO instance.
     *
     * @return EmployeeDAO instance
     */
    public abstract EmployeeDAO getEmployeeDAO();

    /**
     * Abstract method to get the EmployerDAO instance.
     *
     * @return EmployerDAO instance
     */
    public abstract EmployerDAO getEmployerDAO();

    public abstract ExpertiseAreaDAO getExpertiseAreaDAO();
}
