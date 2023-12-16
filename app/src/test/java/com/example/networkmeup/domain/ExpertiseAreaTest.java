package com.example.networkmeup.domain;

import com.example.networkmeup.domain.ExpertiseArea;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class ExpertiseAreaTest {
    private ExpertiseArea expArea;

    @Before
    public void setup(){
        this.expArea = new ExpertiseArea("Test Area");
    }

    @Test
    public void nullAreaCheck(){
        Assert.assertThrows(NullPointerException.class, ()->{expArea.setArea(null);});
    }

    @Test
    public void validAreaCheck(){
        expArea.setArea("Test Area 2");
        Assert.assertEquals("Test Area 2", expArea.getArea());
    }
    @Test
    public void equalsCheck(){
        ExpertiseArea expertiseArea2 = new ExpertiseArea("Test Area");
        Assert.assertEquals(true, expertiseArea2.equals(expArea));
    }
    @Test
    public void notEqualsCheck(){
        ExpertiseArea expertiseArea2 = new ExpertiseArea("Test Area 2");
        Assert.assertEquals(false, expertiseArea2.equals(expArea));
    }
}
