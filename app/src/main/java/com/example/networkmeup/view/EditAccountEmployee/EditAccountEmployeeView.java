package com.example.networkmeup.view.EditAccountEmployee;

import com.example.networkmeup.domain.Email;
import com.example.networkmeup.domain.Employee;
import com.example.networkmeup.domain.Password;
import com.example.networkmeup.domain.Phone;

public interface EditAccountEmployeeView {
    public Email getEmail() throws RuntimeException;

    public Password getPassword() throws RuntimeException;

    public Phone getPhoneNumber() throws  RuntimeException;
    public void showErrorMessage(String title, String message);
    public void successfullyFinishActivity(String message);
    String getAddress() throws RuntimeException;

    String getName() throws RuntimeException;
}
