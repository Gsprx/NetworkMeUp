package com.example.networkmeup.daoMemory;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

import com.example.networkmeup.domain.Email;
import com.example.networkmeup.domain.Employer;
import com.example.networkmeup.domain.Job;
import com.example.networkmeup.domain.Password;
import com.example.networkmeup.domain.Phone;
import com.example.networkmeup.domain.TIN;

import java.util.ArrayList;

public class EmployerdaoMemoryTest {
    private EmployerDAOMemory employerDAO;

    @Before
    public void setUp() {
        // Initialize the EmployerDAOMemory before each test
        MemoryInitializer mem = new MemoryInitializer();
        mem.prepareData();
        employerDAO = new EmployerDAOMemory();
    }

    @Test
    public void testSaveAndGetAll() {
        // Create a sample employer
        Employer employer = new Employer(new Email("b.be@northfreedom.com"), new Phone("5693311692"), new Password("UwL[;3{[fQP:"), new TIN("000001010"));

        // Save the employer
        employerDAO.save(employer);

        // Retrieve all employers
        ArrayList<Employer> allEmployers = employerDAO.getAll();

        // Check if the saved employer is in the list
        assertTrue(allEmployers.contains(employer));
    }

    @Test
    public void testDelete() {
        // Create a sample employer
        Employer employer = new Employer(new Email("b.be@northfreedom.com"), new Phone("5693311692"), new Password("UwL[;3{[fQP:"), new TIN("000001010"));

        // Save the employer
        employerDAO.save(employer);

        // Delete the employer
        employerDAO.delete(employer);

        // Retrieve all employers
        ArrayList<Employer> allEmployers = employerDAO.getAll();

        // Check if the deleted employer is not in the list
        assertFalse(allEmployers.contains(employer));
    }

    @Test
    public void testFind() {
        // Create a sample employer
        Employer employer = new Employer(new Email("b.be@northfreedom.com"), new Phone("5693311692"), new Password("UwL[;3{[fQP:"), new TIN("000001010"));

        // Save the employer
        employerDAO.save(employer);

        // Check if the employer exists in the DAO
        assertTrue(employerDAO.find(employer));

        // Create another employer not saved in the DAO
        Employer nonExistentEmployer = new Employer(new Email("kysss.com"), new Phone("56933116743"), new Password("UwL[;3{[fQP:"), new TIN("000010101"));

        // Check if the non-existent employer is not in the DAO
        assertFalse(employerDAO.find(nonExistentEmployer));
    }

    @Test
    public void testGetByEmail() {
        // Create a sample employer
        Employer employer = new Employer(new Email("b.be@northfreedom.com"), new Phone("5693311692"), new Password("UwL[;3{[fQP:"), new TIN("000001010"));

        // Save the employer
        employerDAO.save(employer);

        // Retrieve the employer by email
        Employer retrievedEmployer = employerDAO.getByEmail(new Email("b.be@northfreedom.com"));

        // Check if the retrieved employer is the same as the saved employer
        assertEquals(employer, retrievedEmployer);

        // Try to retrieve a non-existent employer by email
        Employer nonExistentEmployer = employerDAO.getByEmail(new Email("nonexistent@example.com"));

        // Check if the result is null for a non-existent employer
        assertNull(nonExistentEmployer);
    }

    @Test
    public void testAuthenticate() {
        // Create a sample employer
        Employer employer = new Employer(new Email("b.be@northfreedom.com"), new Phone("5693311692"), new Password("UwL[;3{[fQP:"), new TIN("000001010"));

        // Save the employer
        employerDAO.save(employer);

        // Authenticate with correct credentials
        assertTrue(employerDAO.authenticate(new Email("b.be@northfreedom.com"), new Password("UwL[;3{[fQP:")));

        // Authenticate with incorrect password
        assertFalse(employerDAO.authenticate(new Email("b.be@northfreedom.com"), new Password("wrongpassword")));

        // Authenticate with incorrect email
        assertFalse(employerDAO.authenticate(new Email("nonexistent@example.com"), new Password("UwL[;3{[fQP:")));
    }

    @Test
    public void testGetByJob() {
        // Create a sample employer with a job
        Employer employer = new Employer(new Email("b.be@northfreedom.com"), new Phone("5693311692"), new Password("UwL[;3{[fQP:"), new TIN("000001010"));

        Job job = new Job("Software Developer", "Full-time");
        employer.addJob(job);

        // Save the employer
        employerDAO.save(employer);

        // Retrieve the employer by job
        Employer retrievedEmployer = employerDAO.getByJob(job);

        // Check if the retrieved employer is the same as the saved employer
        assertEquals(employer, retrievedEmployer);

        // Try to retrieve an employer by a non-existent job
        Job nonExistentJob = new Job("Non-existent Job", "Part-time");
        Employer nonExistentEmployer = employerDAO.getByJob(nonExistentJob);

        // Check if the result is null for a non-existent job
        assertNull(nonExistentEmployer);
    }
}
