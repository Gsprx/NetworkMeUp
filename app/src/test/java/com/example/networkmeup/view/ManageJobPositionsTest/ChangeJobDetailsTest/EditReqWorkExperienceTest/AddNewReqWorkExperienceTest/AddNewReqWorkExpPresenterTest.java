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

public class AddNewReqWorkExpPresenterTest {
    private AddNewReqWorkExperiencePresenter presenter;
    private AddNewReqWorkExpViewStub stub;
    private Initializer initializer;
    @Before
    public void setup(){
        initializer = new MemoryInitializer();
        initializer.prepareData();
        stub = new AddNewReqWorkExpViewStub();
        presenter = new AddNewReqWorkExperiencePresenter(stub, "b.be@northfreedom.com", new EmployerDAOMemory().getByEmail(new Email("b.be@northfreedom.com")).getJobs().get(0));
    }

    @Test
    public void checkAddEducation(){
        //attributes set to simulated activity widgets
        stub.setDescription("Description Test");//Description text
        stub.setExpertiseArea(0); //Agriculture
        stub.setYears(1); //Years

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
