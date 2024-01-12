package com.example.networkmeup.daoMemory;

import com.example.networkmeup.dao.ExpertiseAreaDAO;
import com.example.networkmeup.domain.ExpertiseArea;

import java.util.ArrayList;
import java.util.Collections;

/**
 * The ExpertiseAreaDAOMemory class implements the ExpertiseAreaDAO interface.
 * This class is responsible for managing expertise area-related data in memory.
 */
public class ExpertiseAreaDAOMemory implements ExpertiseAreaDAO {
    /**
     * A static ArrayList that holds all the ExpertiseArea objects.
     */
    private static ArrayList<ExpertiseArea> expertiseAreas;

    /**
     * The constructor for the ExpertiseAreaDAOMemory class.
     * If the expertiseAreas ArrayList is null, it initializes it.
     */
    public ExpertiseAreaDAOMemory(){
        if(expertiseAreas==null){
            expertiseAreas = new ArrayList<>();
        }
    }

    /**
     * This method returns a new ArrayList containing all the ExpertiseArea objects.
     * @return a new ArrayList containing all the ExpertiseArea objects.
     */
    @Override
    public ArrayList<ExpertiseArea> getAll() {
        return new ArrayList<ExpertiseArea>(expertiseAreas);
    }

    /**
     * This method saves a new ExpertiseArea object to the expertiseAreas ArrayList.
     * If the ExpertiseArea object is not already in the ArrayList, it is added and the ArrayList is sorted.
     * @param expertiseArea the ExpertiseArea object to be saved.
     */
    @Override
    public void save(ExpertiseArea expertiseArea) {
        if (!find(expertiseArea)){
            expertiseAreas.add(expertiseArea);
            Collections.sort(expertiseAreas);
        }
    }

    /**
     * This method checks if an ExpertiseArea object is in the expertiseAreas ArrayList.
     * @param expertiseArea the ExpertiseArea object to be found.
     * @return true if the ExpertiseArea object is found, false otherwise.
     */
    @Override
    public boolean find(ExpertiseArea expertiseArea) {
        for(ExpertiseArea expArea : expertiseAreas){
            if(expArea.equals(expertiseArea)){
                return true;
            }
        }
        return false;
    }

    @Override
    public void delete(ExpertiseArea expertiseArea) {
        expertiseAreas.remove(expertiseArea);
    }
}
