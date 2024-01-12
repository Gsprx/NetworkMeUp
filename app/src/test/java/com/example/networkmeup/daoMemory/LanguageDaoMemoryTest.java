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
        new MemoryInitializer().prepareData();
    }

    @Test
    public void testSaveAndFindLanguage() {
        Language language = new Language("Barbarian");
        assertFalse("Language should not be found before saving", languageDao.find(language));

        languageDao.save(language);
        assertTrue("Language should be found after saving", languageDao.find(language));
        languageDao.delete(language);
    }

    @Test
    public void testGetAll() {
        Language gibberish = new Language("Gibberish");
        Language mandarin = new Language("Mandarin");

        languageDao.save(gibberish);
        languageDao.save(mandarin);

        ArrayList<Language> languages = languageDao.getAll();
        // There should be 3 languages on the list after the previous add and the previous test
        assertEquals("There should be 9 languages in the list", 9, languages.size());
        assertTrue("List should contain Gibberish", languages.contains(gibberish));
        assertTrue("List should contain Mandarin", languages.contains(mandarin));
        languageDao.delete(gibberish);
        languageDao.delete(mandarin);
    }

}
