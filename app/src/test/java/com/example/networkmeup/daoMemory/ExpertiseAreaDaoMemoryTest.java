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
    public void testSaveAndFind() {
        ExpertiseArea expertiseArea = new ExpertiseArea("Programming");
        expertiseAreaDAOMemory.save(expertiseArea);

        Assert.assertTrue(expertiseAreaDAOMemory.find(expertiseArea));
        expertiseAreaDAOMemory.delete(expertiseArea);
    }
}
