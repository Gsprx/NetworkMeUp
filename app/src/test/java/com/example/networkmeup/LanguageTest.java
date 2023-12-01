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

    @Test
    public void equalsCheck(){
        Language lang2 = new Language("Greek");
        Assert.assertEquals(true, lang.equals(lang2));
    }
    @Test
    public void notEqualsCheck(){
        Language lang2 = new Language("Spanish");
        Assert.assertEquals(false, lang.equals(lang2));
    }
}
