package com.example.networkmeup.view.ManageJobPositionsTest.ChangeJobDetailsTest.EditReqLangKnowledgeTest.ChangeReqLangKnowledgeTest;

import com.example.networkmeup.dao.EmployerDAO;
import com.example.networkmeup.dao.Initializer;
import com.example.networkmeup.daoMemory.EmployerDAOMemory;
import com.example.networkmeup.daoMemory.MemoryInitializer;
import com.example.networkmeup.domain.Email;
import com.example.networkmeup.domain.Employer;
import com.example.networkmeup.domain.LevelOfKnowledge;
import com.example.networkmeup.view.ManageJobPositions.ChangeJobDetails.EditReqLangKnowledge.ChangeReqLangKnowledgeDetails.ChangeReqLangKnowledgeDetailsPresenter;
import com.example.networkmeup.view.ManageJobPositions.ChangeJobDetails.EditReqWorkExperience.ChangeReqWorkExperienceDetails.ChangeReqWorkExpDetailsPresenter;
import com.example.networkmeup.view.ManageJobPositionsTest.ChangeJobDetailsTest.EditReqWorkExperienceTest.ChangeReqWorkExpTest.ChangeReqWorkExpViewStub;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class ChangeReqLangKnowledgePresenterTest {
    private ChangeReqLangKnowledgeDetailsPresenter presenter;
    private ChangeReqLangKnowledgeViewStub stub;
    private Initializer initializer;

    @Before
    public void setup(){
        initializer = new MemoryInitializer();
        initializer.prepareData();
        stub = new ChangeReqLangKnowledgeViewStub();
        presenter = new ChangeReqLangKnowledgeDetailsPresenter(stub, "b.be@northfreedom.com",
                new EmployerDAOMemory().getByEmail(new Email("b.be@northfreedom.com")).getJobs().get(0));
    }

    @Test
    public void checkReqWorkExperienceUpdate(){
        //attributes set to simulated activity widgets
        stub.setDescription("Description Test");//Description text
        stub.setLanguage(0); //Chinese
        stub.setLevelOfKnowledge(LevelOfKnowledge.Amateur); //Amateur

        presenter.onSave(0); //first language knowledge to be changed

        EmployerDAO employerDAO = new EmployerDAOMemory();
        Employer curEmployer = employerDAO.getByEmail(new Email("b.be@northfreedom.com"));

        //testing view side data
        Assert.assertEquals("Language Knowledge was successfully updated!",stub.getLastDialogMessage());
        Assert.assertEquals("b.be@northfreedom.com", stub.getLastTokenPassed());
        Assert.assertEquals(true, stub.getLastPassedJob().equals(curEmployer.getJobs().get(0)));

        //testing database side data
        Assert.assertEquals("Description Test", curEmployer.getJobs().get(0).getReqLanguageKnowledge().get(0).getDescription());
        Assert.assertEquals("Chinese", curEmployer.getJobs().get(0).getReqLanguageKnowledge().get(0).getLanguage().getLanguage());
        Assert.assertEquals(LevelOfKnowledge.Amateur, curEmployer.getJobs().get(0).getReqLanguageKnowledge().get(0).getLvlOfKnowledge());
    }

    @Test
    public void checkReqLangKnowledgeDelete(){
        presenter.onDelete(0); //first language knowledge to be deleted

        EmployerDAO employerDAO = new EmployerDAOMemory();
        Employer curEmployer = employerDAO.getByEmail(new Email("b.be@northfreedom.com"));

        //testing view side data
        Assert.assertEquals("Language Knowledge was successfully deleted!",stub.getLastDialogMessage());
        Assert.assertEquals("b.be@northfreedom.com", stub.getLastTokenPassed());
        Assert.assertEquals(true, stub.getLastPassedJob().equals(curEmployer.getJobs().get(0)));

        //testing database side data
        //check if language knowledge was actually deleted
        Assert.assertEquals(0, curEmployer.getJobs().get(0).getReqLanguageKnowledge().size());
    }
}
