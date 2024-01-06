package com.example.networkmeup.view.ModifyCVTest.MOdifyCVEditWorkExperienceTest.ChangeWorkExperienceDetailsTest;

import com.example.networkmeup.dao.EmployeeDAO;
import com.example.networkmeup.dao.Initializer;
import com.example.networkmeup.daoMemory.EmployeeDAOMemory;
import com.example.networkmeup.daoMemory.MemoryInitializer;
import com.example.networkmeup.domain.Email;
import com.example.networkmeup.domain.Employee;
import com.example.networkmeup.view.ModifyCV.ModifyCVEditEducation.ChangeEducationDetails.ChangeEducationDetailsPresenter;
import com.example.networkmeup.view.ModifyCV.ModifyCVEditWorkExperience.ChangeWorkExperienceDetails.ChangeWorkExperienceDetailsPresenter;
import com.example.networkmeup.view.ModifyCVTest.ModifyCVEditEducationTest.ChangeEducationDetailsTest.ChangeEducationDetailsViewStub;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class ChangeWorkExperienceDetailsPresenterTest {
    private ChangeWorkExperienceDetailsPresenter presenter;
    private ChangeWorkExperienceDetailsViewStub stub;
    private Initializer initializer;

    @Before
    public void setup(){
        stub = new ChangeWorkExperienceDetailsViewStub();
        presenter = new ChangeWorkExperienceDetailsPresenter(stub, "john.Brown12@gmail.com");
        initializer = new MemoryInitializer();
        initializer.prepareData();
    }

    @Test
    public void checkWorkExperienceUpdate(){
        //attributes set to simulated activity widgets
        stub.setDescription("Description Test");//Description text
        stub.setExpertiseArea(0); //Agriculture
        stub.setYearsAtWork(0); //Years At work

        presenter.onSave(1); //second work Experience to be changed

        //testing view side data
        Assert.assertEquals("This Work Experience has been updated successfully!",stub.getLastDialogMessage());
        Assert.assertEquals("john.Brown12@gmail.com", stub.getLastTokenPassed());

        //testing database side data
        EmployeeDAO employeeDAO = new EmployeeDAOMemory();
        Employee curEmployee = employeeDAO.getByEmail(new Email("john.Brown12@gmail.com"));

        Assert.assertEquals("Description Test", curEmployee.getCV().getWorkExperiences().get(1).getDescription());
        Assert.assertEquals("Agriculture", curEmployee.getCV().getWorkExperiences().get(1).getExpArea().getArea());
        Assert.assertEquals(1, curEmployee.getCV().getWorkExperiences().get(1).getYears());
    }

    @Test
    public void checkWorkExperienceDelete(){
        presenter.onDelete(0); //second Work Experience to be deleted

        //testing view side data
        Assert.assertEquals("This Work Experience has been deleted successfully!",stub.getLastDialogMessage());
        Assert.assertEquals("john.Brown12@gmail.com", stub.getLastTokenPassed());

        //testing database side data
        EmployeeDAO employeeDAO = new EmployeeDAOMemory();
        Employee curEmployee = employeeDAO.getByEmail(new Email("john.Brown12@gmail.com"));

        //check if work Experience was actually deleted
        Assert.assertEquals(1, curEmployee.getCV().getWorkExperiences().size());

        //check if the correct Work Experience was deleted (second Work Experience of user with email "john.Brown12@gmail.com")
        //by checking if the first Work Experience is exactly the same as in initialization process

        //   first Work Experience: (4,"Previous full time career work", new ExpertiseArea("Finance")
        Assert.assertEquals("Previous full time career work", curEmployee.getCV().getWorkExperiences().get(0).getDescription());
        Assert.assertEquals("Finance", curEmployee.getCV().getWorkExperiences().get(0).getExpArea().getArea());
        Assert.assertEquals(4, curEmployee.getCV().getWorkExperiences().get(0).getYears());
    }
}
