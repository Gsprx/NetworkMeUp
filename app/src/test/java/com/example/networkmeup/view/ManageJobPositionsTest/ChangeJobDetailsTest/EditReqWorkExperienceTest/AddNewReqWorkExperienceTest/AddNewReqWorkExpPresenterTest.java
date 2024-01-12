package com.example.networkmeup.view.ManageJobPositionsTest.ChangeJobDetailsTest.EditReqWorkExperienceTest.AddNewReqWorkExperienceTest;

import com.example.networkmeup.dao.Initializer;
import com.example.networkmeup.daoMemory.EmployerDAOMemory;
import com.example.networkmeup.daoMemory.MemoryInitializer;
import com.example.networkmeup.domain.Email;
import com.example.networkmeup.domain.Employer;
import com.example.networkmeup.view.ManageJobPositions.ChangeJobDetails.EditReqWorkExperience.AddNewReqWorkExperience.AddNewReqWorkExperiencePresenter;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * This class tests the AddNewReqWorkExpPresenter class.
 */
public class AddNewReqWorkExpPresenterTest {
    /**
     * The presenter to be tested.
     */
    private AddNewReqWorkExperiencePresenter presenter;
    /**
     * The stub of the view to be used in testing.
     */
    private AddNewReqWorkExpViewStub stub;
    /**
     * The initializer for the test data.
     */
    private Initializer initializer;

    /**
     * Sets up the test environment before each test.
     */
    @Before
    public void setup(){
        initializer = new MemoryInitializer();
        initializer.prepareData();
        stub = new AddNewReqWorkExpViewStub();
        presenter = new AddNewReqWorkExperiencePresenter(stub, "b.be@northfreedom.com", new EmployerDAOMemory().getByEmail(new Email("b.be@northfreedom.com")).getJobs().get(0));
    }

    /**
     * Tests the addition of a new work experience requirement.
     */
    @Test
    public void checkAddRewWorkExperience(){
        //attributes set to simulated activity widgets
        stub.setDescription("Description Test");//Description text
        stub.setExpertiseArea(0); //Agriculture
        stub.setYears(0); //Years 1

        presenter.onAdd(); //new Work experience to be added (second for this job)

        Employer currEmployer = new EmployerDAOMemory().getByEmail(new Email("b.be@northfreedom.com"));

        //testing view side data
        Assert.assertEquals("Required Work Experience was successfully created!", stub.getLastDialogMessage());
        Assert.assertEquals("b.be@northfreedom.com", stub.getLastTokenPassed());
        Assert.assertEquals(true, stub.getLastPassedJob().equals(currEmployer.getJobs().get(0)));

        //testing database side data
        //check if req Work Experience was actually added
        Assert.assertEquals(2, currEmployer.getJobs().get(0).getReqWorkExperience().size());

        //check if req WorkExperience has the right attributes

        Assert.assertEquals("Description Test", currEmployer.getJobs().get(0).getReqWorkExperience().get(1).getDescription());
        Assert.assertEquals("Agriculture", currEmployer.getJobs().get(0).getReqWorkExperience().get(1).getExpArea().getArea());
        Assert.assertEquals(1, currEmployer.getJobs().get(0).getReqWorkExperience().get(1).getYears());

    }
}
