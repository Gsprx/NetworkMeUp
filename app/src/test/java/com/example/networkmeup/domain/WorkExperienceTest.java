package com.example.networkmeup.domain;

import com.example.networkmeup.domain.ExpertiseArea;
import com.example.networkmeup.domain.WorkExperience;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class WorkExperienceTest {
    private WorkExperience workExp;

    @Before
    public void setup(){
        ExpertiseArea expArea = new ExpertiseArea("Comp Sci");
        workExp = new WorkExperience(3, "Test Experience", expArea);
    }

    @Test
    public void nullDescCheck(){
        Assert.assertThrows(NullPointerException.class, ()->{
            workExp.setDescription(null);
        });
    }

    @Test
    public void nullExpAreaCheck(){
        Assert.assertThrows(NullPointerException.class, ()->{
            workExp.setExpArea(null);
        });
    }

    @Test
    public void invalidYearsCheck(){
        Assert.assertThrows(IllegalArgumentException.class, ()->{
            ExpertiseArea expArea = new ExpertiseArea("Comp Sci 2");
            workExp.setYears(-4);
        });
    }

    @Test
    public void validYearsCheck(){
        Assert.assertEquals(3, workExp.getYears());
    }

    @Test
    public void validDescCheck(){
        Assert.assertEquals("Test Experience", workExp.getDescription());
    }

    @Test
    public void validExpAreaCheck(){
        Assert.assertEquals("Comp Sci", workExp.getExpArea().getArea());
    }
    @Test
    public void equalsCheck(){
        ExpertiseArea expArea = new ExpertiseArea("Comp Sci");
        WorkExperience workExperience2 = new WorkExperience(3, "Test Experience", expArea);
        Assert.assertEquals(true, workExp.equals(workExperience2));
    }

    @Test
    public void notEqualExpAreaCheck(){
        ExpertiseArea expArea = new ExpertiseArea("Physics");
        WorkExperience workExperience2 = new WorkExperience(3, "Test Experience", expArea);
        Assert.assertEquals(false, workExp.equals(workExperience2));
    }

    @Test
    public void notEqualYearsCheck(){
        ExpertiseArea expArea = new ExpertiseArea("Comp Sci");
        WorkExperience workExperience2 = new WorkExperience(2, "Test Experience", expArea);
        Assert.assertEquals(false, workExp.equals(workExperience2));
    }
}
