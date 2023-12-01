package com.example.networkmeup;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class LanguageTest {
    private Language lang;

    @Before
    public void setup(){
        lang = new Language("Greek");
    }

    @Test
    public void nullLangCheck(){
        Assert.assertThrows(NullPointerException.class, ()->{
            lang.setLanguage(null);
        });
    }
    @Test
    public void validLangCheck(){
        lang.setLanguage("English");
        Assert.assertEquals("English", lang.getLanguage());
    }
}
