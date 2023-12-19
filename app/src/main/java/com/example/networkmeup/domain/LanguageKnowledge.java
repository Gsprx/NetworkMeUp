package com.example.networkmeup.domain;

public class LanguageKnowledge {
    private LevelOfKnowledge lvlOfKnowledge;
    private Language language;
    private String description;


    public LanguageKnowledge (String description, Language language, LevelOfKnowledge lvlOfKnowledge){
        validateData(description, language, lvlOfKnowledge);
    }
    private void validateData(String description, Language language, LevelOfKnowledge lvlOfKnowledge){
        if(description == null){
            throw new NullPointerException("Description cannot be empty.");
        }
        if(language == null){
            throw new NullPointerException("Language cannot be empty.");
        }
        if(lvlOfKnowledge == null){
            throw new NullPointerException("Level of knowledge cannot be empty.");
        }
        this.description = description;
        this.language = language;
        this.lvlOfKnowledge = lvlOfKnowledge;
    }

    public LevelOfKnowledge getLvlOfKnowledge() {
        return lvlOfKnowledge;
    }

    public void setLvlOfKnowledge(LevelOfKnowledge lvlOfKnowledge) {
        validateData(this.description, this.language, lvlOfKnowledge);
    }

    public Language getLanguage() {
        return language;
    }

    public void setLanguage(Language language) {
        validateData(this.description, language, this.lvlOfKnowledge);
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        validateData(description, this.language, this.lvlOfKnowledge);
    }

    public int compare(LanguageKnowledge languageKnowledge){
        if(this.language.equals(languageKnowledge.language)){
            return Integer.compare(this.lvlOfKnowledge.ordinal(), languageKnowledge.lvlOfKnowledge.ordinal());
        }
        //return -2 if incomperable expertise areas.
        return -2;
    }

    public boolean equals(LanguageKnowledge languageKnowledge){
        return (this.compare(languageKnowledge) == 0);
    }
}
