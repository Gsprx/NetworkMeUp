package com.example.networkmeup.view.UpdateJobApplicationsTest.ShowJobApplicationsTest;

import com.example.networkmeup.daoMemory.EmployerDAOMemory;
import com.example.networkmeup.daoMemory.MemoryInitializer;
import com.example.networkmeup.domain.Email;
import com.example.networkmeup.domain.Job;
import com.example.networkmeup.view.UpdateJobApplications.ShowJobApplications.ShowJobApplicationsPresenter;
import com.example.networkmeup.view.UpdateJobApplications.ShowJobApplications.ShowJobApplicationsView;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class ShowJobApplicationsPresenterTest {
    private ShowJobApplicationsPresenter presenter;
    private ShowJobApplicationsViewStub stub;

    @Before
    public void setup(){
        new MemoryInitializer().prepareData();
        stub = new ShowJobApplicationsViewStub();
        presenter = new ShowJobApplicationsPresenter(stub, "b.be@northfreedom.com", new EmployerDAOMemory().getByEmail(new Email("b.be@northfreedom.com")).getJobs().get(0));
    }

    @After
    public void resetData(){
        new MemoryInitializer().prepareData();
    }

    @Test
    public void checkSelectApplication(){
        presenter.onItemClick(0);

        Job job = new EmployerDAOMemory().getByEmail(new Email("b.be@northfreedom.com")).getJobs().get(0);

        Assert.assertEquals("b.be@northfreedom.com", stub.getLastPassedToken());
        Assert.assertEquals(true, job.equals(stub.getLastPassedJob()));
        Assert.assertEquals(0, stub.getLastPassedPosition());
    }
}
