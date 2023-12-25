package com.example.networkmeup.domain;

import com.example.networkmeup.domain.Phone;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * PhoneTest class contains unit tests for validating the Phone class functionality.
 * These tests check various scenarios related to setting and validating phone numbers.
 */
public class PhoneTest {
    private Phone phone;

    /**
     * Sets up a Phone instance with an initial phone number before each test.
     */
    @Before
    public void setup(){
        phone = new Phone("6913242526");
    }

    /**
     * Verifies that setting a valid phone number updates the phone instance correctly.
     */
    @Test
    public void validNumberCheck(){
        phone.setNumber("8572659174");
        Assert.assertEquals("8572659174", phone.getNumber());
    }

    /**
     * Ensures that setting a null phone number throws a NullPointerException.
     */
    @Test
    public void nullPhoneCheck(){
        Assert.assertThrows(NullPointerException.class, ()->{phone.setNumber(null);});
    }

    /**
     * Checks if an IllegalArgumentException is thrown when the phone number has less than 10 digits.
     */
    @Test
    public void lessThan10DigitsCheck(){
        Assert.assertThrows(IllegalArgumentException.class, ()->{phone.setNumber("345682758");});
    }

    /**
     * Validates an IllegalArgumentException is thrown when the phone number has more than 10 digits.
     */
    @Test
    public void moreThan10DigitsCheck(){
        Assert.assertThrows(IllegalArgumentException.class, ()->{phone.setNumber("34568275866");});
    }

    /**
     * Verifies that an IllegalArgumentException is thrown when the phone number has an invalid first digit.
     */
    @Test
    public void invalidFirstNumberCheck(){
        Assert.assertThrows(IllegalArgumentException.class, ()->{phone.setNumber("0456827587");});
    }

}
