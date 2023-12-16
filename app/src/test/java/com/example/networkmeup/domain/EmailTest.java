package com.example.networkmeup.domain;

import com.example.networkmeup.domain.Email;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class EmailTest {
    private Email email;

    @Before
    public void setup(){
        email = new Email("example@email.com");
    }
    @Test
    public void nullEmailCheck(){
        Assert.assertThrows(NullPointerException.class, ()->{email.setAddress(null);});
    }

    @Test
    public void validEmailCheck(){
        email.setAddress("example.1@email1.com");
        Assert.assertEquals("example.1@email1.com", email.getAddress());
    }

    @Test
    public void nothingBeforeAtSignCheck(){
        Assert.assertThrows(IllegalArgumentException.class, ()->{email.setAddress("@email.com");});
    }

    @Test
    public void nothingAfterAtSignCheck(){
        Assert.assertThrows(IllegalArgumentException.class, ()->{email.setAddress("example@.com");});
    }

    @Test
    public void noAtSignCheck(){
        Assert.assertThrows(IllegalArgumentException.class, ()->{email.setAddress("example.email.com");});
    }

    @Test
    public void invalidAfterDotCheck(){
        Assert.assertThrows(IllegalArgumentException.class, ()->{email.setAddress("example@email.c");});
    }

    @Test
    public void noDotCheck(){
        Assert.assertThrows(IllegalArgumentException.class, ()->{email.setAddress("example@email");});
    }

    @Test
    public void invalidCharacterBeforeAtSignCheck(){
        Assert.assertThrows(IllegalArgumentException.class, ()->{email.setAddress("exam!le@email.com");});
    }

    @Test
    public void invalidCharacterAfterAtSignCheck(){
        Assert.assertThrows(IllegalArgumentException.class, ()->{email.setAddress("example@em@il.com");});
    }

    @Test
    public void invalidCharacterAfterDotCheck(){
        Assert.assertThrows(IllegalArgumentException.class, ()->{email.setAddress("example@email.c0m");});
    }
}
