package com.example.networkmeup.domain;

import com.example.networkmeup.domain.TIN;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * TINTest class contains unit tests for validating the TIN (Tax Identification Number) class functionality.
 * These tests check various scenarios related to setting and validating TIN numbers.
 */
public class TINTest {
    private TIN tin;

    /**
     * Sets up a TIN instance with an initial TIN number before each test.
     */
    @Before
    public void setup(){
        tin = new TIN("094259216");
    }

    /**
     * Ensures that setting a null TIN number throws a NullPointerException.
     */
    @Test
    public void nullTINCheck(){
        Assert.assertThrows(NullPointerException.class, ()->{tin.setTin(null);});
    }

    /**
     * Verifies an IllegalArgumentException is thrown when the TIN number has more than 9 digits.
     */
    @Test
    public void moreThan9DigitsCheck(){
        Assert.assertThrows(IllegalArgumentException.class, ()->{tin.setTin("869275813");});
    }

    /**
     * Validates an IllegalArgumentException is thrown when the TIN number has less than 9 digits.
     */
    @Test
    public void lessThan9DigitsCheck(){
        Assert.assertThrows(IllegalArgumentException.class, ()->{tin.setTin("82758130");});
    }

    /**
     * Checks for an IllegalArgumentException when setting an invalid TIN number format.
     */
    @Test
    public void invalidTINCheck(){
        Assert.assertThrows(IllegalArgumentException.class, ()->{tin.setTin("123456789");});
    }

    /**
     * Verifies that setting a valid TIN number updates the TIN instance correctly.
     */
    @Test
    public void validTINCheck(){
        tin.setTin("000001010");
        Assert.assertEquals("000001010", tin.getTin());
    }
}
