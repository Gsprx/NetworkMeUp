package com.example.networkmeup.view.HomeEmployerTest;

import com.example.networkmeup.view.HomeEmployee.HomeEmployeePresenter;
import com.example.networkmeup.view.HomeEmployeeTest.HomeEmployeeViewStub;
import com.example.networkmeup.view.HomeEmployer.HomeEmployerPresenter;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * This class contains test cases for the HomeEmployerPresenter class.
 * It tests the functionalities related to user interactions within the HomeEmployerPresenter.
 */
public class HomeEmployerPresenterTest {

    private HomeEmployerPresenter presenter;
    private HomeEmployerViewStub view;
    private String userToken;

    /**
     * Initializes the necessary objects before each test case.
     * It sets up the presenter with a user token and a stub view.
     */
    @Before
    public void setup(){
        userToken = "tokenTest@email.com";
        view = new HomeEmployerViewStub();
        presenter = new HomeEmployerPresenter(view, userToken);
    }

    /**
     * Tests if the onManageJobPositions method increases the manage job positions counter
     * and passes the correct user token to the associated view.
     */
    @Test
    public void testManageJobPositionsClicks() {
        for (int i = 0; i < 18; i++) {
            presenter.onManageJobPositions();
        }
        Assert.assertEquals(18, view.getManageJobPositionsCounter());
        Assert.assertEquals("tokenTest@email.com", view.getLastTokenPassed());
    }

    /**
     * Tests if the onUpdateJobApplications method increases the update job applications counter
     * and passes the correct user token to the associated view.
     */
    @Test
    public void testUpdateJobApplicationsClicks() {
        for (int i = 0; i < 27; i++) {
            presenter.onUpdateJobApplications();
        }
        Assert.assertEquals(27, view.getUpdatedJobApplicationsCounter());
        Assert.assertEquals("tokenTest@email.com", view.getLastTokenPassed());
    }

    /**
     * Tests if the onEditAccount method increases the edit account counter
     * and passes the correct user token to the associated view.
     */
    @Test
    public void testEditAccountClicks() {
        for (int i = 0; i < 15; i++) {
            presenter.onEditAccount();
        }
        Assert.assertEquals(15, view.getEditedAccountCounter());
        Assert.assertEquals("tokenTest@email.com", view.getLastTokenPassed());
    }

    /**
     * Tests if an error message is received when a null token is passed
     * to the presenter during initialization.
     */
    @Test
    public void nullTokenCheck(){
        Assert.assertThrows(NullPointerException.class, ()->{presenter = new HomeEmployerPresenter(view, null);});
        Assert.assertEquals("An error has occurred during login, please try again.", view.getTokenErrorMessage());

    }
}
