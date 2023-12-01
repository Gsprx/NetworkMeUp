package com.example.networkmeup;

public class Language {
    private String language;

    public Language (String lang){
        validateLang(lang);
    }
    private  void validateLang (String lang) {
        if (lang == null) {
            throw new NullPointerException("Language cannot be empty.");
        }
        this.language = lang;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        validateLang(language);
    }
}
