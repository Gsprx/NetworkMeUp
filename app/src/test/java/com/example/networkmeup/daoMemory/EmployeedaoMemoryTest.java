package com.example.networkmeup.daoMemory;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

import com.example.networkmeup.domain.Email;
import com.example.networkmeup.domain.Employee;
import com.example.networkmeup.domain.Password;
import com.example.networkmeup.domain.Phone;

import java.util.ArrayList;

public class EmployeedaoMemoryTest {
    private EmployeeDAOMemory employeeDAO;

    @Before
    public void setUp() {
        // Initialize the EmployeeDAOMemory before each test
        employeeDAO = new EmployeeDAOMemory();
    }

    @Test
    public void testSaveAndGetAll() {
        // Create a sample employee
        Employee employee = new Employee( new Email("john.Brown12@gmail.com"),new Phone("6977264561"), new Password("JohnBrown!12"));

        // Save the employee
        employeeDAO.save(employee);

        // Retrieve all employees
        ArrayList<Employee> allEmployees = employeeDAO.getAll();

        // Check if the saved employee is in the list
        assertTrue(allEmployees.contains(employee));
    }

    @Test
    public void testDelete() {
        // Create a sample employee

        Employee employee = new Employee( new Email("john.Brown12@gmail.com"),new Phone("6977264561"), new Password("JohnBrown!12"));

        // Save the employee
        employeeDAO.save(employee);

        // Delete the employee
        employeeDAO.delete(employee);

        // Retrieve all employees
        ArrayList<Employee> allEmployees = employeeDAO.getAll();

        // Check if the deleted employee is not in the list
        assertFalse(allEmployees.contains(employee));
    }

    @Test
    public void testFind() {
        // Create a sample employee
        Employee employee = new Employee( new Email("john.Brown12@gmail.com"),new Phone("6977264561"), new Password("JohnBrown!12"));

        // Save the employee
        employeeDAO.save(employee);
        // Check if the employee exists in the DAO
        assertTrue(employeeDAO.find(employee));

        // Create another employee not saved in the DAO
        Employee nonExistentEmployee = new Employee( new Email("alice@example.com"), new Phone("6987840184"),new Password("password123!"));

        // Check if the non-existent employee is not in the DAO
        assertFalse(employeeDAO.find(nonExistentEmployee));
    }

    @Test
    public void testGetByEmail() {
        // Create a sample employee
        Employee employee = new Employee( new Email("john.Brown12@gmail.com"),new Phone("6977264561"), new Password("JohnBrown!12"));

        // Save the employee
        employeeDAO.save(employee);

        // Retrieve the employee by email
        Employee retrievedEmployee = employeeDAO.getByEmail(new Email("john.Brown12@gmail.com"));
        // Check if the retrieved employee is the same as the saved employee
        assertEquals(employee, retrievedEmployee);

        // Try to retrieve a non-existent employee by email
        Employee nonExistentEmployee = employeeDAO.getByEmail(new Email("nonexistent@example.com"));

        // Check if the result is null for a non-existent employee
        assertNull(nonExistentEmployee);
    }

    @Test
    public void testAuthenticate() {
        // Create a sample employee
        Employee employee = new Employee( new Email("john.Brown12@gmail.com"),new Phone("6977264561"), new Password("JohnBrown!12"));
        // Save the employee
        employeeDAO.save(employee);

        // Authenticate with correct credentials
        assertTrue(employeeDAO.authenticate(new Email("john.Brown12@gmail.com"), new Password("JohnBrown!12")));

        // Authenticate with incorrect password
        //assertFalse(employeeDAO.authenticate(new Email("john.Brown12@gmail.com"), new Password("wrongpassword")));

        // Authenticate with incorrect email
        assertFalse(employeeDAO.authenticate(new Email("nonexistent@example.com"), new Password("JohnBrown!12")));
    }
}
