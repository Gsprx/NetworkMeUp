package com.example.networkmeup.view.ModifyCVTest.ModifyCVEditLanguageKnowledgeTest.AddNewLanguageKnowledgeTest;

import com.example.networkmeup.dao.EmployeeDAO;
import com.example.networkmeup.dao.Initializer;
import com.example.networkmeup.dao.LanguageDAO;
import com.example.networkmeup.daoMemory.EmployeeDAOMemory;
import com.example.networkmeup.daoMemory.LanguageDAOMemory;
import com.example.networkmeup.daoMemory.MemoryInitializer;
import com.example.networkmeup.domain.Email;
import com.example.networkmeup.domain.Employee;
import com.example.networkmeup.domain.Language;
import com.example.networkmeup.domain.LevelOfKnowledge;
import com.example.networkmeup.domain.LanguageKnowledge;
import com.example.networkmeup.view.ModifyCV.ModifyCVEditEducation.AddNewEducation.AddNewEducationPresenter;
import com.example.networkmeup.view.ModifyCV.ModifyCVEditLanguageKnowledge.AddNewLanguageKnowledge.AddNewLanguageKnowledgePresenter;
import com.example.networkmeup.view.ModifyCVTest.ModifyCVEditEducationTest.AddNewEducationTest.AddNewEducationViewStub;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class AddNewLanguageKnowledgePresenterTest {
    private AddNewLanguageKnowledgePresenter presenter;
    private AddNewLanguageKnowledgeViewStub stub;
    private Initializer initializer;

    @Before
    public void setup(){
        stub = new AddNewLanguageKnowledgeViewStub();
        presenter = new AddNewLanguageKnowledgePresenter(stub, "john.Brown12@gmail.com");
        initializer = new MemoryInitializer();
        initializer.prepareData();
    }

    @Test
    public void checkAddEducation(){
        //attributes set to simulated activity widgets
        stub.setDescription("Description Test");//Description text
        stub.setLanguage(0); //English
        stub.setLevelOfKnowledge(LevelOfKnowledge.Amateur); //Amateur

        presenter.onAdd(); //new language knowledge to be added

        //testing view side data
        Assert.assertEquals("Language Knowledge has been created successfully!",stub.getLastDialogMessage());
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


