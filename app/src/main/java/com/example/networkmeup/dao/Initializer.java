package com.example.networkmeup.dao;

import com.example.networkmeup.dao.EmployeeDAO;
import com.example.networkmeup.dao.EmployerDAO;
import com.example.networkmeup.domain.CV;
import com.example.networkmeup.domain.Education;
import com.example.networkmeup.domain.Email;
import com.example.networkmeup.domain.Employee;
import com.example.networkmeup.domain.Employer;
import com.example.networkmeup.domain.ExpertiseArea;
import com.example.networkmeup.domain.Job;
import com.example.networkmeup.domain.Language;
import com.example.networkmeup.domain.LanguageKnowledge;
import com.example.networkmeup.domain.LevelOfKnowledge;
import com.example.networkmeup.domain.LevelOfStudies;
import com.example.networkmeup.domain.Password;
import com.example.networkmeup.domain.Phone;
import com.example.networkmeup.domain.TIN;
import com.example.networkmeup.domain.WorkExperience;

import java.util.Date;


public abstract class Initializer {

    protected abstract void eraseData();

    public void prepareData(){
        //remove previous data
        eraseData();

        //construct initial employees and relative data
        EmployeeDAO employeeDAO = getEmployeeDAO();
            //employee 1
        Employee employee1 = new Employee(new Email("john.Brown12@gmail.com"), new Phone("6977264561"), new Password("JohnBrown!12"));
        employee1.setName("John Brown");
        employee1.setAddress("2754 Washington Avenue,  Wiggins, Mississippi(MS), 39577");
            //cv
        CV cv1 = new CV();
        cv1.setEducation(new Education("Personal Studies", new ExpertiseArea("Finance"), LevelOfStudies.Amateur));
        cv1.setEducation(new Education("My personal High School education", new ExpertiseArea("General Studies"), LevelOfStudies.High_School));
        cv1.setLanguageKnowledge(new LanguageKnowledge("Naitive language, was born in America", new Language("English"), LevelOfKnowledge.Naitive));
        cv1.setWorkExperience(new WorkExperience(2,"Worked during my high school studies", new ExpertiseArea("Tourism")));
        cv1.setAdditionalSkillset("Have obtained teamwork experience from 4 years of professional sports");
        employee1.setCV(cv1);
            //employee 2
        Employee employee2 = new Employee(new Email("marygreen.188@gmail.com"), new Phone("6953619405"), new Password("Mary878Green*"));
        employee2.setName("Mary Green");
        employee2.setAddress("4, avenue René Carre, 37 898 Salmon-sur-Voisin");
            //cv
        CV cv2 = new CV();
        cv2.setEducation(new Education("Bachelor's Degree", new ExpertiseArea("Psychology"), LevelOfStudies.Bachelor));
        cv2.setEducation(new Education("High School expertise degree", new ExpertiseArea("Human Studies"), LevelOfStudies.High_School));
        cv2.setLanguageKnowledge(new LanguageKnowledge("Born and raised in France", new Language("French"), LevelOfKnowledge.Naitive));
        cv2.setLanguageKnowledge(new LanguageKnowledge("Learned english during my bachelor's studies", new Language("English"), LevelOfKnowledge.Advanced));

        //add employees to DAO
        employeeDAO.save(employee1);
        employeeDAO.save(employee2);




        //construct initial employers and relative data
        EmployerDAO employerDAO = getEmployerDAO();
                //employer 1
        Employer employer1 = new Employer(new Email("b.be@northfreedom.com"), new Phone("5693311692"), new Password("UwL[;3{[fQP:"), new TIN("000001010"));
        employer1.setCompanyName("Philips Co.");
        employer1.setSector("Technology & Electronics");
                //job1
        Job job1 = new Job("Finance Office - Part Time", "We are hiring for our new Finance Office position at Philips. This job is part time employment, Mon-Fri 16.00-20.00");
        job1.addReqEducation(new Education("Minimum Finance education", new ExpertiseArea("Finance"), LevelOfStudies.High_School));
        job1.addReqLanguageKnowledge(new LanguageKnowledge("Minimum knowledge to work and cooperate properly", new Language("English"), LevelOfKnowledge.Advanced));
        job1.addReqWorkExperience(new WorkExperience(1,"Required work experience for this sector to achieve a harmonic implementation in our systems", new ExpertiseArea("Finance")));
        employer1.addJob(job1);

        //add employers to DAO
        employerDAO.save(employer1);

    }

    public abstract EmployeeDAO getEmployeeDAO();
    public abstract EmployerDAO getEmployerDAO();
}
