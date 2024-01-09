package com.example.networkmeup.view.UpdateJobApplicationsTest.ShowJobApplicationsTest.ShowApplicationDetailsTest;

import android.database.MergeCursor;

import com.example.networkmeup.daoMemory.EmployeeDAOMemory;
import com.example.networkmeup.daoMemory.EmployerDAOMemory;
import com.example.networkmeup.daoMemory.MemoryInitializer;
import com.example.networkmeup.domain.Application;
import com.example.networkmeup.domain.Email;
import com.example.networkmeup.domain.Employee;
import com.example.networkmeup.domain.Employer;
import com.example.networkmeup.domain.Job;
import com.example.networkmeup.view.UpdateJobApplications.ShowJobApplications.ShowApplicationDetails.ShowApplicationDetailsPresenter;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class ShowApplicationDetailsPresenterTest {
    private ShowApplicationDetailsPresenter presenter;
    private ShowApplicationDetailsViewStub stub;


    @Before
    public void setup(){
        new MemoryInitializer().prepareData();

        //setup and add a mock application
        Employer employer = new EmployerDAOMemory().getByEmail(new Email("b.be@northfreedom.com"));
        Job job = employer.getJobs().get(0);

        Employee employee = new EmployeeDAOMemory().getByEmail(new Email("john.Brown12@gmail.com"));

        Application application = new Application(employee,"Cover Letter");

        job.addApplication(application);

        employee.addApplication(application);
        //create stub and presenter
        stub = new ShowApplicationDetailsViewStub();
        presenter = new ShowApplicationDetailsPresenter(stub,"b.be@northfreedom.com",
                new EmployerDAOMemory().getByEmail(new Email("b.be@northfreedom.com")).getJobs().get(0),new EmployerDAOMemory().getByEmail(new Email("b.be@northfreedom.com")).getJobs().get(0).getApplications().get(0));
    }
    @After
    public void resetData(){
        new MemoryInitializer().prepareData();
    }

    @Test
    public void checkRejectApplicant(){
        Employer employer = new EmployerDAOMemory().getByEmail(new Email("b.be@northfreedom.com"));
        Job job = employer.getJobs().get(0);

        Employee employee = new EmployeeDAOMemory().getByEmail(new Email("john.Brown12@gmail.com"));

        presenter = new ShowApplicationDetailsPresenter(stub,"b.be@northfreedom.com", job,job.getApplications().get(0));
        presenter.onReject();

        Assert.assertEquals("b.be@northfreedom.com", stub.getLastPassedToken());
        Assert.assertEquals(true, job.equals(stub.getLastPassedJob()));
        Assert.assertEquals(false, employee.getApplications().get(0).getStatus());

    }
    @Test
    public void checkAcceptApplicant(){
        Employer employer = new EmployerDAOMemory().getByEmail(new Email("b.be@northfreedom.com"));
        Job job = employer.getJobs().get(0);

        Employee employee = new EmployeeDAOMemory().getByEmail(new Email("john.Brown12@gmail.com"));

        presenter = new ShowApplicationDetailsPresenter(stub,"b.be@northfreedom.com", job,job.getApplications().get(0));
        presenter.onAccept();

        employee = new EmployeeDAOMemory().getByEmail(new Email("john.Brown12@gmail.com"));

        Assert.assertEquals("b.be@northfreedom.com", stub.getLastPassedToken());
        Assert.assertEquals(true, job.equals(stub.getLastPassedJob()));
        Assert.assertEquals(true, employee.getApplications().get(0).getStatus());

    }
}
