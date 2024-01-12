package com.example.networkmeup.view.ManageJobPositionsTest.ChangeJobDetailsTest.EditReqLangKnowledgeTest.AddNewReqLangKnowTest;

import com.example.networkmeup.dao.Initializer;
import com.example.networkmeup.daoMemory.EmployerDAOMemory;
import com.example.networkmeup.daoMemory.MemoryInitializer;
import com.example.networkmeup.domain.Email;
import com.example.networkmeup.domain.Employer;
import com.example.networkmeup.domain.LevelOfKnowledge;
import com.example.networkmeup.view.ManageJobPositions.ChangeJobDetails.EditReqLangKnowledge.AddNewReqLangKnowledge.AddNewReqLangKnowledgePresenter;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * This class tests the AddNewReqLangKnowledgePresenter class.
 */
public class AddNewReqLangKnowPresenterTest {
    /**
     * The presenter to be tested.
     */
    private AddNewReqLangKnowledgePresenter presenter;

    /**
     * The stub of the view to be used in testing.
     */
    private AddNewReqLangKnowViewStub stub;

    /**
     * The initializer for the test data.
     */
    private Initializer initializer;

    /**
     * Sets up the test environment before each test.
     */
    @Before
    public void setup(){
        initializer = new MemoryInitializer();
        initializer.prepareData();
        stub = new AddNewReqLangKnowViewStub();
        presenter = new AddNewReqLangKnowledgePresenter(stub, "b.be@northfreedom.com", new EmployerDAOMemory().getByEmail(new Email("b.be@northfreedom.com")).getJobs().get(0));
    }

    /**
     * Tests the addition of a new language knowledge requirement.
     */
    @Test
    public void checkAddLanguageKnowledge(){
        //attributes set to simulated activity widgets
        stub.setDescription("Description Test");//Description text
        stub.setLanguage(0); //Chinese
        stub.setLevelOfKnowledge(LevelOfKnowledge.Amateur); //LevelOfKnowledge

        presenter.onAdd(); //new Language Knowledge to be added (second for this job)

        Employer currEmployer = new EmployerDAOMemory().getByEmail(new Email("b.be@northfreedom.com"));

        //testing view side data
        Assert.assertEquals("Required Language Knowledge was successfully created!", stub.getLastDialogMessage());
        Assert.assertEquals("b.be@northfreedom.com", stub.getLastTokenPassed());
        Assert.assertEquals(true, stub.getLastPassedJob().equals(currEmployer.getJobs().get(0)));

        //testing database side data
        //check if req Language Knowledge was actually added
        Assert.assertEquals(2, currEmployer.getJobs().get(0).getReqLanguageKnowledge().size());

        //check if req Language Knowledge has the right attributes

        Assert.assertEquals("Description Test", currEmployer.getJobs().get(0).getReqLanguageKnowledge().get(1).getDescription());
        Assert.assertEquals("Chinese", currEmployer.getJobs().get(0).getReqLanguageKnowledge().get(1).getLanguage().getLanguage());
        Assert.assertEquals(LevelOfKnowledge.Amateur, currEmployer.getJobs().get(0).getReqLanguageKnowledge().get(1).getLvlOfKnowledge());
    }
}
