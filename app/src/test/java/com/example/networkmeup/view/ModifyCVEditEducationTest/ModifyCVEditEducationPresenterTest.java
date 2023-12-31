package com.example.networkmeup.view.ModifyCVEditEducationTest;

import com.example.networkmeup.view.ModifyCVEditEducation.ModifyCVEditEducationPresenter;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class ModifyCVEditEducationPresenterTest {
    private ModifyCVEditEducationViewStub stub;
    private ModifyCVEditEducationPresenter presenter;

    @Before
    public void setup(){
        stub = new ModifyCVEditEducationViewStub();
        presenter = new ModifyCVEditEducationPresenter(stub, "testToken@email.com");
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
