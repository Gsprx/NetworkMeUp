package com.example.networkmeup.domain;

import com.example.networkmeup.domain.Email;
import com.example.networkmeup.domain.Employer;
import com.example.networkmeup.domain.Job;
import com.example.networkmeup.domain.Password;
import com.example.networkmeup.domain.Phone;
import com.example.networkmeup.domain.TIN;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class EmployerTest {
    private Employer employer;

    @Before
    public void setup(){
        employer = new Employer(new Email("employ@example.com"),
                new Phone("5658274859"), new Password("Test1234!"), new TIN("000001010"));
    }

    @Test
    public void nullJobCheck(){
        Assert.assertThrows(NullPointerException.class, ()->{
           employer.addJob(null);
        });
    }
    @Test
    public void nullCompanyNameCheck(){
        Assert.assertThrows(NullPointerException.class, ()->{
            employer.setCompanyName(null);
        });
    }
    @Test
    public void nullSectorCheck(){
        Assert.assertThrows(NullPointerException.class, ()->{
            employer.setSector(null);
        });
    }
    @Test
    public void nullEmailCheck(){
        Assert.assertThrows(NullPointerException.class, ()->{
            employer.setEmail(null);
        });
    }

    @Test
    public void nullPasswordCheck(){
        Assert.assertThrows(NullPointerException.class, ()->{
            employer.setPassword(null);
        });
    }
    @Test
    public void nullPhoneCheck(){
        Assert.assertThrows(NullPointerException.class, ()->{
            employer.setPhone(null);
        });
    }
    @Test
    public void nullTINCheck(){
        Assert.assertThrows(NullPointerException.class, ()->{
            employer.setTin(null);
        });
    }

    @Test
    public void validCompanyNameCheck(){
        employer.setCompanyName("Coca Cola");
        Assert.assertEquals("Coca Cola", employer.getCompanyName());
    }
    @Test
    public void validSectorCheck(){
        employer.setSector("Sector");
        Assert.assertEquals("Sector", employer.getSector());
    }
    @Test
    public void validEmailCheck(){
        employer.setEmail(new Email("employerTest1@gmail.com"));
        Assert.assertEquals("employerTest1@gmail.com", employer.getEmail().getAddress());
    }

    @Test
    public void validPhoneCheck(){
        employer.setPhone(new Phone("8673859245"));
        Assert.assertEquals("8673859245", employer.getPhone().getNumber());
    }

    @Test
    public void validPasswordCheck(){
        employer.setPassword(new Password("TestTest124!"));
        Assert.assertEquals("TestTest124!", employer.getPassword().getPassword());
    }
    @Test
    public void validTINCheck(){
        employer.setTin(new TIN("000001010"));
        Assert.assertEquals("000001010", employer.getTin().getTin());
    }
    @Test
    public void validJobCheck(){
        employer.addJob(new Job("Example Job", "This is an Example Job"));
        Assert.assertEquals("Example Job", employer.getJobs().get(0).getTitle());
    }
}
