package com.example.networkmeup.view.SearchJobsTest;

import com.example.networkmeup.daoMemory.MemoryInitializer;
import com.example.networkmeup.domain.Job;
import com.example.networkmeup.view.SearchJobs.SearchJobsPresenter;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

public class SearchJobsPresenterTest {
    private SearchJobsPresenter presenter;
    private SearchJobsViewStub stub;

    @Before
    public void setup(){
        stub = new SearchJobsViewStub();
        new MemoryInitializer().prepareData();
    }

    @Test
    public void checkNoJobsFound(){
        //testing onCreate
        String userToken = "marygreen.188@gmail.com"; //employee who doesn't match with any jobs
        presenter = new SearchJobsPresenter(stub,userToken);
        ArrayList<Job> jobsFound = presenter.onCreate();
        Assert.assertEquals(0, jobsFound.size());
        Assert.assertEquals("Unfortunately there are no jobs that match with your CV. Please try again later.", stub.getLastMessagePassed());
        Assert.assertEquals(userToken, stub.getLastTokenPassed());
    }

    @Test
    public void checkJobsFound(){
        //testing onCreate
        String userToken = "john.Brown12@gmail.com"; //employee who matches with one job
        presenter = new SearchJobsPresenter(stub,userToken);
        ArrayList<Job> jobsFound = presenter.onCreate();
        Assert.assertEquals(1, jobsFound.size());

        //testing onItemClick
        presenter.onItemClick(jobsFound.get(0));
        Assert.assertEquals(userToken, stub.getLastTokenPassed());
        Assert.assertEquals("Finance Office - Part Time", stub.getJobTitle());
        Assert.assertEquals("We are hiring for our new Finance Office position at Philips. This job is part time employment, Mon-Fri 16.00-20.00", stub.getJobDescription());
    }
}
