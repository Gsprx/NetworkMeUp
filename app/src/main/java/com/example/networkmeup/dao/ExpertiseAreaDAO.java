package com.example.networkmeup.dao;

import com.example.networkmeup.domain.ExpertiseArea;

import java.util.ArrayList;

/**
 * ExpertiseArea interface outlines the methods that should be implemented by classes
 * responsible for handling ExpertiseArea data access operations.
 */
public interface ExpertiseAreaDAO {
    /**
     * Returns all object in this database
     * @return ArrayList of all Expertise Areas
     */
    public ArrayList<ExpertiseArea> getAll();

    /**
     * @param expertiseArea
     */
    public void save(ExpertiseArea expertiseArea);
    public boolean find(ExpertiseArea expertiseArea);
    public void delete(ExpertiseArea expertiseArea);
}
