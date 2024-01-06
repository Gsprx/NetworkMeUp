package com.example.networkmeup.view.ManageJobPositionsTest.ChangeJobDetailsTest;

import com.example.networkmeup.domain.Job;
import com.example.networkmeup.view.ManageJobPositions.ChangeJobDetails.ChangeJobDetailsPresenter;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class ChangeJobDetailsPresenterTest {
    private ChangeJobDetailsPresenter presenter;
    private ChangeJobDetailsViewStub stub;

    @Before
    public void setup(){
        stub = new ChangeJobDetailsViewStub();
        presenter = new ChangeJobDetailsPresenter(stub,"token", new Job("",""));
    }

    @Test
    public void check5EditEduClicks(){
        for(int i=0;i<5;i++){
            presenter.onEditEducation();
        }
        Assert.assertEquals(5, stub.getEditEducationClicks());
        Assert.assertEquals("token", stub.getLastTokenPassed());
    }


    @Test
    public void check5EditWorkExpClicks(){
        for(int i=0;i<5;i++){
            presenter.onEditWorkExperience();
        }
        Assert.assertEquals(5, stub.getEditWorkExpClicks());
        Assert.assertEquals("token", stub.getLastTokenPassed());
    }


    @Test
    public void check5EditLangKnowClicks(){
        for(int i=0;i<5;i++){
            presenter.onEditLanguageKnowledge();
        }
        Assert.assertEquals(5, stub.getEditLangKnowClicks());
        Assert.assertEquals("token", stub.getLastTokenPassed());
    }

    @Test
    public void checkSavedModifiedDetails(){
        //changed details of edit text fields should be kept
        //after the user presses any edit list button
        stub.setDesc("Desc 2");
        stub.setTitle("Title 2");
        stub.setAvailab(2);

        presenter.onEditLanguageKnowledge();

        Assert.assertEquals("Desc 2", stub.getLastJobPassed().getDescription());
        Assert.assertEquals("Title 2", stub.getLastJobPassed().getTitle());
        Assert.assertEquals(2, stub.getLastJobPassed().getAvailability().ordinal());
    }
}
