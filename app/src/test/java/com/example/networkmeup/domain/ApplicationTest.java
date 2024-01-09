package com.example.networkmeup.domain;

import com.example.networkmeup.domain.Application;
import com.example.networkmeup.domain.Email;
import com.example.networkmeup.domain.Employee;
import com.example.networkmeup.domain.Password;
import com.example.networkmeup.domain.Phone;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class ApplicationTest {
    private Application app;

    // This method sets up an instance of the Application class with predefined Employee details and a cover letter for testing purposes.
    @Before
    public void setup(){
        app = new Application(new Employee(new Email("employ@example.com"),
                new Phone("5658274859"), new Password("Test1234!")), "cover letter test");
    }

    // Tests if NullPointerException is thrown when creating an Application object with null Employee.
    @Test
    public void nullEmployeeCheck(){
        Assert.assertThrows(NullPointerException.class, ()->{
            app = new Application(null,"cover letter");
        });
    }

    // Tests if NullPointerException is thrown when creating an Application object with null cover letter.
    @Test
    public void nullCoverLetterCheck(){
        Assert.assertThrows(NullPointerException.class, ()->{
            app = new Application(new Employee(new Email("employ@example.com"),
                    new Phone("5658274859"), new Password("Test1234!")),null);
        });
    }

    // Verifies if setStatus method sets the status of the Application correctly.
    @Test
    public void validStatusCheck(){
        app.setStatus(true);
        Assert.assertEquals(true, app.getStatus());
        Assert.assertEquals(true, app.getAnswered());
    }

    // Ensures that setID method sets the ID of the Application correctly.
    @Test
    public void validIDCheck(){
        app.setID(10);
        Assert.assertEquals((int)10, (int)app.getID());
    }

    // Validates if getEmployee method retrieves the correct email address of the Employee associated with the Application.
    @Test
    public void validEmployeeCheck(){
        Assert.assertEquals("employ@example.com", app.getEmployee().getEmail().getAddress());
    }

    // Checks if getCoverLetter method retrieves the correct cover letter associated with the Application.
    @Test
    public void validCoverLetterCheck(){
        Assert.assertEquals("cover letter test", app.getCoverLetter());
    }

}
