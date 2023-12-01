package com.example.networkmeup;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class EducationTest {
    private Education edu;

    @Before
    public void setup(){
        ExpertiseArea expArea = new ExpertiseArea("Comp Sci");
        edu = new Education("AUEB Certification", expArea, LevelOfStudies.Bachelor);
    }

    @Test
    public void nullDescCheck(){
        Assert.assertThrows(NullPointerException.class, ()->{edu.setDescription(null);});
    }

    @Test
    public void nullExpAreaCheck(){
        Assert.assertThrows(NullPointerException.class, ()->{edu.setExpArea(null);});
    }

    @Test
    public void nullLevelOfStudiesCheck(){
        Assert.assertThrows(NullPointerException.class, ()->{edu.setLvlOfStudies(null);});
    }

    @Test
    public void validDescCheck(){
        edu.setDescription("EKPA Certification");
        Assert.assertEquals("EKPA Certification", edu.getDescription());
    }

    @Test
    public void validExpAreaCheck(){
        ExpertiseArea expArea = new ExpertiseArea("Business Management");
        edu.setExpArea(expArea);
        Assert.assertEquals("Business Management", edu.getExpArea().getArea());
    }

    @Test
    public void validLevelOfStudiesCheck(){
        edu.setLvlOfStudies(LevelOfStudies.Master);
        Assert.assertEquals(LevelOfStudies.Master, edu.getLvlOfStudies());
    }
    @Test
    public void equalsCheck(){
        ExpertiseArea expArea = new ExpertiseArea("Comp Sci");
        Education education2 = new Education("AUEB Certification", expArea, LevelOfStudies.Bachelor);
        Assert.assertEquals(true, edu.equals(education2));
    }
    @Test
    public void notEqualExpAreaCheck(){
        ExpertiseArea expArea = new ExpertiseArea("Alchemy");
        Education education2 = new Education("AUEB Certification", expArea, LevelOfStudies.Bachelor);
        Assert.assertEquals(false, edu.equals(education2));
    }
    @Test
    public void notEqualLvlOfStudiesCheck(){
        ExpertiseArea expArea = new ExpertiseArea("Comp Sci");
        Education education2 = new Education("AUEB Certification", expArea, LevelOfStudies.Master);
        Assert.assertEquals(false, edu.equals(education2));
    }
}
