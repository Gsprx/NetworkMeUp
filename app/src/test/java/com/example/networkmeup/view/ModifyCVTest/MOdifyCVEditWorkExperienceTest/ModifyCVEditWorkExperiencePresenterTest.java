package com.example.networkmeup.view.ModifyCVTest.MOdifyCVEditWorkExperienceTest;

import com.example.networkmeup.view.ModifyCV.ModifyCVEditWorkExperience.ModifyCVEditWorkExperiencePresenter;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class ModifyCVEditWorkExperiencePresenterTest {
    private ModifyCVEditWorkExperienceViewStub stub;
    private ModifyCVEditWorkExperiencePresenter presenter;

    @Before
    public void setup(){
        stub = new ModifyCVEditWorkExperienceViewStub();
        presenter = new ModifyCVEditWorkExperiencePresenter(stub, "testToken@email.com");
    }

    @Test
    public void check10ChangeWorkExpClicks(){
        for(int i = 0; i<10; i++){
            presenter.onItemClick(i);
        }
        Assert.assertEquals(10, stub.getChangeClicks());
        Assert.assertEquals("testToken@email.com", stub.getLastTokenPassed());
        Assert.assertEquals(9, stub.getLastPositionPassed());
    }

    @Test
    public void check7AddNewWorkExpClicks(){
        for(int i = 0; i<7; i++){
            presenter.onAddNew();
        }
        Assert.assertEquals(7, stub.getAddNewClicks());
        Assert.assertEquals("testToken@email.com", stub.getLastTokenPassed());
    }

}
