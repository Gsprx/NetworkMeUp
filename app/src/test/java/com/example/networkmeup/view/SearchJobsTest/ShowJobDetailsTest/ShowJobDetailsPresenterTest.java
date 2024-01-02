package com.example.networkmeup.view.SearchJobsTest.ShowJobDetailsTest;

import com.example.networkmeup.dao.Initializer;
import com.example.networkmeup.daoMemory.MemoryInitializer;
import com.example.networkmeup.domain.Job;
import com.example.networkmeup.view.SearchJobs.ShowJobDetails.ShowJobDetailsPresenter;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class ShowJobDetailsPresenterTest {
    private ShowJobDetailsPresenter presenter;
    private ShowJobDetailsViewStub stub;


    @Before
    public void setup(){
        stub = new ShowJobDetailsViewStub();
        presenter = new ShowJobDetailsPresenter(stub, "john.Brown12@gmail.com", new Job("Job Title", "Job Description"));
        new MemoryInitializer().prepareData();
    }

    @Test
    public void checkEmptyCoverLetter(){
        stub.setCoverLetter(null);
        presenter.onSendApplication();
        Assert.assertEquals("Cover Letter must not be empty!", stub.getLastMessagePassed());
    }

    @Test
    public void checkValidCoverLetter(){
        stub.setCoverLetter("Cover Letter Test");
        presenter.onSendApplication();
        Assert.assertEquals("Cover Letter Test", stub.getCoverLetter());
        Assert.assertEquals("john.Brown12@gmail.com", stub.getLastTokenPassed());
    }
}
