package com.example.networkmeup;

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
}
