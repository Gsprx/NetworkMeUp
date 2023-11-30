package com.example.networkmeup;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class WorkExperienceTest {
    private WorkExperience workExp;

    @Before
    public void setup(){
        workExp = new WorkExperience(3, "Test Experience");
    }

    @Test
    public void nullDescCheck(){
        Assert.assertThrows(NullPointerException.class, ()->{workExp = new WorkExperience(3,null);});
    }

    @Test
    public void invalidYearsCheck(){
        Assert.assertThrows(IllegalArgumentException.class, ()->{workExp = new WorkExperience(-1, "Test Desc1");});
    }

    @Test
    public void validYearsCheck(){
        workExp = new WorkExperience(15, "Test Experience 2");
        Assert.assertEquals(15, workExp.getYears());
    }

    @Test
    public void validDescCheck(){
        workExp = new WorkExperience(15, "Test Experience 2");
        Assert.assertEquals("Test Experience 2", workExp.getDescription());
    }
}
