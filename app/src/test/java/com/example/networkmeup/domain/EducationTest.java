package com.example.networkmeup.domain;

import com.example.networkmeup.domain.Education;
import com.example.networkmeup.domain.ExpertiseArea;
import com.example.networkmeup.domain.LevelOfStudies;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class EducationTest {
    private Education edu;

    // The @Before setup method initializes an Education instance for testing purposes.
    @Before
    public void setup(){
        ExpertiseArea expArea = new ExpertiseArea("Comp Sci");
        edu = new Education("AUEB Certification", expArea, LevelOfStudies.Bachelor);
    }

    // Tests if NullPointerException is thrown when setting null description.
    @Test
    public void nullDescCheck(){
        Assert.assertThrows(NullPointerException.class, ()->{edu.setDescription(null);});
    }

    // Checks if NullPointerException is thrown when setting null expertise area.
    @Test
    public void nullExpAreaCheck(){
        Assert.assertThrows(NullPointerException.class, ()->{edu.setExpArea(null);});
    }

    // Verifies if NullPointerException is thrown when setting null level of studies.
    @Test
    public void nullLevelOfStudiesCheck(){
        Assert.assertThrows(NullPointerException.class, ()->{edu.setLvlOfStudies(null);});
    }

    // Validates if setDescription method correctly sets the description in Education.
    @Test
    public void validDescCheck(){
        edu.setDescription("EKPA Certification");
        Assert.assertEquals("EKPA Certification", edu.getDescription());
    }

    // Tests if setExpArea method correctly sets the expertise area in Education.
    @Test
    public void validExpAreaCheck(){
        ExpertiseArea expArea = new ExpertiseArea("Business Management");
        edu.setExpArea(expArea);
        Assert.assertEquals("Business Management", edu.getExpArea().getArea());
    }

    // Ensures that setLvlOfStudies method accurately sets the level of studies in Education.
    @Test
    public void validLevelOfStudiesCheck(){
        edu.setLvlOfStudies(LevelOfStudies.Master);
        Assert.assertEquals(LevelOfStudies.Master, edu.getLvlOfStudies());
    }

    // Validates the equals method by checking equality between two Education instances.
    @Test
    public void equalsCheck(){
        ExpertiseArea expArea = new ExpertiseArea("Comp Sci");
        Education education2 = new Education("AUEB Certification", expArea, LevelOfStudies.Bachelor);
        Assert.assertEquals(true, edu.equals(education2));
    }

    // Tests equality by comparing Education instances with different expertise areas.
    @Test
    public void notEqualExpAreaCheck(){
        ExpertiseArea expArea = new ExpertiseArea("Alchemy");
        Education education2 = new Education("AUEB Certification", expArea, LevelOfStudies.Bachelor);
        Assert.assertEquals(false, edu.equals(education2));
    }

    // Checks inequality by comparing Education instances with different levels of studies.
    @Test
    public void notEqualLvlOfStudiesCheck(){
        ExpertiseArea expArea = new ExpertiseArea("Comp Sci");
        Education education2 = new Education("AUEB Certification", expArea, LevelOfStudies.Master);
        Assert.assertEquals(false, edu.equals(education2));
    }
}
