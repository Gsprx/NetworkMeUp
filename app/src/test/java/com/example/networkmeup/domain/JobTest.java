package com.example.networkmeup.domain;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * The JobTest class contains unit tests for the Job class.
 * It validates the functionalities and behaviors of Job methods.
 */
public class JobTest {
    private Job job;

    /**
     * Initializing a Job instance before each test method execution.
     */
    @Before
    public void setup(){
        // Creating a Job instance and adding required qualifications for testing.
        job = new Job("Test Job title", "This job is a test job, used for ... testing.");
        Education requiredEducation1 = new Education("required education1", new ExpertiseArea("Comp Sci"), LevelOfStudies.Bachelor);
        WorkExperience requiredWorkExperience1 = new WorkExperience(4, "Working at 'Test' Company CFO", new ExpertiseArea("Finance"));
        LanguageKnowledge requiredLanguageKnowledge1 = new LanguageKnowledge("after school studies", new Language("French"), LevelOfKnowledge.Lower);
        job.addReqEducation(requiredEducation1);
        job.addReqWorkExperience(requiredWorkExperience1);
        job.addReqLanguageKnowledge(requiredLanguageKnowledge1);
    }

    /**
     * Tests if adding null required education throws a NullPointerException.
     */
    @Test
    //this check works for all requirement addition methods.
    public void nullRequirementCheck(){
        Assert.assertThrows(NullPointerException.class, ()->{
           job.addReqEducation(null);
        });
    }

    /**
     * Verifies if adding a valid required education works correctly.
     */
    @Test
    public void validReqEducationCheck(){
        job.addReqEducation(new Education("second req education", new ExpertiseArea("Tourism"),LevelOfStudies.Amateur));
        Assert.assertEquals("Tourism", job.getReqEducation().get(1).getExpArea().getArea());
    }

    /**
     * Ensures that adding a valid required work experience functions as expected.
     */
    @Test
    public void validReqWorkExperienceCheck(){
        job.addReqWorkExperience(new WorkExperience(7, "family business", new ExpertiseArea("Serving")));
        Assert.assertEquals("Serving", job.getReqWorkExperience().get(1).getExpArea().getArea());
    }

    /**
     * Tests the addition of valid required language knowledge.
     */
    @Test
    public void validReqLanguageKnowledgeCheck(){
        job.addReqLanguageKnowledge(new LanguageKnowledge("self taught", new Language("Japanese"), LevelOfKnowledge.Amateur));
        Assert.assertEquals("Japanese", job.getReqLanguageKnowledge().get(1).getLanguage().getLanguage());
    }

    /**
     * Tests if a CV with sufficient qualifications is accepted for the job.
     */
    @Test
    public void acceptCVCheck(){
        // cv is more than sufficient and should be accepted.
        CV cv = new CV();
        cv.setEducation(new Education("cv education1", new ExpertiseArea("Comp Sci"), LevelOfStudies.Bachelor));
        cv.setEducation(new Education("cv education2", new ExpertiseArea("Cooking"), LevelOfStudies.Amateur));
        cv.setWorkExperience(new WorkExperience(5, "Working at 'Test' Company CFO", new ExpertiseArea("Finance")));
        cv.setLanguageKnowledge(new LanguageKnowledge("after school studies", new Language("French"), LevelOfKnowledge.Advanced));

        Assert.assertEquals(true, job.acceptCV(cv));
    }

    /**
     * Ensures that a Curriculum Vitae (CV) with different expertise/language fields is rejected.
     */
    @Test
    public void rejectNotMatchingCVCheck(){
        // amount/level of education/experiences/knowledge matches but some fields of expertise/language are different and thus not accepted.
        CV cv = new CV();
        cv.setEducation(new Education("cv education1", new ExpertiseArea("Comp Sci"), LevelOfStudies.Bachelor));
        cv.setWorkExperience(new WorkExperience(4, "Working at 'Test' Company CFO", new ExpertiseArea("Health Care")));
        cv.setLanguageKnowledge(new LanguageKnowledge("after school studies", new Language("German"), LevelOfKnowledge.Lower));

        Assert.assertEquals(false, job.acceptCV(cv));
    }

