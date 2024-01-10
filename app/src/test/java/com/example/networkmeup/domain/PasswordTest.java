package com.example.networkmeup.domain;

import com.example.networkmeup.domain.InsufficientPasswordException;
import com.example.networkmeup.domain.Password;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * PasswordTest class contains unit tests for validating the Password class functionality.
 * These tests check various scenarios related to setting and validating passwords.
 */
public class PasswordTest {
    private Password pwd;

    /**
     * Sets up a Password instance with an initial password value before each test.
     */
    @Before
    public void setup(){
        pwd = new Password("Test123@");
    }

    /**
     * Verifies that setting a null password throws a NullPointerException.
     */
    @Test
    public void nullPasswordCheck(){
        Assert.assertThrows(NullPointerException.class, ()->{pwd.setPassword(null);});
    }

    /**
     * Ensures an InsufficientPasswordException is thrown when the password lacks special characters.
     */
    @Test
    public void notEnoughSpecialCharactersCheck(){
        Assert.assertThrows(InsufficientPasswordException.class, ()->{pwd.setPassword("Test12345");});
    }

    /**
     * Validates an InsufficientPasswordException is thrown when the password lacks numbers.
     */
    @Test
    public void notEnoughNumbersCheck(){
        Assert.assertThrows(InsufficientPasswordException.class, ()->{pwd.setPassword("Testttasf!");});
    }

    /**
     * Checks if an InsufficientPasswordException is thrown when the password lacks capital letters.
     */
    @Test
    public void notEnoughCapitalLettersCheck(){
        Assert.assertThrows(InsufficientPasswordException.class, ()->{pwd.setPassword("test12345@");});
    }

    /**
     * Validates an InsufficientPasswordException is thrown when the password lacks lowercase letters.
     */
    @Test
    public void notEnoughLowercaseLettersCheck(){
        Assert.assertThrows(InsufficientPasswordException.class, ()->{pwd.setPassword("TEST12345@");});
    }

    /**
     * Verifies an InsufficientPasswordException is thrown when the password has less than 8 characters.
     */
    @Test
    public void lessThan8CharactersCheck(){
        Assert.assertThrows(InsufficientPasswordException.class, ()->{pwd.setPassword("Test12!");});
    }

    /**
     * Ensures an IllegalArgumentException is thrown when the password exceeds 24 characters.
     */
    @Test
    public void moreThan24CharactersCheck(){
        Assert.assertThrows(IllegalArgumentException.class, ()->{pwd.setPassword("Test12!Ag845^42afk14%85mFl");});
    }

    /**
     * Validates the correctness of setting a valid password.
     */
    @Test
    public void validSetCheck(){
        pwd.setPassword("12345Test123!");
        Assert.assertEquals("12345Test123!", pwd.getPassword());
    }

    @Test
    public void testEquals() {
        // Creating Password objects with different password strings
        Password pass1 = new Password("SecurePassword123!");
        Password pass2 = new Password("AnotherPassword456!");
        Password pass3 = new Password("SecurePassword123!");

        // Checking equality between Password objects
        Assert.assertTrue(pass1.equals(pass3)); // Pass1 equals Pass3
        Assert.assertFalse(pass1.equals(pass2)); // Pass1 not equals Pass2
    }
}
