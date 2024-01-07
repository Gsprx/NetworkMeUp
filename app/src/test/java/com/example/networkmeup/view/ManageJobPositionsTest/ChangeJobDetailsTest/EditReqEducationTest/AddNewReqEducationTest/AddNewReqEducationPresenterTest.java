package com.example.networkmeup.view.ManageJobPositionsTest.ChangeJobDetailsTest.EditReqEducationTest.AddNewReqEducationTest;

import com.example.networkmeup.dao.EmployeeDAO;
import com.example.networkmeup.dao.Initializer;
import com.example.networkmeup.daoMemory.EmployeeDAOMemory;
import com.example.networkmeup.daoMemory.EmployerDAOMemory;
import com.example.networkmeup.daoMemory.MemoryInitializer;
import com.example.networkmeup.domain.Email;
import com.example.networkmeup.domain.Employee;
import com.example.networkmeup.domain.Employer;
import com.example.networkmeup.view.ManageJobPositions.ChangeJobDetails.EditReqEducation.AddNewReqEducation.AddNewReqEducationPresenter;
import com.example.networkmeup.view.ModifyCV.ModifyCVEditEducation.AddNewEducation.AddNewEducationPresenter;
import com.example.networkmeup.view.ModifyCVTest.ModifyCVEditEducationTest.AddNewEducationTest.AddNewEducationViewStub;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class AddNewReqEducationPresenterTest {
    private AddNewReqEducationPresenter presenter;
    private AddNewReqEducationViewStub stub;
    private Initializer initializer;
    @Before
    public void setup(){
        initializer = new MemoryInitializer();
        initializer.prepareData();
        stub = new AddNewReqEducationViewStub();
        presenter = new AddNewReqEducationPresenter(stub, "b.be@northfreedom.com", new EmployerDAOMemory().getByEmail(new Email("b.be@northfreedom.com")).getJobs().get(0));
    }

    @Test
    public void checkAddEducation(){
        //attributes set to simulated activity widgets
        stub.setDescription("Description Test");//Description text
        stub.setExpertiseArea(0); //Agriculture
        stub.setLevelOfStudies(1); //Jr High School

        presenter.onAdd(); //new education to be added (second for this job)

        Employer currEmployer = new EmployerDAOMemory().getByEmail(new Email("b.be@northfreedom.com"));

        //testing view side data
        Assert.assertEquals("Required Education was successfully created!", stub.getLastDialogMessage());
        Assert.assertEquals("b.be@northfreedom.com", stub.getLastTokenPassed());
        Assert.assertEquals(true, stub.getLastPassedJob().equals(currEmployer.getJobs().get(0)));

        //testing database side data
        //check if req education was actually added
        Assert.assertEquals(2, currEmployer.getJobs().get(0).getReqEducation().size());

        //check if req education has the right attributes

        Assert.assertEquals("Description Test", currEmployer.getJobs().get(0).getReqEducation().get(1).getDescription());
        Assert.assertEquals("Agriculture", currEmployer.getJobs().get(0).getReqEducation().get(1).getExpArea().getArea());
        Assert.assertEquals("Junior_High_School", currEmployer.getJobs().get(0).getReqEducation().get(1).getLvlOfStudies().toString());

    }
}
