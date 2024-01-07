package com.example.networkmeup.view.ManageJobPositionsTest.ChangeJobDetailsTest.EditReqWorkExperienceTest;

import com.example.networkmeup.domain.Job;
import com.example.networkmeup.view.ManageJobPositions.ChangeJobDetails.EditReqWorkExperience.EditReqWorkExperiencePresenter;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class EditReqWorkExperiencePresenterTest {
    private EditReqWorkExperienceViewStub stub;
    private EditReqWorkExperiencePresenter presenter;

    @Before
    public void setup(){
        stub = new EditReqWorkExperienceViewStub();
        presenter = new EditReqWorkExperiencePresenter(stub, "testToken@email.com", new Job("Title", "Description"));
    }

    @Test
    public void check10ChangeEduClicks(){
        for(int i = 0; i<10; i++){
            presenter.onItemClick(i);
        }
        Assert.assertEquals(10, stub.getChangeClicks());
        Assert.assertEquals("testToken@email.com", stub.getLastTokenPassed());
        Assert.assertEquals(9, stub.getLastPositionPassed());
        Assert.assertEquals("Title", stub.getLastJobPassed().getTitle());
        Assert.assertEquals("Description", stub.getLastJobPassed().getDescription());
    }

    @Test
    public void check7AddNewEduClicks(){
        for(int i = 0; i<7; i++){
            presenter.onAddNew();
        }
        Assert.assertEquals(7, stub.getAddNewClicks());
        Assert.assertEquals("testToken@email.com", stub.getLastTokenPassed());
        Assert.assertEquals("Title", stub.getLastJobPassed().getTitle());
        Assert.assertEquals("Description", stub.getLastJobPassed().getDescription());
    }
}
