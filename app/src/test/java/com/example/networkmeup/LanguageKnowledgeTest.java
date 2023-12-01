package com.example.networkmeup;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class LanguageKnowledgeTest {
    private LanguageKnowledge langKnow;

    @Before
    public void setup(){
        Language lang = new Language("Greek");
        langKnow = new LanguageKnowledge("Growing up in Greece", lang, LevelOfKnowledge.Naitive);
    }

    @Test
    public void nullDescCheck(){
        Assert.assertThrows(NullPointerException.class, ()->{langKnow.setDescription(null);});
    }
    @Test
    public void nullLangCheck(){
        Assert.assertThrows(NullPointerException.class, ()->{langKnow.setLanguage(null);});
    }

    @Test
    public void nullLvlOfKnowledgeCheck(){
        Assert.assertThrows(NullPointerException.class, ()->{langKnow.setLvlOfKnowledge(null);});
    }

    @Test
    public void validDescCheck(){
        langKnow.setDescription("Living in Greece for 20 years.");
        Assert.assertEquals("Living in Greece for 20 years.", langKnow.getDescription());
    }

    @Test
    public void validLanguageCheck(){
        Language lang = new Language("English");
        langKnow.setLanguage(lang);
        Assert.assertEquals("English", langKnow.getLanguage().getLanguage());
    }

    @Test
    public void validLvlOfKnowledgeCheck(){
        langKnow.setLvlOfKnowledge(LevelOfKnowledge.Advanced);
        Assert.assertEquals(LevelOfKnowledge.Advanced, langKnow.getLvlOfKnowledge());
    }
}
