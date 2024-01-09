package com.example.networkmeup.view.UpdateJobApplicationsTest.ShowJobApplicationsTest;

import com.example.networkmeup.daoMemory.EmployeeDAOMemory;
import com.example.networkmeup.daoMemory.EmployerDAOMemory;
import com.example.networkmeup.daoMemory.MemoryInitializer;
import com.example.networkmeup.domain.Application;
import com.example.networkmeup.domain.Email;
import com.example.networkmeup.domain.Employee;
import com.example.networkmeup.domain.Employer;
import com.example.networkmeup.domain.Job;
import com.example.networkmeup.view.UpdateJobApplications.ShowJobApplications.ShowJobApplicationsPresenter;

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
        Employer employer = new EmployerDAOMemory().getByEmail(new Email("b.be@northfreedom.com"));
        Job job = employer.getJobs().get(0);

        Employee employee = new EmployeeDAOMemory().getByEmail(new Email("john.Brown12@gmail.com"));

        Application application = new Application(employee,"Cover Letter");
        job.addApplication(application);

        presenter.onItemClick(application);

        job = new EmployerDAOMemory().getByEmail(new Email("b.be@northfreedom.com")).getJobs().get(0);

        Assert.assertEquals("b.be@northfreedom.com", stub.getLastPassedToken());
        Assert.assertEquals(true, job.equals(stub.getLastPassedJob()));
        Assert.assertEquals(application.getID(), stub.getLastPassedApplication().getID());
    }

    @Test
    public void checkExcludeNotPendingApplications(){
        //check if an application that was responded to is excluded from the pending applications return list
        Employer employer = new EmployerDAOMemory().getByEmail(new Email("b.be@northfreedom.com"));
        Job job = employer.getJobs().get(0);


        //add one application from John Brown that is rejected
        Employee employee1 = new EmployeeDAOMemory().getByEmail(new Email("john.Brown12@gmail.com"));
        Application application1 = new Application(employee1,"Cover Letter");
        application1.setStatus(false); //boolean answered should be true at this point

        job.addApplication(application1);

        //add one application from Mary Green that is unanswered marygreen.188@gmail.com
        Employee employee2 = new EmployeeDAOMemory().getByEmail(new Email("marygreen.188@gmail.com"));
        Application application2 = new Application(employee2,"Cover Letter 2");
        job.addApplication(application2); //boolean answered remains false

        Assert.assertEquals(1, presenter.getPendingApplications().size()); //show 0 applications because all of them at answered
        Assert.assertEquals(2, job.getApplications().size());   // data kept still has all the applications that are answered and not answered
        Assert.assertEquals("Cover Letter 2", presenter.getPendingApplications().get(0).getCoverLetter());//check if the correct application is pending
    }
}
