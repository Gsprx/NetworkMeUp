package com.example.networkmeup.view.ManageJobPositionsTest;

import com.example.networkmeup.domain.Job;
import com.example.networkmeup.view.ManageJobPositions.ManageJobPositionsPresenter;
import com.example.networkmeup.view.ManageJobPositions.ManageJobPositionsView;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class ManageJobPositionsPresenterTest {
    private ManageJobPositionsPresenter presenter;
    private ManageJobPositionsViewStub stub;

    @Before
    public void setup(){
        stub = new ManageJobPositionsViewStub();
        presenter = new ManageJobPositionsPresenter(stub,"Token");
    }

    @Test
    public void check7AddNew(){
        for(int i=0; i<7;i++){
            presenter.onAddNew();
        }
        Assert.assertEquals("Token", stub.getLastTokenPassed());
        Assert.assertEquals(7, stub.getAddNewClicks());
        Assert.assertEquals(null, stub.getLastJobPassed());
    }

    @Test
    public void check3ChangeDetails(){
        for(int i=0; i<3; i++){
            presenter.onItemClick(new Job("Title","Description"));
        }
        Assert.assertEquals("Token", stub.getLastTokenPassed());
        Assert.assertEquals(3, stub.getChangeJobClicks());
        Assert.assertEquals("Title", stub.getLastJobPassed().getTitle());
        Assert.assertEquals("Description", stub.getLastJobPassed().getDescription());
    }
}
