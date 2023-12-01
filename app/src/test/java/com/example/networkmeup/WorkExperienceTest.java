package com.example.networkmeup;

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
}
