package com.example.networkmeup.domain;

/**
 * The LanguageKnowledge class represents knowledge about a particular language, including the description, language itself, and the level of knowledge.
 * It ensures validation, retrieval, and comparison of language knowledge information.
 */
public class LanguageKnowledge {
    private LevelOfKnowledge lvlOfKnowledge; // Represents the level of knowledge about the language
    private Language language; // Represents the language
    private String description; // Describes the language knowledge

    /**
     * Constructs a LanguageKnowledge object with the provided description, language, and level of knowledge.
     * @param description The description of language knowledge.
     * @param language The Language object representing the specific language.
     * @param lvlOfKnowledge The LevelOfKnowledge representing the knowledge level of the language.
     * @throws NullPointerException if any of the parameters (description, language, lvlOfKnowledge) is null.
     */
    public LanguageKnowledge (String description, Language language, LevelOfKnowledge lvlOfKnowledge){
        validateData(description, language, lvlOfKnowledge);
    }

    /**
     * Validates and sets the description, language, and level of knowledge.
     * @param description The description of language knowledge.
     * @param language The Language object representing the specific language.
     * @param lvlOfKnowledge The LevelOfKnowledge representing the knowledge level of the language.
     * @throws NullPointerException if any of the parameters (description, language, lvlOfKnowledge) is null.
     */
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
        this.description = description; // Sets the description of language knowledge
        this.language = language; // Sets the specific language
        this.lvlOfKnowledge = lvlOfKnowledge; // Sets the level of knowledge
    }

    /**
     * Retrieves the level of knowledge about the language.
     * @return The level of knowledge.
     */
    public LevelOfKnowledge getLvlOfKnowledge() {
        return lvlOfKnowledge;
    }

    /**
     * Sets the level of knowledge about the language.
     * @param lvlOfKnowledge The LevelOfKnowledge to be set.
     * @throws NullPointerException if the provided level of knowledge is null.
     */
    public void setLvlOfKnowledge(LevelOfKnowledge lvlOfKnowledge) {
        validateData(this.description, this.language, lvlOfKnowledge);
    }

    /**
     * Retrieves the language associated with this knowledge.
     * @return The Language object.
     */
    public Language getLanguage() {
        return language;
    }

    /**
     * Sets the language associated with this knowledge.
     * @param language The Language object to be set.
     * @throws NullPointerException if the provided language is null.
     */
    public void setLanguage(Language language) {
        validateData(this.description, language, this.lvlOfKnowledge);
    }

    /**
     * Retrieves the description of the language knowledge.
     * @return The description.
     */
    public String getDescription() {
        return description;
    }

    /**
     * Sets the description of the language knowledge.
     * @param description The description to be set.
     * @throws NullPointerException if the provided description is null.
     */
    public void setDescription(String description) {
        validateData(description, this.language, this.lvlOfKnowledge);
    }

    /**
     * Compares the language knowledge level of this LanguageKnowledge object with another LanguageKnowledge object.
     * @param languageKnowledge The LanguageKnowledge object to be compared.
     * @return 0 if equal, -2 if incomparable expertise areas, otherwise a value representing comparison result.
     */
    public int compare(LanguageKnowledge languageKnowledge){
        if(this.language.equals(languageKnowledge.language)){
            return Integer.compare(this.lvlOfKnowledge.ordinal(), languageKnowledge.lvlOfKnowledge.ordinal());
        }
        //return -2 if incomparable expertise areas.
        return -2;
    }

    /**
     * Checks equality between two LanguageKnowledge objects based on their language and knowledge level.
     * @param languageKnowledge The LanguageKnowledge object to compare.
     * @return true if the language and knowledge level are equal, false otherwise.
     */
    public boolean equals(LanguageKnowledge languageKnowledge){
        return (this.compare(languageKnowledge) == 0);
    }
}
