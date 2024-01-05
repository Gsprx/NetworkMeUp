package com.example.networkmeup.view.ModifyCVTest.ModifyCVEditLanguageKnowledgeTest.AddNewLanguageKnowledgeTest;

import com.example.networkmeup.dao.EmployeeDAO;
import com.example.networkmeup.dao.LanguageDAO;
import com.example.networkmeup.daoMemory.EmployeeDAOMemory;
import com.example.networkmeup.daoMemory.LanguageDAOMemory;
import com.example.networkmeup.domain.Email;
import com.example.networkmeup.domain.Employee;
import com.example.networkmeup.domain.Language;
import com.example.networkmeup.domain.LevelOfKnowledge;
import com.example.networkmeup.domain.LanguageKnowledge;
import com.example.networkmeup.view.ModifyCV.ModifyCVEditLanguageKnowledge.AddNewLanguageKnowledge.AddNewLanguageKnowledgePresenter;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class AddNewLanguageKnowledgePresenterTest {
    private AddNewLanguageKnowledgePresenter presenter;
    private AddNewLanguageKnowledgeViewStub stub;

    @Before
    public void setup() {
        stub = new AddNewLanguageKnowledgeViewStub();
        presenter = new AddNewLanguageKnowledgePresenter(stub, "john.Brown12@gmail.com");
    }

    @Test
    public void checkAddLanguageKnowledge() {
        stub.setDescription("Description Test");
        stub.setLanguage(1); // Assuming language at position 1 in the list
        stub.setLevelOfKnowledge(LevelOfKnowledge.Amateur); // Assuming level of knowledge at position 2 in the enum

        presenter.onAdd();

        Assert.assertEquals("LanguageKnowledge has been created successfully!", stub.getSuccessMessage());
        Assert.assertEquals("john.Brown12@gmail.com", stub.getUserToken());

        EmployeeDAO employeeDAO = new EmployeeDAOMemory();
        Employee curEmployee = employeeDAO.getByEmail(new Email("john.Brown12@gmail.com"));

        Assert.assertEquals(1, curEmployee.getCV().getLanguageKnowledge().size());

        LanguageDAO languageDAO = new LanguageDAOMemory();
        Language language = languageDAO.getAll().get(stub.getLanguage());

        LevelOfKnowledge levelOfKnowledge = LevelOfKnowledge.values()[stub.getLevelOfKnowledge().ordinal()];

        LanguageKnowledge addedLanguageKnowledge = new LanguageKnowledge(
                stub.getDescription(),
                language,
                levelOfKnowledge
        );

        Assert.assertEquals(addedLanguageKnowledge, curEmployee.getCV().getLanguageKnowledge().get(0));
    }
}


