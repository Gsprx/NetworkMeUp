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
        Language language = new Language("Barbarian");
        assertFalse("Language should not be found before saving", languageDao.find(language));

        languageDao.save(language);
        assertTrue("Language should be found after saving", languageDao.find(language));
    }

    @Test
    public void testGetAll() {
        Language gibberish = new Language("Gibberish");
        Language mandarin = new Language("Mandarin");

        languageDao.save(gibberish);
        languageDao.save(mandarin);

        ArrayList<Language> languages = languageDao.getAll();
        // There should be 3 languages on the list after the previous add and the previous test
        assertEquals("There should be 3 languages in the list", 3, languages.size());
        assertTrue("List should contain Gibberish", languages.contains(gibberish));
        assertTrue("List should contain Mandarin", languages.contains(mandarin));
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
