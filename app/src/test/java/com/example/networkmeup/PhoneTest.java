package com.example.networkmeup;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class PhoneTest {
    private Phone phone;

    @Before
    public void setup(){
        phone = new Phone("6913242526");
    }
    @Test
    public void validNumberCheck(){
        phone.setNumber("8572659174");
        Assert.assertEquals("8572659174", phone.getNumber());
    }
    @Test
    public void nullPhoneCheck(){
        Assert.assertThrows(NullPointerException.class, ()->{phone.setNumber(null);});
    }

    @Test
    public void lessThan10DigitsCheck(){
        Assert.assertThrows(IllegalArgumentException.class, ()->{phone.setNumber("345682758");});
    }

    @Test
    public void moreThan10DigitsCheck(){
        Assert.assertThrows(IllegalArgumentException.class, ()->{phone.setNumber("34568275866");});
    }

    @Test
    public void invalidFirstNumberCheck(){
        Assert.assertThrows(IllegalArgumentException.class, ()->{phone.setNumber("0456827587");});
    }

}
