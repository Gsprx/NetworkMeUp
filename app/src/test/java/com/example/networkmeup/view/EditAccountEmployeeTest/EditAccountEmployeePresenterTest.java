package com.example.networkmeup.view.EditAccountEmployeeTest;

import com.example.networkmeup.daoMemory.MemoryInitializer;
import com.example.networkmeup.domain.Email;
import com.example.networkmeup.domain.Employee;
import com.example.networkmeup.domain.Password;
import com.example.networkmeup.domain.Phone;
import com.example.networkmeup.view.EditAccountEmployee.EditAccountEmployeePresenter;
import com.example.networkmeup.view.EditAccountEmployeeTest.EditAccountEmployeeViewStub;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class EditAccountEmployeePresenterTest {
    private EditAccountEmployeePresenter presenter;
    private EditAccountEmployeeViewStub viewStub;

    @Before
    public void setUp() {
        new MemoryInitializer().prepareData();
        viewStub = new EditAccountEmployeeViewStub();
        presenter = new EditAccountEmployeePresenter(viewStub);
    }

    @Test
    public void testOnCreate_AllFieldsValid() {
        // Simulate valid input in the fields
        viewStub.setNameField("");
        viewStub.setAddressField("");
        viewStub.setEmailField("b.be@northfreedom.com");
        viewStub.setPhoneField("5693311692");
        viewStub.setPasswordField("UwL[;3{[fQP:");

        presenter.onCreate();

        // Assert that no error messages were shown (fields are valid)
        Assert.assertNull(viewStub.getShowErrorMessageMsg());
        Assert.assertNull(viewStub.getShowErrorMessageTitle());

        // Assert that employee information is updated properly when all fields are valid
        Employee updatedEmployee = viewStub.getCurrEmployee();
        String name = updatedEmployee.getName();
        String Address = updatedEmployee.getAddress();
        Email email = updatedEmployee.getEmail();
        Phone phone = updatedEmployee.getPhone();
        Password password = updatedEmployee.getPassword();


    }


}
