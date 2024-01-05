package com.example.networkmeup.dao;

import com.example.networkmeup.domain.Language;

import java.util.ArrayList;

public interface LanguageDAO {

    public ArrayList<Language> getAll();
    public void save(Language language);
    public boolean find(Language language);
}
