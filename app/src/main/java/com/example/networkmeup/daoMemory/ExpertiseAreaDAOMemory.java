package com.example.networkmeup.daoMemory;

import com.example.networkmeup.dao.ExpertiseAreaDAO;
import com.example.networkmeup.domain.ExpertiseArea;

import java.util.ArrayList;
import java.util.Collections;

public class ExpertiseAreaDAOMemory implements ExpertiseAreaDAO {
    private static ArrayList<ExpertiseArea> expertiseAreas;

    public ExpertiseAreaDAOMemory(){
        if(expertiseAreas==null){
            expertiseAreas = new ArrayList<>();
        }
    }

    @Override
    public ArrayList<ExpertiseArea> getAll() {
        return new ArrayList<ExpertiseArea>(expertiseAreas);
    }

    @Override
    public void save(ExpertiseArea expertiseArea) {
        if (!find(expertiseArea)){
            expertiseAreas.add(expertiseArea);
            Collections.sort(expertiseAreas);
        }
    }

    @Override
    public boolean find(ExpertiseArea expertiseArea) {
        for(ExpertiseArea expArea : expertiseAreas){
            if(expArea.equals(expertiseArea)){
                return true;
            }
        }
        return false;
    }
}
