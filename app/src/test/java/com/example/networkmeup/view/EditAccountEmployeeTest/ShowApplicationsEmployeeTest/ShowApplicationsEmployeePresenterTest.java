package com.example.networkmeup.view.EditAccountEmployeeTest.ShowApplicationsEmployeeTest;

import static org.junit.Assert.assertNotNull;

import com.example.networkmeup.dao.Initializer;
import com.example.networkmeup.daoMemory.MemoryInitializer;
import com.example.networkmeup.domain.Application;
import com.example.networkmeup.view.EditAccountEmployee.ShowApplicationsEmployee.ShowApplicationsEmployeePresenter;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

public class ShowApplicationsEmployeePresenterTest {
    private ShowApplicationsEmployeePresenter presenter;
    private String testUserEmail = "john.Brown12@gmail.com";

    private ShowApplicationsEmployeeViewStub view;

    @Before
    public void setUp() {
        Initializer initializer = new MemoryInitializer();
        initializer.prepareData();
        // This will use the actual EmployeeDAOMemory implementation.
       this.presenter = new ShowApplicationsEmployeePresenter(view, testUserEmail);
    }

    @Test
    public void testGetApplications() {
        setUp();
        ArrayList<Application> applications = this.presenter.getApplications();
        assertNotNull("The applications list should not be null", applications);

    }
}
