package com.example.networkmeup.view.ModifyCVTest.ModifyCVEditWorkExperienceTest.AddNewWorkExperienceTest;

import com.example.networkmeup.dao.EmployeeDAO;
import com.example.networkmeup.dao.Initializer;
import com.example.networkmeup.daoMemory.EmployeeDAOMemory;
import com.example.networkmeup.daoMemory.MemoryInitializer;
import com.example.networkmeup.domain.Email;
import com.example.networkmeup.domain.Employee;
import com.example.networkmeup.view.ModifyCV.ModifyCVEditWorkExperience.AddNewWorkExperience.AddNewWorkExperiencePresenter;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class AddNewWorkExperiencePresenterTest {
    private AddNewWorkExperiencePresenter presenter;
    private AddNewWorkExperienceViewStub stub;
    private Initializer initializer;

    @Before
    public void setup(){
        stub = new AddNewWorkExperienceViewStub();
        presenter = new AddNewWorkExperiencePresenter(stub, "john.Brown12@gmail.com");
        initializer = new MemoryInitializer();
        initializer.prepareData();
    }

    @Test
    public void checkAddWorkExperience(){
        //attributes set to simulated activity widgets
        stub.setDescription("Description Test");//Description text
        stub.setExpertiseArea(0); //Agriculture
        stub.setYearsAtWork(1); //1 year

        presenter.onAdd(); //new education to be added (third for this user)

        //testing view side data
        Assert.assertEquals("Work Experience has been created successfully!",stub.getLastDialogMessage());
        Assert.assertEquals("john.Brown12@gmail.com", stub.getLastTokenPassed());

        //testing database side data
        EmployeeDAO employeeDAO = new EmployeeDAOMemory();
        Employee curEmployee = employeeDAO.getByEmail(new Email("john.Brown12@gmail.com"));

        //check if work Experience was actually added
        Assert.assertEquals(3, curEmployee.getCV().getWorkExperiences().size());

        //check if work Experience has the right attributes

        Assert.assertEquals("Description Test", curEmployee.getCV().getWorkExperiences().get(2).getDescription());
        Assert.assertEquals("Agriculture", curEmployee.getCV().getWorkExperiences().get(2).getExpArea().getArea());
        Assert.assertEquals(2, curEmployee.getCV().getWorkExperiences().get(2).getYears());

    }
}
