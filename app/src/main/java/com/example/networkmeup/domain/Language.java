package com.example.networkmeup.domain;

import java.io.Serializable;

/**
 * The Language class represents a language entity with its name.
 * It ensures the validation and retrieval of language information.
 */
public class Language implements Comparable<Language>, Serializable {
    private String language; // Represents the name of the language

    /**
     * Constructs a Language object with the specified language name.
     * @param lang The name of the language.
     * @throws NullPointerException if the provided language name is null.
     */
    public Language (String lang){
        validateLang(lang); // Validates and sets the language name
    }

    /**
     * Validates and sets the language name.
     * @param lang The name of the language to be set.
     * @throws NullPointerException if the provided language name is null.
     */
    private  void validateLang (String lang) {
        if (lang == null) {
            throw new NullPointerException("Language cannot be empty.");
        }
        this.language = lang; // Sets the language name
    }

    /**
     * Retrieves the name of the language.
     * @return The name of the language.
     */
    public String getLanguage() {
        return language; // Returns the language name
    }

    /**
     * Sets the name of the language.
     * @param language The name of the language to be set.
     * @throws NullPointerException if the provided language name is null.
     */
    public void setLanguage(String language) {
        validateLang(language); // Validates and sets the language name
    }

    /**
     * Checks equality between two Language objects based on their language names.
     * @param lang The Language object to compare.
     * @return true if the language names are equal, false otherwise.
     */
    public boolean equals(Language lang){
        return (this.language.equals(lang.language)); // Compares language names for equality
    }

    @Override
    public int compareTo(Language lang) {
        return this.language.compareTo(lang.getLanguage());
    }
}
