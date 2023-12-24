package com.example.networkmeup.domain;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.Date;

public class EmployeeTest {
    private Employee emp;

    @Before
    public void setup(){
        emp = new Employee(new Email("employ@example.com"),
                new Phone("5658274859"), new Password("Test1234!"));
    }

    @Test
    public void nullApplicationCheck() {
        Assert.assertThrows(NullPointerException.class, ()->{
            emp.addApplication(null);
        });
    }

    @Test
    public void nullEmailCheck(){
        Assert.assertThrows(NullPointerException.class, ()->{
           emp.setEmail(null);
        });
    }

    @Test
    public void nullAddressCheck(){
        Assert.assertThrows(NullPointerException.class, ()->{
            emp.setAddress(null);
        });
    }
    @Test
    public void nullDoBCheck(){
        Assert.assertThrows(NullPointerException.class, ()->{
            emp.setDateOfBirth(null);
        });
    }

    @Test
    public void nullProfileImageCheck(){
        Assert.assertThrows(NullPointerException.class, ()->{
            emp.setProfileImage(null);
        });
    }
    @Test
    public void nullNameCheck(){
        Assert.assertThrows(NullPointerException.class, ()->{
            emp.setName(null);
        });
    }
    @Test
    public void nullCVCheck(){
        Assert.assertThrows(NullPointerException.class, ()->{
            emp.setCV(null);
        });
    }
    @Test
    public void nullPasswordCheck(){
        Assert.assertThrows(NullPointerException.class, ()->{
            emp.setPassword(null);
        });
    }

    @Test
    public void nullPhoneCheck(){
        Assert.assertThrows(NullPointerException.class, ()->{
            emp.setPhone(null);
        });
    }

    @Test
    public void validEmailCheck(){
        emp.setEmail(new Email("example2@email.com"));
        Assert.assertEquals("example2@email.com", emp.getEmail().getAddress());
    }

    @Test
    public void validPasswordCheck(){
        emp.setPassword(new Password("TestTest124!"));
        Assert.assertEquals("TestTest124!", emp.getPassword().getPassword());
    }
    @Test
    public void validPhoneCheck(){
        emp.setPhone(new Phone("8673859245"));
        Assert.assertEquals("8673859245", emp.getPhone().getNumber());
    }
    @Test
    public void validApplicationCheck(){
        emp.addApplication(new Application(emp,"cover letter test"));
        Assert.assertEquals("cover letter test", emp.getApplications().get(0).getCoverLetter());
    }
    @Test
    public void validNameCheck(){
        emp.setName("Giannhs");
        Assert.assertEquals("Giannhs", emp.getName());
    }

    @Test
    public void validAddressCheck(){
        emp.setAddress("Spiti tou, 12 Athens");
        Assert.assertEquals("Spiti tou, 12 Athens", emp.getAddress());
    }

    @Test
    public void validDoBCheck(){
        Date testDate = new Date();
        testDate.setTime(775755755L);
        emp.setDateOfBirth(testDate);
        Assert.assertEquals(775755755L, emp.getDateOfBirth().getTime());
    }

    @Test
    public void validProfileImageCheck(){
        emp.setProfileImage("./database/images/image.png");
        Assert.assertEquals("./database/images/image.png", emp.getProfileImage());
    }

    @Test
    public void validCVCheck(){
        CV testcv = new CV();
        testcv.setEducation(new Education("self taught", new ExpertiseArea("Cooking"), LevelOfStudies.Amateur));
        emp.setCV(testcv);
        Assert.assertEquals("self taught", emp.getCV().getEducation().get(0).getDescription());
    }
    @Test
    public void validEqualsCheck(){
        Employee emp2 = new Employee(emp.getEmail(), emp.getPhone(), new Password("ValidPaswd12!"));
        Assert.assertEquals(true, emp.equals(emp2));
    }

    @Test
    public void validNotEqualsCheck(){
        Employee emp2 = new Employee(new Email("exampleEmail@email.com"), new Phone("4859285724"), emp.getPassword());
        Assert.assertEquals(false, emp.equals(emp2));
    }

    @Test
    public void nullEqualsCheck(){
        Assert.assertThrows(NullPointerException.class, ()->{
            emp.equals(null);
        });
    }

    @Test
    public void checkHasEmail(){
        //check if different emails return false
        Assert.assertEquals(false, emp.hasEmail(new Email("thisisthewrongemail@email.com")));
        //check if the same email returns true
        Assert.assertEquals(true, emp.hasEmail(new Email("employ@example.com")));
    }

}
