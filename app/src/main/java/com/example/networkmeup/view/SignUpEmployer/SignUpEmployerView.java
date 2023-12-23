package com.example.networkmeup.view.SignUpEmployer;

import com.example.networkmeup.domain.Email;
import com.example.networkmeup.domain.Password;
import com.example.networkmeup.domain.Phone;
import com.example.networkmeup.domain.TIN;


public interface SignUpEmployerView {
    public Email getEmail() throws RuntimeException;

    public Password getPassword() throws RuntimeException;

    public Phone getPhone() throws RuntimeException;

    public TIN getTIN() throws RuntimeException;

    public void showErrorMessage(String title, String message);

    public void successfullyFinishActivity(String message);

}
