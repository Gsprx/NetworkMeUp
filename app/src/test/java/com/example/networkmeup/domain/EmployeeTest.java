package com.example.networkmeup.domain;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.Date;

/**
 * This class contains unit tests for the Employee class.
 * It aims to verify the functionalities and behaviors of the Employee class methods.
 */
public class EmployeeTest {
    private Employee emp;

    // Initializes an Employee instance for testing purposes.
    @Before
    public void setup(){
        emp = new Employee(new Email("employ@example.com"),
                new Phone("5658274859"), new Password("Test1234!"));
    }

    // Tests if adding a null application throws a NullPointerException.
    @Test
    public void nullApplicationCheck() {
        Assert.assertThrows(NullPointerException.class, ()->{
            emp.addApplication(null);
        });
    }

    // Tests if setting the email to null throws a NullPointerException.
    @Test
    public void nullEmailCheck(){
        Assert.assertThrows(NullPointerException.class, ()->{
           emp.setEmail(null);
        });
    }

    // Validates if setting the address to null throws a NullPointerException.
    @Test
    public void nullAddressCheck(){
        Assert.assertThrows(NullPointerException.class, ()->{
            emp.setAddress(null);
        });
    }

    // Ensures that setting the date of birth to null throws a NullPointerException.
    @Test
    public void nullDoBCheck(){
        Assert.assertThrows(NullPointerException.class, ()->{
            emp.setDateOfBirth(null);
        });
    }

    // Verifies that setting the profile image to null throws a NullPointerException.
    @Test
    public void nullProfileImageCheck(){
        Assert.assertThrows(NullPointerException.class, ()->{
            emp.setProfileImage(null);
        });
    }

    // Tests if setting the name to null throws a NullPointerException.
    @Test
    public void nullNameCheck(){
        Assert.assertThrows(NullPointerException.class, ()->{
            emp.setName(null);
        });
    }

    // Checks if setting the CV to null throws a NullPointerException.
    @Test
    public void nullCVCheck(){
        Assert.assertThrows(NullPointerException.class, ()->{
            emp.setCV(null);
        });
    }

    // Validates if setting the password to null throws a NullPointerException.
    @Test
    public void nullPasswordCheck(){
        Assert.assertThrows(NullPointerException.class, ()->{
            emp.setPassword(null);
        });
    }

    // Tests if setting the phone to null throws a NullPointerException.
    @Test
    public void nullPhoneCheck(){
        Assert.assertThrows(NullPointerException.class, ()->{
            emp.setPhone(null);
        });
    }

    // Validates if setting a valid email updates the employee's email address.
    @Test
    public void validEmailCheck(){
        emp.setEmail(new Email("example2@email.com"));
        Assert.assertEquals("example2@email.com", emp.getEmail().getAddress());
    }

    // Tests if setting a valid password updates the employee's password.
    @Test
    public void validPasswordCheck(){
        emp.setPassword(new Password("TestTest124!"));
        Assert.assertEquals("TestTest124!", emp.getPassword().getPassword());
    }

    // Checks if setting a valid phone number updates the employee's phone number.
    @Test
    public void validPhoneCheck(){
        emp.setPhone(new Phone("8673859245"));
        Assert.assertEquals("8673859245", emp.getPhone().getNumber());
    }

    // Verifies if adding a valid application updates the employee's application list.
    @Test
    public void validApplicationCheck(){
        emp.addApplication(new Application(emp,"cover letter test"));
        Assert.assertEquals("cover letter test", emp.getApplications().get(0).getCoverLetter());
    }

    // Tests if setting a valid name updates the employee's name.
    @Test
    public void validNameCheck(){
        emp.setName("Giannhs");
        Assert.assertEquals("Giannhs", emp.getName());
    }

    // Ensures that setting a valid address updates the employee's address.
    @Test
    public void validAddressCheck(){
        emp.setAddress("Spiti tou, 12 Athens");
        Assert.assertEquals("Spiti tou, 12 Athens", emp.getAddress());
    }

    // Verifies if setting a valid date of birth updates the employee's date of birth.
    @Test
    public void validDoBCheck(){
        Date testDate = new Date();
        testDate.setTime(775755755L);
        emp.setDateOfBirth(testDate);
        Assert.assertEquals(775755755L, emp.getDateOfBirth().getTime());
    }

    // Tests if setting a valid profile image updates the employee's profile image path.
    @Test
    public void validProfileImageCheck(){
        emp.setProfileImage("./database/images/image.png");
        Assert.assertEquals("./database/images/image.png", emp.getProfileImage());
    }

    // Validates if setting a valid CV updates the employee's CV.
    @Test
    public void validCVCheck(){
        CV testcv = new CV();
        testcv.setEducation(new Education("self taught", new ExpertiseArea("Cooking"), LevelOfStudies.Amateur));
        emp.setCV(testcv);
        Assert.assertEquals("self taught", emp.getCV().getEducation().get(0).getDescription());
    }

    // Tests if the 'equals' method in the Employee class correctly identifies two employees as equal.
    @Test
    public void validEqualsCheck(){
        Employee emp2 = new Employee(emp.getEmail(), emp.getPhone(), new Password("ValidPaswd12!"));
        Assert.assertEquals(true, emp.equals(emp2));
    }

    // Tests if the 'equals' method in the Employee class correctly identifies two different employees as not equal.
    @Test
    public void validNotEqualsCheck(){
        Employee emp2 = new Employee(new Email("exampleEmail@email.com"), new Phone("4859285724"), emp.getPassword());
        Assert.assertEquals(false, emp.equals(emp2));
    }

    // Tests if the 'equals' method in the Employee class throws a NullPointerException when comparing to null.
    @Test
    public void nullEqualsCheck(){
        Assert.assertThrows(NullPointerException.class, ()->{
            emp.equals(null);
        });
    }

    // Tests the 'hasEmail' method in the Employee class by checking if an employee has a specific email address.
    @Test
    public void checkHasEmail(){
        //check if different emails return false
        Assert.assertEquals(false, emp.hasEmail(new Email("thisisthewrongemail@email.com")));
        //check if the same email returns true
        Assert.assertEquals(true, emp.hasEmail(new Email("employ@example.com")));
    }

}
