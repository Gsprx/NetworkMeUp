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
    public void checkAddLangKnow(){
        //attributes set to simulated activity widgets
        stub.setDescription("Description Test");//Description text
        stub.setLanguage(0); //Chinese
        stub.setLevelOfKnowledge(LevelOfKnowledge.Amateur); //Amateur

        presenter.onAdd(); //new language knowledge to be added

        //testing view side data
        Assert.assertEquals("Language Knowledge has been created successfully!",stub.getLastDialogMessage());
        Assert.assertEquals("john.Brown12@gmail.com", stub.getLastTokenPassed());

        //testing database side data
        EmployeeDAO employeeDAO = new EmployeeDAOMemory();
        Employee curEmployee = employeeDAO.getByEmail(new Email("john.Brown12@gmail.com"));

        //check if lang know was actually added
        Assert.assertEquals(2, curEmployee.getCV().getLanguageKnowledge().size());

        //check if lang know has the right attributes

        Assert.assertEquals("Description Test", curEmployee.getCV().getLanguageKnowledge().get(1).getDescription());
        Assert.assertEquals("Chinese", curEmployee.getCV().getLanguageKnowledge().get(1).getLanguage().getLanguage());
        Assert.assertEquals("Amateur", curEmployee.getCV().getLanguageKnowledge().get(1).getLvlOfKnowledge().toString());

    }
}


