package com.example.networkmeup.view.ManageJobPositionsTest.ChangeJobDetailsTest;

import com.example.networkmeup.daoMemory.EmployerDAOMemory;
import com.example.networkmeup.daoMemory.MemoryInitializer;
import com.example.networkmeup.domain.Email;
import com.example.networkmeup.domain.Job;
import com.example.networkmeup.view.ManageJobPositions.ChangeJobDetails.ChangeJobDetailsPresenter;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class ChangeJobDetailsPresenterTest {
    private ChangeJobDetailsPresenter presenter;
    private ChangeJobDetailsViewStub stub;

    @Before
    public void setup(){
        new MemoryInitializer().prepareData();
        stub = new ChangeJobDetailsViewStub();
        presenter = new ChangeJobDetailsPresenter(stub,"b.be@northfreedom.com", new Job("Finance Office - Part Time","We are hiring for our new Finance Office position at Philips. This job is part time employment, Mon-Fri 16.00-20.00"));
    }

    @After
    public void reloadData(){
        new MemoryInitializer().prepareData();
    }

    @Test
    public void check5EditEduClicks(){
        stub.setDesc("Desc 1");
        stub.setTitle("Title 1");
        stub.setAvailab(0);
        for(int i=0;i<5;i++){
            presenter.onEditEducation();
        }
        Assert.assertEquals(5, stub.getEditEducationClicks());
        Assert.assertEquals("b.be@northfreedom.com", stub.getLastTokenPassed());
    }


    @Test
    public void check5EditWorkExpClicks(){
        stub.setDesc("Desc 1");
        stub.setTitle("Title 1");
        stub.setAvailab(0);
        for(int i=0;i<5;i++){
            presenter.onEditWorkExperience();
        }
        Assert.assertEquals(5, stub.getEditWorkExpClicks());
        Assert.assertEquals("b.be@northfreedom.com", stub.getLastTokenPassed());
    }


    @Test
    public void check5EditLangKnowClicks(){
        stub.setDesc("Desc 1");
        stub.setTitle("Title 1");
        stub.setAvailab(0);
        for(int i=0;i<5;i++){
            presenter.onEditLanguageKnowledge();
        }
        Assert.assertEquals(5, stub.getEditLangKnowClicks());
        Assert.assertEquals("b.be@northfreedom.com", stub.getLastTokenPassed());
    }

    @Test
    public void checkSaveClick(){
        stub.setDesc("Desc 2");
        stub.setTitle("Title 2");
        stub.setAvailab(1);

        presenter.onSave();

        Assert.assertEquals("b.be@northfreedom.com", stub.getLastTokenPassed());
        Assert.assertEquals(1, stub.getSaveClicks());
        Assert.assertEquals("Desc 2", new EmployerDAOMemory().getByEmail(new Email("b.be@northfreedom.com")).getJobs().get(0).getDescription());
        Assert.assertEquals("Title 2", new EmployerDAOMemory().getByEmail(new Email("b.be@northfreedom.com")).getJobs().get(0).getTitle());
        Assert.assertEquals("Temporarily_Unavailable", new EmployerDAOMemory().getByEmail(new Email("b.be@northfreedom.com")).getJobs().get(0).getAvailability().toString());
    }

    @Test
    public void checkDeleteClick(){
        presenter = new ChangeJobDetailsPresenter(stub, "b.be@northfreedom.com",new EmployerDAOMemory().getByEmail(new Email("b.be@northfreedom.com")).getJobs().get(0));
        presenter.onDelete();

        Assert.assertEquals("b.be@northfreedom.com", stub.getLastTokenPassed());
        Assert.assertEquals(1, stub.getDeleteClicks());
        Assert.assertEquals(0, new EmployerDAOMemory().getByEmail(new Email("b.be@northfreedom.com")).getJobs().size());
    }

    @Test
    public void checkSavedModifiedDetails(){
        //changed details of edit text fields should be kept
        //after the user presses any edit list button
        stub.setDesc("Desc 2");
        stub.setTitle("Title 2");
        stub.setAvailab(2);

        presenter.onEditLanguageKnowledge();

        Assert.assertEquals("Desc 2", stub.getLastJobPassed().getDescription());
        Assert.assertEquals("Title 2", stub.getLastJobPassed().getTitle());
        Assert.assertEquals(2, stub.getLastJobPassed().getAvailability().ordinal());
    }

}
