package com.example.networkmeup.domain;

import com.example.networkmeup.domain.ExpertiseArea;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * The ExpertiseAreaTest class contains unit tests for the ExpertiseArea class.
 * It aims to verify the functionalities and behaviors of the ExpertiseArea class methods.
 */
public class ExpertiseAreaTest {
    private ExpertiseArea expArea;

    /**
     * Initializing an ExpertiseArea instance before each test method execution.
     */
    @Before
    public void setup(){
        this.expArea = new ExpertiseArea("Test Area");
    }

    /**
     * Tests if setting the area of expertise of an ExpertiseArea instance to null throws a NullPointerException.
     */
    @Test
    public void nullAreaCheck(){
        Assert.assertThrows(NullPointerException.class, ()->{expArea.setArea(null);});
    }

    /**
     * Tests if setting a valid area of expertise updates the ExpertiseArea instance correctly.
     */
    @Test
    public void validAreaCheck(){
        expArea.setArea("Test Area 2");
        Assert.assertEquals("Test Area 2", expArea.getArea());
    }

    /**
     * Tests if two ExpertiseArea instances are equal when their areas of expertise are the same.
     */
    @Test
    public void equalsCheck(){
        ExpertiseArea expertiseArea2 = new ExpertiseArea("Test Area");
        Assert.assertEquals(true, expertiseArea2.equals(expArea));
    }

    /**
     * Tests if two ExpertiseArea instances are not equal when their areas of expertise are different.
     */
    @Test
    public void notEqualsCheck(){
        ExpertiseArea expertiseArea2 = new ExpertiseArea("Test Area 2");
        Assert.assertEquals(false, expertiseArea2.equals(expArea));
    }
}