    /**
     * Validates rejection when the education level in the CV is insufficient.
     */
    @Test
    public void rejectInsufficientEducationCVCheck(){
        // expertise fields match but not enough education level.
        CV cv = new CV();
        cv.setEducation(new Education("cv education1", new ExpertiseArea("Comp Sci"), LevelOfStudies.High_School));
        cv.setWorkExperience(new WorkExperience(4, "Working at 'Test' Company CFO", new ExpertiseArea("Finance")));
        cv.setLanguageKnowledge(new LanguageKnowledge("after school studies", new Language("French"), LevelOfKnowledge.Lower));

        Assert.assertEquals(false, job.acceptCV(cv));
    }

    /**
     * Validates rejection when the work experience in the CV is insufficient.
     */
    @Test
    public void rejectInsufficientWorkExperienceCVCheck(){
        // expertise fields match but not enough work experience years.
        CV cv = new CV();
        cv.setEducation(new Education("cv education1", new ExpertiseArea("Comp Sci"), LevelOfStudies.Bachelor));
        cv.setWorkExperience(new WorkExperience(3, "Working at 'Test' Company CFO", new ExpertiseArea("Finance")));
        cv.setLanguageKnowledge(new LanguageKnowledge("after school studies", new Language("French"), LevelOfKnowledge.Lower));

        Assert.assertEquals(false, job.acceptCV(cv));
    }

    /**
     * Verifies rejection when the language knowledge in the CV is insufficient.
     */
    @Test
    public void rejectInsufficientLanguageKnowledgeCVCheck(){
        // expertise fields match but not enough languange knowledge
        CV cv = new CV();
        cv.setEducation(new Education("cv education1", new ExpertiseArea("Comp Sci"), LevelOfStudies.Bachelor));
        cv.setWorkExperience(new WorkExperience(4, "Working at 'Test' Company CFO", new ExpertiseArea("Finance")));
        cv.setLanguageKnowledge(new LanguageKnowledge("after school studies", new Language("French"), LevelOfKnowledge.Amateur));

        Assert.assertEquals(false, job.acceptCV(cv));
    }

    /**
     * Validates the correctness of the job title.
     */
    @Test
    public void validTitleCheck(){
        Assert.assertEquals("Test Job title", job.getTitle());
    }

    /**
     * Validates the correctness of the job description.
     */
    @Test
    public void validDescCheck(){
        Assert.assertEquals("This job is a test job, used for ... testing.", job.getDescription());
    }

    /**
     * Verifies if constructing a job with a null title throws a NullPointerException.
     */
    @Test
    public void nullTitleConstructionCheck(){
        Assert.assertThrows(NullPointerException.class, ()->{
           job = new Job(null, "Description Test");
        });
    }

    /**
     * Ensures constructing a job with a null description throws a NullPointerException.
     */
    @Test
    public void nullDescriptionConstructionCheck(){
        Assert.assertThrows(NullPointerException.class, ()->{
            job = new Job("Test Title", null);
        });
    }

    /**
     * Validates if setting availability to null throws a NullPointerException.
     */
    @Test
    public void nullAvailabilityCheck(){
        Assert.assertThrows(NullPointerException.class, ()->{
            job.setAvailability(null);
        });
    }

    /**
     * Ensures setting a valid availability works as expected.
     */
    @Test
    public void validAvailabilityCheck(){
        job.setAvailability(Availability.Temporarily_Unavailable);
        Assert.assertEquals(Availability.Temporarily_Unavailable, job.getAvailability());
    }

    /**
     * Verifies the correctness of adding a job application.
     */
    @Test
    public void validApplicationCheck(){
        Application app = new Application(new Employee(new Email("employ@example.com"),
                new Phone("5658274859"), new Password("Test1234!")), "cover letter test");
        job.addApplication(app);

        Assert.assertEquals("employ@example.com", job.getApplications().get(0).getEmployee().getEmail().getAddress());
    }

    /**
     * Ensures adding a null application throws a NullPointerException.
     */
    @Test
    public void nullApplicationCheck(){
        Assert.assertThrows(NullPointerException.class, ()->{
            job.addApplication(null);
        });
    }

}
