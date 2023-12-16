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

    @Before
    public void setup(){
        app = new Application(new Employee(new Email("employ@example.com"),
                new Phone("5658274859"), new Password("Test1234!")), "cover letter test");
    }

    @Test
    public void nullEmployeeCheck(){
        Assert.assertThrows(NullPointerException.class, ()->{
            app = new Application(null,"cover letter");
        });
    }

    @Test
    public void nullCoverLetterCheck(){
        Assert.assertThrows(NullPointerException.class, ()->{
            app = new Application(new Employee(new Email("employ@example.com"),
                    new Phone("5658274859"), new Password("Test1234!")),null);
        });
    }

    @Test
    public void validStatusCheck(){
        app.setStatus(true);
        Assert.assertEquals(true, app.getStatus());
    }
    @Test
    public void validIDCheck(){
        app.setID(10);
        Assert.assertEquals((int)10, (int)app.getID());
    }

    @Test
    public void validEmployeeCheck(){
        Assert.assertEquals("employ@example.com", app.getEmployee().getEmail().getAddress());
    }

    @Test
    public void validCoverLetterCheck(){
        Assert.assertEquals("cover letter test", app.getCoverLetter());
    }

}
