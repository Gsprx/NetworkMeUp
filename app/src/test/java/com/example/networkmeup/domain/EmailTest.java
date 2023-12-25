package com.example.networkmeup.domain;

import com.example.networkmeup.domain.Email;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class EmailTest {
    private Email email;

    // Initializes an Email instance for testing purposes.
    @Before
    public void setup(){
        email = new Email("example@email.com");
    }

    // Tests if setting the address to null throws a NullPointerException.
    @Test
    public void nullEmailCheck(){
        Assert.assertThrows(NullPointerException.class, ()->{email.setAddress(null);});
    }

    // Validates if the setAddress method correctly updates the email address.
    @Test
    public void validEmailCheck(){
        email.setAddress("example.1@email1.com");
        Assert.assertEquals("example.1@email1.com", email.getAddress());
    }

    // Verifies that an IllegalArgumentException is thrown when the email address has nothing before the @ sign.
    @Test
    public void nothingBeforeAtSignCheck(){
        Assert.assertThrows(IllegalArgumentException.class, ()->{email.setAddress("@email.com");});
    }

    // Ensures that an IllegalArgumentException is thrown when the email address has nothing after the @ sign.
    @Test
    public void nothingAfterAtSignCheck(){
        Assert.assertThrows(IllegalArgumentException.class, ()->{email.setAddress("example@.com");});
    }

    // Checks if an IllegalArgumentException is thrown when the email address has no @ sign.
    @Test
    public void noAtSignCheck(){
        Assert.assertThrows(IllegalArgumentException.class, ()->{email.setAddress("example.email.com");});
    }

    // Tests if an IllegalArgumentException is thrown when the email address has an invalid character after the dot.
    @Test
    public void invalidAfterDotCheck(){
        Assert.assertThrows(IllegalArgumentException.class, ()->{email.setAddress("example@email.c");});
    }

    // Validates if an IllegalArgumentException is thrown when the email address has no dot.
    @Test
    public void noDotCheck(){
        Assert.assertThrows(IllegalArgumentException.class, ()->{email.setAddress("example@email");});
    }

    // Verifies that an IllegalArgumentException is thrown when the email address has an invalid character before the @ sign.
    @Test
    public void invalidCharacterBeforeAtSignCheck(){
        Assert.assertThrows(IllegalArgumentException.class, ()->{email.setAddress("exam!le@email.com");});
    }

    // Ensures that an IllegalArgumentException is thrown when the email address has an invalid character after the @ sign.
    @Test
    public void invalidCharacterAfterAtSignCheck(){
        Assert.assertThrows(IllegalArgumentException.class, ()->{email.setAddress("example@em@il.com");});
    }

    // Tests if an IllegalArgumentException is thrown when the email address has an invalid character after the dot.
    @Test
    public void invalidCharacterAfterDotCheck(){
        Assert.assertThrows(IllegalArgumentException.class, ()->{email.setAddress("example@email.c0m");});
    }
}
