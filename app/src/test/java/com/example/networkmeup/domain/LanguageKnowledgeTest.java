package com.example.networkmeup.domain;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * LanguageKnowledgeTest class contains unit tests for the functionalities within the LanguageKnowledge class.
 * These tests ensure that the LanguageKnowledge class behaves as expected in different scenarios.
 */
public class LanguageKnowledgeTest {
    private LanguageKnowledge langKnow;

    /**
     * Sets up a LanguageKnowledge instance with initial values before each test.
     */
    @Before
    public void setup(){
        Language lang = new Language("Greek");
        langKnow = new LanguageKnowledge("Growing up in Greece", lang, LevelOfKnowledge.Native);
    }

    /**
     * Verifies that setting a null description throws a NullPointerException.
     */
    @Test
    public void nullDescCheck(){
        Assert.assertThrows(NullPointerException.class, ()->{langKnow.setDescription(null);});
    }

    /**
     * Ensures that setting a null language throws a NullPointerException.
     */
    @Test
    public void nullLangCheck(){
        Assert.assertThrows(NullPointerException.class, ()->{langKnow.setLanguage(null);});
    }

    /**
     * Validates that setting a null level of knowledge throws a NullPointerException.
     */
    @Test
    public void nullLvlOfKnowledgeCheck(){
        Assert.assertThrows(NullPointerException.class, ()->{langKnow.setLvlOfKnowledge(null);});
    }

    /**
     * Verifies the correctness of setting a valid description.
     */
    @Test
    public void validDescCheck(){
        langKnow.setDescription("Living in Greece for 20 years.");
        Assert.assertEquals("Living in Greece for 20 years.", langKnow.getDescription());
    }

    /**
     * Validates setting a valid language.
     */
    @Test
    public void validLanguageCheck(){
        Language lang = new Language("English");
        langKnow.setLanguage(lang);
        Assert.assertEquals("English", langKnow.getLanguage().getLanguage());
    }

    /**
     * Ensures setting a valid level of knowledge.
     */
    @Test
    public void validLvlOfKnowledgeCheck(){
        langKnow.setLvlOfKnowledge(LevelOfKnowledge.Advanced);
        Assert.assertEquals(LevelOfKnowledge.Advanced, langKnow.getLvlOfKnowledge());
    }

    /**
     * Verifies the equality between two LanguageKnowledge instances.
     */
    @Test
    public void equalsCheck(){
        Language lang = new Language("Greek");
        LanguageKnowledge languageKnowledge2 = new LanguageKnowledge("Studying for many years", lang, LevelOfKnowledge.Native);
        Assert.assertEquals(true, langKnow.equals(languageKnowledge2));
    }

    /**
     * Ensures inequality when comparing LanguageKnowledge instances with different languages.
     */
    @Test
    public void notEqualLangCheck(){
        Language lang = new Language("English");
        LanguageKnowledge languageKnowledge2 = new LanguageKnowledge("Growing up in Greece", lang, LevelOfKnowledge.Native);
        Assert.assertEquals(false, langKnow.equals(languageKnowledge2));
    }

    /**
     * Ensures inequality when comparing LanguageKnowledge instances with different levels of knowledge.
     */
    @Test
    public void notEqualLvlOfKnowledgeCheck(){
        Language lang = new Language("Greek");
        LanguageKnowledge languageKnowledge2 = new LanguageKnowledge("Growing up in Greece", lang, LevelOfKnowledge.Proficiency);
        Assert.assertEquals(false, langKnow.equals(languageKnowledge2));
    }
}
