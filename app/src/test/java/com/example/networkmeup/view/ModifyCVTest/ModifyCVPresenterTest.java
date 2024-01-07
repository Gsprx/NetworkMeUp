package com.example.networkmeup.view.ModifyCVTest;

import com.example.networkmeup.daoMemory.MemoryInitializer;
import com.example.networkmeup.view.ModifyCV.ModifyCVPresenter;
import com.example.networkmeup.view.ModifyCV.ModifyCVView;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class ModifyCVPresenterTest {
    private ModifyCVPresenter presenter;
    private ModifyCVViewStub viewStub;
    private String userToken;

    @Before
    public void setup(){
        new MemoryInitializer().prepareData();
        userToken = "john.Brown12@gmail.com";
        viewStub = new ModifyCVViewStub();
        presenter = new ModifyCVPresenter(viewStub, userToken);
    }

    @Test
    public void testEditEduClicks(){
        viewStub.setSkillset("Test");
        for (int i = 0; i<21; i++){
            presenter.onEditEducation();
        }
        Assert.assertEquals(21, viewStub.getEditEduClicks());
        Assert.assertEquals("john.Brown12@gmail.com", viewStub.getLastTokenPassed());
    }

    @Test
    public void testEditWorkExpClicks(){
        viewStub.setSkillset("Test");
        for (int i = 0; i<5; i++){
            presenter.onEditWorkExperience();
        }
        Assert.assertEquals(5, viewStub.getEditWorkExpClicks());
        Assert.assertEquals("john.Brown12@gmail.com", viewStub.getLastTokenPassed());
    }

    @Test
    public void testEditLangKnowClicks(){
        viewStub.setSkillset("Test");
        for (int i = 0; i<9; i++){
            presenter.onEditLanguageKnowledge();
        }
        Assert.assertEquals(9, viewStub.getEditLangKnowClicks());
        Assert.assertEquals("john.Brown12@gmail.com", viewStub.getLastTokenPassed());
    }

    @Test
    public void checkSaveChangesToSkillset(){
        viewStub.setSkillset("Skillset Test");
        presenter.save();
        Assert.assertEquals("Skillset Test", viewStub.getAdditionalSkillset());
    }
}
