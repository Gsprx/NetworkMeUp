package com.example.networkmeup.domain;

import com.example.networkmeup.domain.InsufficientPasswordException;
import com.example.networkmeup.domain.Password;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class PasswordTest {
    private Password pwd;

    @Before
    public void setup(){
        pwd = new Password("Test123@");
    }

    @Test
    public void nullPasswordCheck(){
        Assert.assertThrows(NullPointerException.class, ()->{pwd.setPassword(null);});
    }

    @Test
    public void notEnoughSpecialCharactersCheck(){
        Assert.assertThrows(InsufficientPasswordException.class, ()->{pwd.setPassword("Test12345");});
    }

    @Test
    public void notEnoughNumbersCheck(){
        Assert.assertThrows(InsufficientPasswordException.class, ()->{pwd.setPassword("Testttasf!");});
    }

    @Test
    public void notEnoughCapitalLettersCheck(){
        Assert.assertThrows(InsufficientPasswordException.class, ()->{pwd.setPassword("test12345@");});
    }

    @Test
    public void notEnoughLowercaseLettersCheck(){
        Assert.assertThrows(InsufficientPasswordException.class, ()->{pwd.setPassword("TEST12345@");});
    }

    @Test
    public void lessThan8CharactersCheck(){
        Assert.assertThrows(InsufficientPasswordException.class, ()->{pwd.setPassword("Test12!");});
    }

    @Test
    public void validSetCheck(){
        pwd.setPassword("12345Test123!");
        Assert.assertEquals("12345Test123!", pwd.getPassword());
    }
}
