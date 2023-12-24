package com.example.networkmeup.view.HomeEmployeeTest;

import com.example.networkmeup.view.HomeEmployee.HomeEmployeePresenter;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class HomeEmployeePresenterTest {
    private HomeEmployeePresenter presenter;
    private HomeEmployeeViewStub view;
    private String userToken;

    @Before
    public void setup(){
        userToken = "tokenTest@email.com";
        view = new HomeEmployeeViewStub();
        presenter = new HomeEmployeePresenter(view, userToken);
    }

    @Test
    public void testModifyCVClicks(){
        for(int i = 0; i<12 ; i++){
            presenter.onModifyCV();
        }
        Assert.assertEquals(12, view.getModifyCVCounter());
        Assert.assertEquals("tokenTest@email.com", view.getLastTokenPassed());
    }

    @Test
    public void testSearchJobsClicks(){
        for(int i = 0; i<32 ; i++){
            presenter.onSearchJobs();
        }
        Assert.assertEquals(32, view.getSearchJobsCounter());
        Assert.assertEquals("tokenTest@email.com", view.getLastTokenPassed());
    }

    @Test
    public void testEditAccountClicks(){
        for(int i = 0; i<21 ; i++){
            presenter.onEditAccount();
        }
        Assert.assertEquals(21, view.getEditAccountCounter());
        Assert.assertEquals("tokenTest@email.com", view.getLastTokenPassed());
    }

    @Test
    public void nullTokenCheck(){
        presenter = new HomeEmployeePresenter(view, null);
        Assert.assertEquals("An error has occurred during login, please try again.", view.getTokenErrorMessage());
    }
}
