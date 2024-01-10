package com.example.networkmeup.daoMemory;

import com.example.networkmeup.domain.ExpertiseArea;

import org.junit.Before;
import org.junit.Test;
import org.junit.Assert;

import java.util.ArrayList;

public class ExpertiseAreaDaoMemoryTest {
    private ExpertiseAreaDAOMemory expertiseAreaDAOMemory;

    @Before
    public void setUp() {
        expertiseAreaDAOMemory = new ExpertiseAreaDAOMemory();
    }

    @Test
    public void testGetAllEmpty() {
        ArrayList<ExpertiseArea> allExpertiseAreas = expertiseAreaDAOMemory.getAll();
        Assert.assertTrue(allExpertiseAreas.isEmpty());
    }

    @Test
    public void testSaveAndFind() {
        ExpertiseArea expertiseArea = new ExpertiseArea("Programming");
        expertiseAreaDAOMemory.save(expertiseArea);

        Assert.assertTrue(expertiseAreaDAOMemory.find(expertiseArea));
    }

    @Test
    public void testSaveDuplicate() {
        ExpertiseArea expertiseArea = new ExpertiseArea("Networking");
        expertiseAreaDAOMemory.save(expertiseArea);

        expertiseAreaDAOMemory.save(expertiseArea); // Saving duplicate

        ArrayList<ExpertiseArea> allExpertiseAreas = expertiseAreaDAOMemory.getAll();

        // It should be 2 because we saved a new instance on the previous test
        Assert.assertEquals(2, allExpertiseAreas.size());
    }
}
