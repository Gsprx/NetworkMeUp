package com.example.networkmeup.daoMemory;

import com.example.networkmeup.dao.LanguageDAO;
import com.example.networkmeup.domain.Language;

import java.util.ArrayList;
import java.util.Collections;
public class LanguageDAOMemory implements LanguageDAO{

    private static ArrayList<Language> languages;

    public LanguageDAOMemory(){
        if(languages==null){
            languages = new ArrayList<>();
        }
    }

    @Override
    public ArrayList<Language> getAll() {
        return new ArrayList<Language>(languages);
    }

    @Override
    public void save(Language language) {
        if (!find(language)){
            languages.add(language);
            Collections.sort(languages);
        }
    }



    @Override
    public boolean find(Language language) {
        for(Language lang : languages){
            if(lang.equals(language)){
                return true;
            }
        }
        return false;
    }

    @Override
    public void delete(Language language) {
        languages.remove(language);
    }
}
