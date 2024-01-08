package com.example.networkmeup.daoMemory;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

import com.example.networkmeup.domain.Language;
import com.example.networkmeup.domain.LanguageKnowledge;

import java.util.ArrayList;

public class LanguageDaoMemoryTest {
    private LanguageDAOMemory languageDao;

    @Before
    public void setUp() {
        languageDao = new LanguageDAOMemory();
    }

    @Test
    public void testSaveAndFindLanguage() {
        Language language = new Language("English");
        assertFalse("Language should not be found before saving", languageDao.find(language));

        languageDao.save(language);
        assertTrue("Language should be found after saving", languageDao.find(language));
    }

    @Test
    public void testGetAll() {
        Language english = new Language("English");
        Language spanish = new Language("Spanish");

        languageDao.save(english);
        languageDao.save(spanish);

        ArrayList<Language> languages = languageDao.getAll();
        assertEquals("There should be 2 languages in the list", 2, languages.size());
        assertTrue("List should contain English", languages.contains(english));
        assertTrue("List should contain Spanish", languages.contains(spanish));
    }

    @Test
    public void testUniqueSave() {
        Language english1 = new Language("English");
        Language english2 = new Language("English");

        languageDao.save(english1);
        languageDao.save(english2); // This should not add because it's equivalent to english1

        assertEquals("There should only be 1 language after attempting to save two identical languages", 1, languageDao.getAll().size());
    }
}
