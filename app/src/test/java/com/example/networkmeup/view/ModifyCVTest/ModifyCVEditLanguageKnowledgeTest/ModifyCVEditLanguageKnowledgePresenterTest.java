package com.example.networkmeup.view.ModifyCVTest.ModifyCVEditLanguageKnowledgeTest;

import com.example.networkmeup.view.ModifyCV.ModifyCVEditLanguageKnowledge.ModifyCVEditLanguageKnowledgePresenter;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class ModifyCVEditLanguageKnowledgePresenterTest {
    private ModifyCVEditLanguageKnowledgeViewStub stub;
    private ModifyCVEditLanguageKnowledgePresenter presenter;

    @Before
    public void setup(){
        stub = new ModifyCVEditLanguageKnowledgeViewStub();
        presenter = new ModifyCVEditLanguageKnowledgePresenter(stub, "testToken@email.com");
    }

    @Test
    public void check10ChangeEduClicks(){
        for(int i = 0; i<10; i++){
            presenter.onItemClick(i);
        }
        Assert.assertEquals(10, stub.getChangeClicks());
        Assert.assertEquals("testToken@email.com", stub.getLastTokenPassed());
        Assert.assertEquals(9, stub.getLastPositionPassed());
    }

    @Test
    public void check7AddNewEduClicks(){
        for(int i = 0; i<7; i++){
            presenter.onAddNew();
        }
        Assert.assertEquals(7, stub.getAddNewClicks());
        Assert.assertEquals("testToken@email.com", stub.getLastTokenPassed());
    }
}
