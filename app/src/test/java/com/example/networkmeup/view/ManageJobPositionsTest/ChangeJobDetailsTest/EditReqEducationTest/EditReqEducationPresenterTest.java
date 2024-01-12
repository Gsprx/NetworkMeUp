package com.example.networkmeup.view.ManageJobPositionsTest.ChangeJobDetailsTest.EditReqEducationTest;

import com.example.networkmeup.domain.Job;
import com.example.networkmeup.view.ManageJobPositions.ChangeJobDetails.EditReqEducation.EditReqEducationPresenter;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * This class tests the EditReqEducationPresenter class.
 */
public class EditReqEducationPresenterTest {
    /**
     * The stub of the view to be used in testing.
     */
    private EditReqEducationViewStub stub;

    /**
     * The presenter to be tested.
     */
    private EditReqEducationPresenter presenter;

    /**
     * Sets up the test environment before each test.
     */
    @Before
    public void setup(){
        stub = new EditReqEducationViewStub();
        presenter = new EditReqEducationPresenter(stub, "testToken@email.com", new Job("Title", "Description"));
    }

    /**
     * Tests the response of the presenter to multiple change education clicks.
     */
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

    /**
     * Tests the response of the presenter to multiple add new education clicks.
     */
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

