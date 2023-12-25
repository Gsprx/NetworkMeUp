package com.example.networkmeup.domain;

import com.example.networkmeup.domain.ExpertiseArea;
import com.example.networkmeup.domain.WorkExperience;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * WorkExperienceTest class contains unit tests for validating the WorkExperience class functionality.
 * These tests cover various scenarios related to setting and validating work experience details.
 */
public class WorkExperienceTest {
    private WorkExperience workExp;

    /**
     * Sets up a WorkExperience instance with initial values before each test.
     */
    @Before
    public void setup(){
        ExpertiseArea expArea = new ExpertiseArea("Comp Sci");
        workExp = new WorkExperience(3, "Test Experience", expArea);
    }

    /**
     * Ensures that setting a null description for work experience throws a NullPointerException.
     */
    @Test
    public void nullDescCheck(){
        Assert.assertThrows(NullPointerException.class, ()->{
            workExp.setDescription(null);
        });
    }

    /**
     * Verifies that setting a null expertise area for work experience throws a NullPointerException.
     */
    @Test
    public void nullExpAreaCheck(){
        Assert.assertThrows(NullPointerException.class, ()->{
            workExp.setExpArea(null);
        });
    }

    /**
     * Validates that setting a negative value for work experience years throws an IllegalArgumentException.
     */
    @Test
    public void invalidYearsCheck(){
        Assert.assertThrows(IllegalArgumentException.class, ()->{
            ExpertiseArea expArea = new ExpertiseArea("Comp Sci 2");
            workExp.setYears(-4);
        });
    }

    /**
     * Verifies the correctness of the years of work experience.
     */
    @Test
    public void validYearsCheck(){
        Assert.assertEquals(3, workExp.getYears());
    }

    /**
     * Validates the correctness of the work experience description.
     */
    @Test
    public void validDescCheck(){
        Assert.assertEquals("Test Experience", workExp.getDescription());
    }

    /**
     * Verifies the correctness of the expertise area associated with the work experience.
     */
    @Test
    public void validExpAreaCheck(){
        Assert.assertEquals("Comp Sci", workExp.getExpArea().getArea());
    }

    /**
     * Checks if two WorkExperience instances with the same details are considered equal.
     */
    @Test
    public void equalsCheck(){
        ExpertiseArea expArea = new ExpertiseArea("Comp Sci");
        WorkExperience workExperience2 = new WorkExperience(3, "Test Experience", expArea);
        Assert.assertEquals(true, workExp.equals(workExperience2));
    }

    /**
     * Verifies inequality when comparing work experiences with different expertise areas.
     */
    @Test
    public void notEqualExpAreaCheck(){
        ExpertiseArea expArea = new ExpertiseArea("Physics");
        WorkExperience workExperience2 = new WorkExperience(3, "Test Experience", expArea);
        Assert.assertEquals(false, workExp.equals(workExperience2));
    }

    /**
     * Checks inequality when comparing work experiences with different years of experience.
     */
    @Test
    public void notEqualYearsCheck(){
        ExpertiseArea expArea = new ExpertiseArea("Comp Sci");
        WorkExperience workExperience2 = new WorkExperience(2, "Test Experience", expArea);
        Assert.assertEquals(false, workExp.equals(workExperience2));
    }
}
