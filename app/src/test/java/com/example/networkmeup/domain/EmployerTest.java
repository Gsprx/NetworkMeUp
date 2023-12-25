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

/**
 * The EmployerTest class contains unit tests for the Employer class.
 * It aims to verify the functionalities and behaviors of the Employer class methods.
 */
public class EmployerTest {
    private Employer employer;

    /**
     * Initializing an Employer instance before each test method execution.
     */
    @Before
    public void setup(){
        employer = new Employer(new Email("employ@example.com"),
                new Phone("5658274859"), new Password("Test1234!"), new TIN("000001010"));
    }

    /**
     * Tests if adding a null job to an employer throws a NullPointerException.
     */
    @Test
    public void nullJobCheck(){
        Assert.assertThrows(NullPointerException.class, ()->{
           employer.addJob(null);
        });
    }

    /**
     * Tests if setting the company name of an employer to null throws a NullPointerException.
     */
    @Test
    public void nullCompanyNameCheck(){
        Assert.assertThrows(NullPointerException.class, ()->{
            employer.setCompanyName(null);
        });
    }

    /**
     * Tests if setting the sector of an employer to null throws a NullPointerException.
     */
    @Test
    public void nullSectorCheck(){
        Assert.assertThrows(NullPointerException.class, ()->{
            employer.setSector(null);
        });
    }

    /**
     * Tests if setting the email of an employer to null throws a NullPointerException.
     */
    @Test
    public void nullEmailCheck(){
        Assert.assertThrows(NullPointerException.class, ()->{
            employer.setEmail(null);
        });
    }

    /**
     * Tests if setting the password of an employer to null throws a NullPointerException.
     */
    @Test
    public void nullPasswordCheck(){
        Assert.assertThrows(NullPointerException.class, ()->{
            employer.setPassword(null);
        });
    }

    /**
     * Tests if setting the phone of an employer to null throws a NullPointerException.
     */
    @Test
    public void nullPhoneCheck(){
        Assert.assertThrows(NullPointerException.class, ()->{
            employer.setPhone(null);
        });
    }

    /**
     * Tests if setting the TIN (Tax Identification Number) of an employer to null throws a NullPointerException.
     */
    @Test
    public void nullTINCheck(){
        Assert.assertThrows(NullPointerException.class, ()->{
            employer.setTin(null);
        });
    }

    /**
     * Tests if setting the company name of an employer updates the company name correctly.
     */
    @Test
    public void validCompanyNameCheck(){
        employer.setCompanyName("Coca Cola");
        Assert.assertEquals("Coca Cola", employer.getCompanyName());
    }

    /**
     * Tests if setting the sector of an employer updates the sector correctly.
     */
    @Test
    public void validSectorCheck(){
        employer.setSector("Sector");
        Assert.assertEquals("Sector", employer.getSector());
    }

    /**
     * Tests if setting the email of an employer updates the email address correctly.
     */
    @Test
    public void validEmailCheck(){
        employer.setEmail(new Email("employerTest1@gmail.com"));
        Assert.assertEquals("employerTest1@gmail.com", employer.getEmail().getAddress());
    }

    /**
     * Tests if setting the phone number of an employer updates the phone number correctly.
     */
    @Test
    public void validPhoneCheck(){
        employer.setPhone(new Phone("8673859245"));
        Assert.assertEquals("8673859245", employer.getPhone().getNumber());
    }

    /**
     * Tests if setting the password of an employer updates the password correctly.
     */
    @Test
    public void validPasswordCheck(){
        employer.setPassword(new Password("TestTest124!"));
        Assert.assertEquals("TestTest124!", employer.getPassword().getPassword());
    }

    /**
     * Tests if setting the TIN (Tax Identification Number) of an employer updates the TIN correctly.
     */
    @Test
    public void validTINCheck(){
        employer.setTin(new TIN("000001010"));
        Assert.assertEquals("000001010", employer.getTin().getTin());
    }

    /**
     * Tests if adding a job to an employer updates the jobs list correctly.
     */
    @Test
    public void validJobCheck(){
        employer.addJob(new Job("Example Job", "This is an Example Job"));
        Assert.assertEquals("Example Job", employer.getJobs().get(0).getTitle());
    }

    /**
     * Tests if the 'checkHasEmail' method in the Employer class correctly checks if an employer has a specific email address.
     */
    @Test
    public void checkHasEmail(){
        //check if different emails return false
        Assert.assertEquals(false, employer.hasEmail(new Email("thisisthewrongemail@email.com")));
        //check if the same email returns true
        Assert.assertEquals(true, employer.hasEmail(new Email("employ@example.com")));
    }
}
