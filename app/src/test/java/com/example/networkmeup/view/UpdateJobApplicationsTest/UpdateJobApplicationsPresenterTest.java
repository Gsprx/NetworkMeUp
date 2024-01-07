package com.example.networkmeup.view.UpdateJobApplicationsTest;

import com.example.networkmeup.daoMemory.EmployerDAOMemory;
import com.example.networkmeup.daoMemory.MemoryInitializer;
import com.example.networkmeup.domain.Email;
import com.example.networkmeup.domain.Job;
import com.example.networkmeup.view.UpdateJobApplications.UpdateJobApplicationsPresenter;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class UpdateJobApplicationsPresenterTest {
    private UpdateJobApplicationsPresenter presenter;
    private UpdateJobApplicationsViewStub stub;

    @Before
    public void setup(){
        new MemoryInitializer().prepareData();
        stub = new UpdateJobApplicationsViewStub();
        presenter = new UpdateJobApplicationsPresenter(stub, "b.be@northfreedom.com");
    }

    @After
    public void resetData(){
        new MemoryInitializer().prepareData();
    }

    @Test
    public void checkSelectJob(){
        Job job = new EmployerDAOMemory().getByEmail(new Email("b.be@northfreedom.com")).getJobs().get(0);

        presenter.onItemClick(job);

        Assert.assertEquals("b.be@northfreedom.com", stub.getLastPassedToken());
        Assert.assertEquals(true, job.equals(stub.getLastPassedJob()));
    }
}
