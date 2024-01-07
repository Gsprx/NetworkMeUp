package com.example.networkmeup.view.ModifyCVTest.ModifyCVEditLanguageKnowledgeTest.ChangeLanguageKnowledgeDetailsTest;

import com.example.networkmeup.dao.EmployeeDAO;
import com.example.networkmeup.dao.Initializer;
import com.example.networkmeup.daoMemory.EmployeeDAOMemory;
import com.example.networkmeup.daoMemory.MemoryInitializer;
import com.example.networkmeup.domain.Email;
import com.example.networkmeup.domain.Employee;
import com.example.networkmeup.domain.LevelOfKnowledge;
import com.example.networkmeup.view.ModifyCV.ModifyCVEditLanguageKnowledge.ChangeLanguageKnowledgeDetails.ChangeLanguageKnowledgeDetailsPresenter;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class ChangeLanguageKnowledgeDetailsPresenterTest {

    private ChangeLanguageKnowledgeDetailsPresenter presenter;
    private ChangeLanguageKnowledgeDetailsViewStub stub;
    private Initializer initializer;

    @Before
    public void setup() {
        stub = new ChangeLanguageKnowledgeDetailsViewStub();
        presenter = new ChangeLanguageKnowledgeDetailsPresenter(stub, "marygreen.188@gmail.com");
        initializer = new MemoryInitializer();
        initializer.prepareData();
    }

    @After
    public void resetData(){
        initializer = new MemoryInitializer();
        initializer.prepareData();
    }

    @Test
    public void checkLanguageKnowledgeUpdate() {
        //attributes set to simulated activity widgets
        stub.setDescription("Description Test");//Description text
        stub.setLanguage(6); //Spanish
        stub.setLevelOfKnowledge(LevelOfKnowledge.Amateur); //Amateur

        presenter.onSave(1); //second language knowledge to be changed

        //testing view side data
        Assert.assertEquals("This language knowledge has been updated successfully!", stub.getLastSuccessfulSaveMessage());
        Assert.assertEquals("marygreen.188@gmail.com", stub.getLastUserToken());

        //testing database side data
        EmployeeDAO employeeDAO = new EmployeeDAOMemory();
        Employee curEmployee = employeeDAO.getByEmail(new Email("marygreen.188@gmail.com"));

        Assert.assertEquals("Description Test", curEmployee.getCV().getLanguageKnowledge().get(1).getDescription());
        Assert.assertEquals("Spanish", curEmployee.getCV().getLanguageKnowledge().get(1).getLanguage().getLanguage());
        Assert.assertEquals(LevelOfKnowledge.Amateur, curEmployee.getCV().getLanguageKnowledge().get(1).getLvlOfKnowledge());
    }

    @Test
    public void checkLangKnowDelete() {
        presenter.onDelete(1); //second language knowledge to be deleted

        //testing view side data
        Assert.assertEquals("This language knowledge has been deleted successfully!", stub.getLastSuccessfulDeleteMessage());
        Assert.assertEquals("marygreen.188@gmail.com", stub.getLastUserToken());

        //testing database side data
        EmployeeDAO employeeDAO = new EmployeeDAOMemory();
        Employee curEmployee = employeeDAO.getByEmail(new Email("marygreen.188@gmail.com"));

        //check if education was actually deleted
        Assert.assertEquals(1, curEmployee.getCV().getLanguageKnowledge().size());

        //check if the correct education was deleted (second education of user with email "marygreen.188@gmail.com")
        //by checking if the first language knowledge is exactly the same as in initialization process

        //   first Language Knowledge: ("Personal Studies", ExpertiseArea("Finance"), LevelOfStudies.Bachelor));
        Assert.assertEquals("Born and raised in France", curEmployee.getCV().getLanguageKnowledge().get(0).getDescription());
        Assert.assertEquals("French", curEmployee.getCV().getLanguageKnowledge().get(0).getLanguage().getLanguage());
        Assert.assertEquals(LevelOfKnowledge.Native, curEmployee.getCV().getLanguageKnowledge().get(0).getLvlOfKnowledge());
    }
}