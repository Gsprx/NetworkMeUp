package com.example.networkmeup.view.ModifyCVTest.ModifyCVEditLanguageKnowledgeTest.ChangeLanguageKnowledgeDetailsTest;

import com.example.networkmeup.daoMemory.MemoryInitializer;
import com.example.networkmeup.domain.Language;
import com.example.networkmeup.domain.LanguageKnowledge;
import com.example.networkmeup.domain.LevelOfKnowledge;
import com.example.networkmeup.view.ModifyCV.ModifyCVEditLanguageKnowledge.ChangeLanguageKnowledgeDetails.ChangeLanguageKnowledgeDetailsPresenter;
import com.example.networkmeup.view.ModifyCV.ModifyCVEditLanguageKnowledge.ChangeLanguageKnowledgeDetails.ChangeLanguageKnowledgeDetailsView;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class ChangeLanguageKnowledgeDetailsPresenterTest {

    private ChangeLanguageKnowledgeDetailsViewStub viewStub;
    private ChangeLanguageKnowledgeDetailsPresenter presenter;
    private String userToken = "john.Brown12@gmail.com";

    @Before
    public void setUp() {
        new MemoryInitializer().prepareData();
        viewStub = new ChangeLanguageKnowledgeDetailsViewStub();
        presenter = new ChangeLanguageKnowledgeDetailsPresenter(viewStub, userToken);
    }

    @Test
    public void testOnSave() {
        // Setting up test data in the view stub
        viewStub.setDescription("Updated Language Description");
        viewStub.setLanguage(0); // Simulating language selection index
        viewStub.setLevelOfKnowledge(LevelOfKnowledge.Advanced); // Simulating level of knowledge selection

        // Adding initial language knowledge data to the stub
        LanguageKnowledge initialLanguageKnowledge = new LanguageKnowledge("Initial Description", new Language("English"), LevelOfKnowledge.Amateur);
        viewStub.setLevelOfKnowledge(LevelOfKnowledge.Amateur); // Setting initial level of knowledge
        viewStub.setDescription("Initial Description"); // Setting initial description

        // Simulating that the initial language knowledge is already present in the employee's CV
        presenter.onSave(0); // Save operation for the first language knowledge position

        // Verifying the updated language knowledge in the stub after save operation
        Assert.assertEquals("Updated Language Description", viewStub.getDescription());
        Assert.assertEquals(0, viewStub.getLanguage()); // Assuming language index 0
        Assert.assertEquals(LevelOfKnowledge.Advanced, viewStub.getLevelOfKnowledge());

        // Testing successful save message and user token after onSave operation
        Assert.assertEquals("This language knowledge has been updated successfully!", viewStub.getLastSuccessfulSaveMessage());
        Assert.assertEquals(userToken, viewStub.getLastUserToken());
    }

    @Test
    public void testOnDelete() {
        // Adding initial language knowledge data to the stub
        LanguageKnowledge initialLanguageKnowledge = new LanguageKnowledge("Initial Description", new Language("English"), LevelOfKnowledge.Amateur);
        viewStub.setLevelOfKnowledge(LevelOfKnowledge.Amateur); // Setting initial level of knowledge
        viewStub.setDescription("Initial Description"); // Setting initial description

        // Simulating that the initial language knowledge is already present in the employee's CV
        presenter.onDelete(0); // Delete operation for the first language knowledge position

        // Verifying the language knowledge deletion in the stub after delete operation
        Assert.assertNull(viewStub.getDescription()); // Assuming description set to null after deletion

        // Testing successful delete message and user token after onDelete operation
        Assert.assertEquals("This language knowledge has been deleted successfully!", viewStub.getLastSuccessfulDeleteMessage());
        Assert.assertEquals(userToken, viewStub.getLastUserToken());
    }
}

