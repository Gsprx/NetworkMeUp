package com.example.networkmeup.view.ManageJobPositionsTest.ChangeJobDetailsTest.EditReqEducationTest.ChangeReqEducationDetailsTest;

import com.example.networkmeup.dao.EmployeeDAO;
import com.example.networkmeup.dao.EmployerDAO;
import com.example.networkmeup.dao.Initializer;
import com.example.networkmeup.daoMemory.EmployeeDAOMemory;
import com.example.networkmeup.daoMemory.EmployerDAOMemory;
import com.example.networkmeup.daoMemory.MemoryInitializer;
import com.example.networkmeup.domain.Email;
import com.example.networkmeup.domain.Employee;
import com.example.networkmeup.domain.Employer;
import com.example.networkmeup.domain.Job;
import com.example.networkmeup.view.ManageJobPositions.ChangeJobDetails.EditReqEducation.ChangeReqEducationDetails.ChangeReqEducationDetailsPresenter;
import com.example.networkmeup.view.ModifyCV.ModifyCVEditEducation.ChangeEducationDetails.ChangeEducationDetailsPresenter;
import com.example.networkmeup.view.ModifyCVTest.ModifyCVEditEducationTest.ChangeEducationDetailsTest.ChangeEducationDetailsViewStub;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class ChangeReqEducationDetailsPresenterTest {
    private ChangeReqEducationDetailsPresenter presenter;
    private ChangeReqEducationDetailsViewStub stub;
    private Initializer initializer;

    @Before
    public void setup(){
        initializer = new MemoryInitializer();
        initializer.prepareData();
        stub = new ChangeReqEducationDetailsViewStub();
        presenter = new ChangeReqEducationDetailsPresenter(stub, "b.be@northfreedom.com",
                    new EmployerDAOMemory().getByEmail(new Email("b.be@northfreedom.com")).getJobs().get(0));
    }

    @Test
    public void checkReqEducationUpdate(){
        //attributes set to simulated activity widgets
        stub.setDescription("Description Test");//Description text
        stub.setExpertiseArea(0); //Agriculture
        stub.setLevelOfStudies(1); //Jr High School

        presenter.onSave(0); //first education to be changed

        EmployerDAO employerDAO = new EmployerDAOMemory();
        Employer curEmployer = employerDAO.getByEmail(new Email("b.be@northfreedom.com"));

        //testing view side data
        Assert.assertEquals("Education was successfully updated!",stub.getLastDialogMessage());
        Assert.assertEquals("b.be@northfreedom.com", stub.getLastTokenPassed());
        Assert.assertEquals(true, stub.getLastPassedJob().equals(curEmployer.getJobs().get(0)));

        //testing database side data
        Assert.assertEquals("Description Test", curEmployer.getJobs().get(0).getReqEducation().get(0).getDescription());
        Assert.assertEquals("Agriculture", curEmployer.getJobs().get(0).getReqEducation().get(0).getExpArea().getArea());
        Assert.assertEquals("Junior_High_School", curEmployer.getJobs().get(0).getReqEducation().get(0).getLvlOfStudies().toString());
    }

    @Test
    public void checkReqEducationDelete(){
        presenter.onDelete(0); //first education to be deleted

        EmployerDAO employerDAO = new EmployerDAOMemory();
        Employer curEmployer = employerDAO.getByEmail(new Email("b.be@northfreedom.com"));

        //testing view side data
        Assert.assertEquals("Education was successfully deleted!",stub.getLastDialogMessage());
        Assert.assertEquals("b.be@northfreedom.com", stub.getLastTokenPassed());
        Assert.assertEquals(true, stub.getLastPassedJob().equals(curEmployer.getJobs().get(0)));

        //testing database side data
        //check if education was actually deleted
        Assert.assertEquals(0, curEmployer.getJobs().get(0).getReqEducation().size());
    }
}
