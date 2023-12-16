package com.example.networkmeup.domain;

import com.example.networkmeup.domain.TIN;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class TINTest {
    private TIN tin;

    @Before
    public void setup(){
        tin = new TIN("094259216");
    }

    @Test
    public void nullTINCheck(){
        Assert.assertThrows(NullPointerException.class, ()->{tin.setTin(null);});
    }

    @Test
    public void moreThan9DigitsCheck(){
        Assert.assertThrows(IllegalArgumentException.class, ()->{tin.setTin("869275813");});
    }

    @Test
    public void lessThan9DigitsCheck(){
        Assert.assertThrows(IllegalArgumentException.class, ()->{tin.setTin("82758130");});
    }

    @Test
    public void invalidTINCheck(){
        Assert.assertThrows(IllegalArgumentException.class, ()->{tin.setTin("123456789");});
    }

    @Test
    public void validTINCheck(){
        tin.setTin("000001010");
        Assert.assertEquals("000001010", tin.getTin());
    }
}
