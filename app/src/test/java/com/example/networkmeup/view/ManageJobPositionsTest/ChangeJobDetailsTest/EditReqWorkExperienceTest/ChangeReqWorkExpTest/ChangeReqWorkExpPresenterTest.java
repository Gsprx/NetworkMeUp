package com.example.networkmeup.view.ManageJobPositionsTest.ChangeJobDetailsTest.EditReqWorkExperienceTest.ChangeReqWorkExpTest;

import com.example.networkmeup.dao.EmployerDAO;
import com.example.networkmeup.dao.Initializer;
import com.example.networkmeup.daoMemory.EmployerDAOMemory;
import com.example.networkmeup.daoMemory.MemoryInitializer;
import com.example.networkmeup.domain.Email;
import com.example.networkmeup.domain.Employer;
import com.example.networkmeup.view.ManageJobPositions.ChangeJobDetails.EditReqWorkExperience.ChangeReqWorkExpDetails.ChangeReqWorkExpDetailsPresenter;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class ChangeReqWorkExpPresenterTest {
    private ChangeReqWorkExpDetailsPresenter presenter;
    private ChangeReqWorkExpViewStub stub;
    private Initializer initializer;

    @Before
    public void setup(){
        initializer = new MemoryInitializer();
        initializer.prepareData();
        stub = new ChangeReqWorkExpViewStub();
        presenter = new ChangeReqWorkExpDetailsPresenter(stub, "b.be@northfreedom.com",
                new EmployerDAOMemory().getByEmail(new Email("b.be@northfreedom.com")).getJobs().get(0));
    }

    @Test
    public void checkReqWorkExperienceUpdate(){
        //attributes set to simulated activity widgets
        stub.setDescription("Description Test");//Description text
        stub.setExpertiseArea(0); //Agriculture
        stub.setYears(1); //years

        presenter.onSave(0); //first work experience to be changed

        EmployerDAO employerDAO = new EmployerDAOMemory();
        Employer curEmployer = employerDAO.getByEmail(new Email("b.be@northfreedom.com"));

        //testing view side data
        Assert.assertEquals("Work Experience was successfully updated!",stub.getLastDialogMessage());
        Assert.assertEquals("b.be@northfreedom.com", stub.getLastTokenPassed());
        Assert.assertEquals(true, stub.getLastPassedJob().equals(curEmployer.getJobs().get(0)));

        //testing database side data
        Assert.assertEquals("Description Test", curEmployer.getJobs().get(0).getReqWorkExperience().get(0).getDescription());
        Assert.assertEquals("Agriculture", curEmployer.getJobs().get(0).getReqWorkExperience().get(0).getExpArea().getArea());
        Assert.assertEquals(1, curEmployer.getJobs().get(0).getReqWorkExperience().get(0).getYears());
    }

    @Test
    public void checkReqWorkExperienceDelete(){
        presenter.onDelete(0); //first work Experience to be deleted

        EmployerDAO employerDAO = new EmployerDAOMemory();
        Employer curEmployer = employerDAO.getByEmail(new Email("b.be@northfreedom.com"));

        //testing view side data
        Assert.assertEquals("Work Experience was successfully deleted!",stub.getLastDialogMessage());
        Assert.assertEquals("b.be@northfreedom.com", stub.getLastTokenPassed());
        Assert.assertEquals(true, stub.getLastPassedJob().equals(curEmployer.getJobs().get(0)));

        //testing database side data
        //check if work Experience was actually deleted
        Assert.assertEquals(0, curEmployer.getJobs().get(0).getReqWorkExperience().size());
    }
}
