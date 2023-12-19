package com.example.networkmeup.view.SignUpEmployee;

import com.example.networkmeup.domain.Email;
import com.example.networkmeup.domain.Password;
import com.example.networkmeup.domain.Phone;

public interface SignUpEmployeeView {
    public Email getEmail() throws RuntimeException;
    public Phone getPhone() throws RuntimeException;
    public Password getPassword() throws  RuntimeException;
    public void showErrorMessage(String title, String message);
    public void successfullyFinishActivity(String message);
}
