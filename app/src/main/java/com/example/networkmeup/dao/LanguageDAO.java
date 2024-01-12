package com.example.networkmeup.dao;

import com.example.networkmeup.domain.Language;

import java.util.ArrayList;

/**
 * Language interface outlines the methods that should be implemented by classes
 * responsible for handling Language data access operations.
 */
public interface LanguageDAO {

    public ArrayList<Language> getAll();
    public void save(Language language);
    public boolean find(Language language);
}
