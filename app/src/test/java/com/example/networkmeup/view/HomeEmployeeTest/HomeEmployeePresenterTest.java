package com.example.networkmeup.view.HomeEmployeeTest;

import com.example.networkmeup.view.HomeEmployee.HomeEmployeePresenter;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * This class contains test cases for the HomeEmployeePresenter class.
 * It tests the functionalities related to user interactions within the HomeEmployeePresenter.
 */
public class HomeEmployeePresenterTest {
    private HomeEmployeePresenter presenter;
    private HomeEmployeeViewStub view;
    private String userToken;

    /**
     * Initializes the necessary objects before each test case.
     * It sets up the presenter with a user token and a stub view.
     */
    @Before
    public void setup(){
        userToken = "tokenTest@email.com";
        view = new HomeEmployeeViewStub();
        presenter = new HomeEmployeePresenter(view, userToken);
    }

    /**
     * Tests if the onModifyCV method increases the modify CV counter
     * and passes the correct user token to the associated view.
     */
    @Test
    public void testModifyCVClicks(){
        for(int i = 0; i<12 ; i++){
            presenter.onModifyCV();
        }
        Assert.assertEquals(12, view.getModifyCVCounter());
        Assert.assertEquals("tokenTest@email.com", view.getLastTokenPassed());
    }

    /**
     * Tests if the onSearchJobs method increases the search jobs counter
     * and passes the correct user token to the associated view.
     */
    @Test
    public void testSearchJobsClicks(){
        for(int i = 0; i<32 ; i++){
            presenter.onSearchJobs();
        }
        Assert.assertEquals(32, view.getSearchJobsCounter());
        Assert.assertEquals("tokenTest@email.com", view.getLastTokenPassed());
    }

    /**
     * Tests if the onEditAccount method increases the edit account counter
     * and passes the correct user token to the associated view.
     */
    @Test
    public void testEditAccountClicks(){
        for(int i = 0; i<21 ; i++){
            presenter.onEditAccount();
        }
        Assert.assertEquals(21, view.getEditAccountCounter());
        Assert.assertEquals("tokenTest@email.com", view.getLastTokenPassed());
    }

    /**
     * Tests if an error message is received when a null token is passed
     * to the presenter during initialization.
     */
    @Test
    public void nullTokenCheck(){
        presenter = new HomeEmployeePresenter(view, null);
        Assert.assertEquals("An error has occurred during login, please try again.", view.getTokenErrorMessage());
    }
}
