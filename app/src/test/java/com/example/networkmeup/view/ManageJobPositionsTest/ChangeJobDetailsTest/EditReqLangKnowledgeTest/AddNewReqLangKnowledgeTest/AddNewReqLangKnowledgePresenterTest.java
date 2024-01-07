package com.example.networkmeup.view.ManageJobPositionsTest.ChangeJobDetailsTest.EditReqLangKnowledgeTest.AddNewReqLangKnowledgeTest;

import com.example.networkmeup.dao.Initializer;
import com.example.networkmeup.daoMemory.EmployerDAOMemory;
import com.example.networkmeup.daoMemory.MemoryInitializer;
import com.example.networkmeup.domain.Email;
import com.example.networkmeup.domain.Employer;
import com.example.networkmeup.domain.LevelOfKnowledge;
import com.example.networkmeup.view.ManageJobPositions.ChangeJobDetails.EditReqLangKnowledge.AddNewReqLangKnowledge.AddNewReqLangKnowledgePresenter;
import com.example.networkmeup.view.ManageJobPositions.ChangeJobDetails.EditReqWorkExperience.AddNewReqWorkExperience.AddNewReqWorkExperiencePresenter;
import com.example.networkmeup.view.ManageJobPositionsTest.ChangeJobDetailsTest.EditReqWorkExperienceTest.AddNewReqWorkExperienceTest.AddNewReqWorkExpViewStub;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class AddNewReqLangKnowledgePresenterTest {
    private AddNewReqLangKnowledgePresenter presenter;
    private AddNewReqLangKnowledgeViewStub stub;
    private Initializer initializer;
    @Before
    public void setup(){
        initializer = new MemoryInitializer();
        initializer.prepareData();
        stub = new AddNewReqLangKnowledgeViewStub();
        presenter = new AddNewReqLangKnowledgePresenter(stub, "b.be@northfreedom.com", new EmployerDAOMemory().getByEmail(new Email("b.be@northfreedom.com")).getJobs().get(0));
    }

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
