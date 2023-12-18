package com.example.networkmeup.domain;

import com.example.networkmeup.domain.Language;
import com.example.networkmeup.domain.LanguageKnowledge;
import com.example.networkmeup.domain.LevelOfKnowledge;

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

    @Test
    public void equalsCheck(){
        Language lang = new Language("Greek");
        LanguageKnowledge languageKnowledge2 = new LanguageKnowledge("Studying for many years", lang, LevelOfKnowledge.Naitive);
        Assert.assertEquals(true, langKnow.equals(languageKnowledge2));
    }

    @Test
    public void notEqualLangCheck(){
        Language lang = new Language("English");
        LanguageKnowledge languageKnowledge2 = new LanguageKnowledge("Growing up in Greece", lang, LevelOfKnowledge.Naitive);
        Assert.assertEquals(false, langKnow.equals(languageKnowledge2));
    }
    @Test
    public void notEqualLvlOfKnowledgeCheck(){
        Language lang = new Language("Greek");
        LanguageKnowledge languageKnowledge2 = new LanguageKnowledge("Growing up in Greece", lang, LevelOfKnowledge.Proficiency);
        Assert.assertEquals(false, langKnow.equals(languageKnowledge2));
    }
}