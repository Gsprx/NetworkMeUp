package com.example.networkmeup.domain;

import com.example.networkmeup.domain.Language;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * LanguageTest class contains unit tests for the functionalities within the Language class.
 * These tests ensure that the Language class behaves as expected in different scenarios.
 */
public class LanguageTest {
    private Language lang;

    /**
     * Sets up a Language instance with initial values before each test.
     */
    @Before
    public void setup(){
        lang = new Language("Greek");
    }

    /**
     * Verifies that setting a null language throws a NullPointerException.
     */
    @Test
    public void nullLangCheck(){
        Assert.assertThrows(NullPointerException.class, ()->{
            lang.setLanguage(null);
        });
    }

    /**
     * Validates the correctness of setting a valid language.
     */
    @Test
    public void validLangCheck(){
        lang.setLanguage("English");
        Assert.assertEquals("English", lang.getLanguage());
    }

    /**
     * Verifies the equality between two Language instances.
     */
    @Test
    public void equalsCheck(){
        Language lang2 = new Language("Greek");
        Assert.assertEquals(true, lang.equals(lang2));
    }

    /**
     * Ensures inequality when comparing Language instances with different languages.
     */
    @Test
    public void notEqualsCheck(){
        Language lang2 = new Language("Spanish");
        Assert.assertEquals(false, lang.equals(lang2));
    }

    @Test
    public void testCompareTo() {
        // Creating Language objects with different language names
        Language lang1 = new Language("English");
        Language lang2 = new Language("Spanish");
        Language lang3 = new Language("English");

        // Checking comparisons between Language objects
        Assert.assertTrue(lang1.compareTo(lang2) < 0); // "English" < "Spanish"
        Assert.assertTrue(lang2.compareTo(lang1) > 0); // "Spanish" > "English"
        Assert.assertEquals(0, lang1.compareTo(lang3)); // "English" = "English"
    }
}
