package com.example.networkmeup.view.ModifyCVTest.ModifyCVEditEducationTest.AddNewEducationTest;

import com.example.networkmeup.dao.EmployeeDAO;
import com.example.networkmeup.dao.Initializer;
import com.example.networkmeup.daoMemory.EmployeeDAOMemory;
import com.example.networkmeup.daoMemory.MemoryInitializer;
import com.example.networkmeup.domain.Email;
import com.example.networkmeup.domain.Employee;
import com.example.networkmeup.view.ModifyCV.ModifyCVEditEducation.AddNewEducation.AddNewEducationPresenter;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class AddNewEducationPresenterTest {
    private AddNewEducationPresenter presenter;
    private AddNewEducationViewStub stub;
    private Initializer initializer;

    @Before
    public void setup(){
        stub = new AddNewEducationViewStub();
        presenter = new AddNewEducationPresenter(stub, "john.Brown12@gmail.com");
        initializer = new MemoryInitializer();
        initializer.prepareData();
    }

    @Test
    public void checkAddEducation(){
        //attributes set to simulated activity widgets
        stub.setDescription("Description Test");//Description text
        stub.setExpertiseArea(0); //Agriculture
        stub.setLevelOfStudies(1); //Jr High School

        presenter.onAdd(); //new education to be added (third for this user)

        //testing view side data
        Assert.assertEquals("Education has been created successfully!",stub.getLastDialogMessage());
        Assert.assertEquals("john.Brown12@gmail.com", stub.getLastTokenPassed());

        //testing database side data
        EmployeeDAO employeeDAO = new EmployeeDAOMemory();
        Employee curEmployee = employeeDAO.getByEmail(new Email("john.Brown12@gmail.com"));

        //check if education was actually added
        Assert.assertEquals(3, curEmployee.getCV().getEducation().size());

        //check if education has the right attributes

        Assert.assertEquals("Description Test", curEmployee.getCV().getEducation().get(2).getDescription());
        Assert.assertEquals("Agriculture", curEmployee.getCV().getEducation().get(2).getExpArea().getArea());
        Assert.assertEquals("Junior_High_School", curEmployee.getCV().getEducation().get(2).getLvlOfStudies().toString());

    }
}
