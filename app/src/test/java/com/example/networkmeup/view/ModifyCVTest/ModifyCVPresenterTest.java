package com.example.networkmeup.view.ModifyCVTest;

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
        userToken = "test.email@email.com";
        viewStub = new ModifyCVViewStub();
        presenter = new ModifyCVPresenter(viewStub, userToken);
    }

    @Test
    public void testEditEduClicks(){
        for (int i = 0; i<21; i++){
            presenter.onEditEducation();
        }
        Assert.assertEquals(21, viewStub.getEditEduClicks());
        Assert.assertEquals("test.email@email.com", viewStub.getLastTokenPassed());
    }

    @Test
    public void testEditWorkExpClicks(){
        for (int i = 0; i<5; i++){
            presenter.onEditWorkExperience();
        }
        Assert.assertEquals(5, viewStub.getEditWorkExpClicks());
        Assert.assertEquals("test.email@email.com", viewStub.getLastTokenPassed());
    }

    @Test
    public void testEditLangKnowClicks(){
        for (int i = 0; i<9; i++){
            presenter.onEditLanguageKnowledge();
        }
        Assert.assertEquals(9, viewStub.getEditLangKnowClicks());
        Assert.assertEquals("test.email@email.com", viewStub.getLastTokenPassed());
    }
}
