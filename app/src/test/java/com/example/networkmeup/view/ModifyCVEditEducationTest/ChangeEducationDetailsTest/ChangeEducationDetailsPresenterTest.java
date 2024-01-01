package com.example.networkmeup.view.ModifyCVEditEducationTest.ChangeEducationDetailsTest;

import com.example.networkmeup.dao.EmployeeDAO;
import com.example.networkmeup.dao.Initializer;
import com.example.networkmeup.daoMemory.EmployeeDAOMemory;
import com.example.networkmeup.daoMemory.MemoryInitializer;
import com.example.networkmeup.domain.Email;
import com.example.networkmeup.domain.Employee;
import com.example.networkmeup.view.ModifyCV.ModifyCVEditEducation.ChangeEducationDetails.ChangeEducationDetailsPresenter;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class ChangeEducationDetailsPresenterTest {
    private ChangeEducationDetailsPresenter presenter;
    private ChangeEducationDetailsViewStub stub;
    private Initializer initializer;

    @Before
    public void setup(){
        stub = new ChangeEducationDetailsViewStub();
        presenter = new ChangeEducationDetailsPresenter(stub, "john.Brown12@gmail.com");
        initializer = new MemoryInitializer();
        initializer.prepareData();
    }

    @Test
    public void checkEducationUpdate(){
        //attributes set to simulated activity widgets
        stub.setDescription("Description Test");//Description text
        stub.setExpertiseArea(0); //Agriculture
        stub.setLevelOfStudies(1); //Jr High School

        presenter.onSave(1); //second education to be changed

        //testing view side data
        Assert.assertEquals("This education has been updated successfully!",stub.getLastDialogMessage());
        Assert.assertEquals("john.Brown12@gmail.com", stub.getLastTokenPassed());

        //testing database side data
        EmployeeDAO employeeDAO = new EmployeeDAOMemory();
        Employee curEmployee = employeeDAO.getByEmail(new Email("john.Brown12@gmail.com"));

        Assert.assertEquals("Description Test", curEmployee.getCV().getEducation().get(1).getDescription());
        Assert.assertEquals("Agriculture", curEmployee.getCV().getEducation().get(1).getExpArea().getArea());
        Assert.assertEquals("Junior_High_School", curEmployee.getCV().getEducation().get(1).getLvlOfStudies().toString());
    }

    @Test
    public void checkEducationDelete(){
        presenter.onDelete(1); //second education to be deleted

        //testing view side data
        Assert.assertEquals("This education has been deleted successfully!",stub.getLastDialogMessage());
        Assert.assertEquals("john.Brown12@gmail.com", stub.getLastTokenPassed());

        //testing database side data
        EmployeeDAO employeeDAO = new EmployeeDAOMemory();
        Employee curEmployee = employeeDAO.getByEmail(new Email("john.Brown12@gmail.com"));

        //check if education was actually deleted
        Assert.assertEquals(1, curEmployee.getCV().getEducation().size());

        //check if the correct education was deleted (second education of user with email "john.Brown12@gmail.com")
        //by checking if the first education is exactly the same as in initialization process

        //   first Education: ("Personal Studies", ExpertiseArea("Finance"), LevelOfStudies.Amateur));
        Assert.assertEquals("Personal Studies", curEmployee.getCV().getEducation().get(0).getDescription());
        Assert.assertEquals("Finance", curEmployee.getCV().getEducation().get(0).getExpArea().getArea());
        Assert.assertEquals("Amateur", curEmployee.getCV().getEducation().get(0).getLvlOfStudies().toString());
    }
}
