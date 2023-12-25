package com.example.networkmeup.domain;

import com.example.networkmeup.domain.CV;
import com.example.networkmeup.domain.Education;
import com.example.networkmeup.domain.ExpertiseArea;
import com.example.networkmeup.domain.Language;
import com.example.networkmeup.domain.LanguageKnowledge;
import com.example.networkmeup.domain.LevelOfKnowledge;
import com.example.networkmeup.domain.LevelOfStudies;
import com.example.networkmeup.domain.WorkExperience;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class CVTest {
    private CV cv;

    // The @Before setup method initializes a CV instance for testing purposes.
    @Before
    public void setup(){
        cv = new CV();
    }

    // Tests if NullPointerException is thrown when setting null additional skillset.
    @Test
    public void nullAdditionalSkillsetCheck(){
        Assert.assertThrows(NullPointerException.class, ()->{
            cv.setAdditionalSkillset(null);
        });
    }

    // Checks if NullPointerException is thrown when setting null education.
    @Test
    public void nullEducationCheck(){
        Assert.assertThrows(NullPointerException.class, ()->{
            cv.setEducation(null);
        });
    }

    // Tests if NullPointerException is thrown when setting null work experience.
    @Test
    public void nullWorkExperienceCheck(){
        Assert.assertThrows(NullPointerException.class, ()->{
            cv.setWorkExperience(null);
        });
    }

    // Ensures that NullPointerException is thrown when setting null language knowledge.
    @Test
    public void nullLanguageKnowledgeCheck(){
        Assert.assertThrows(NullPointerException.class, ()->{
            cv.setLanguageKnowledge(null);
        });
    }

    // Validates if setAdditionalSkillset method correctly sets the additional skillset in CV.
    @Test
    public void validAdditionalSkillsetCheck(){
        cv.setAdditionalSkillset("Very cooperative");
        Assert.assertEquals("Very cooperative", cv.getAdditionalSkillset());
    }

    // Tests if setEducation method sets the education details correctly in the CV.
    @Test
    public void validEducationCheck(){
        Education edu = new Education("High School diploma", new ExpertiseArea("Economics"), LevelOfStudies.High_School);
        cv.setEducation(edu);
        Assert.assertEquals("High School diploma", cv.getEducation().get(0).getDescription());
    }

    // Verifies if setWorkExperience method sets the work experience details correctly in the CV.
    @Test
    public void validWorkExperienceCheck(){
        WorkExperience workExp = new WorkExperience(2, "Summer part time job", new ExpertiseArea("Serving"));
        cv.setWorkExperience(workExp);
        Assert.assertEquals("Summer part time job", cv.getWorkExperiences().get(0).getDescription());
    }

    // Validates if setLanguageKnowledge method sets the language knowledge details correctly in the CV.
    @Test
    public void validLanguageKnowledgeCheck(){
        LanguageKnowledge langKnow = new LanguageKnowledge("6 years of studies", new Language("French"), LevelOfKnowledge.Proficiency);
        cv.setLanguageKnowledge(langKnow);
        Assert.assertEquals("6 years of studies", cv.getLanguageKnowledge().get(0).getDescription());
    }
}
