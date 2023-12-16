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

    @Before
    public void setup(){
        cv = new CV();
    }

    @Test
    public void nullAdditionalSkillsetCheck(){
        Assert.assertThrows(NullPointerException.class, ()->{
            cv.setAdditionalSkillset(null);
        });
    }
    @Test
    public void nullEducationCheck(){
        Assert.assertThrows(NullPointerException.class, ()->{
            cv.setEducation(null);
        });
    }
    @Test
    public void nullWorkExperienceCheck(){
        Assert.assertThrows(NullPointerException.class, ()->{
            cv.setWorkExperience(null);
        });
    }

    @Test
    public void nullLanguageKnowledgeCheck(){
        Assert.assertThrows(NullPointerException.class, ()->{
            cv.setLanguageKnowledge(null);
        });
    }

    @Test
    public void validAdditionalSkillsetCheck(){
        cv.setAdditionalSkillset("Very cooperative");
        Assert.assertEquals("Very cooperative", cv.getAdditionalSkillset());
    }
    @Test
    public void validEducationCheck(){
        Education edu = new Education("High School diploma", new ExpertiseArea("Economics"), LevelOfStudies.High_School);
        cv.setEducation(edu);
        Assert.assertEquals("High School diploma", cv.getEducation().get(0).getDescription());
    }
    @Test
    public void validWorkExperienceCheck(){
        WorkExperience workExp = new WorkExperience(2, "Summer part time job", new ExpertiseArea("Serving"));
        cv.setWorkExperience(workExp);
        Assert.assertEquals("Summer part time job", cv.getWorkExperiences().get(0).getDescription());
    }
    @Test
    public void validLanguageKnowledgeCheck(){
        LanguageKnowledge langKnow = new LanguageKnowledge("6 years of studies", new Language("French"), LevelOfKnowledge.Proficiency);
        cv.setLanguageKnowledge(langKnow);
        Assert.assertEquals("6 years of studies", cv.getLanguageKnowledge().get(0).getDescription());
    }
}
