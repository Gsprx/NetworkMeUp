package com.example.networkmeup.view.EditAccountEmployer;

import com.example.networkmeup.domain.Email;
import com.example.networkmeup.domain.Employer;
import com.example.networkmeup.domain.Password;
import com.example.networkmeup.domain.Phone;
import com.example.networkmeup.domain.TIN;

public interface EditAccountEmployerView {
    public String getCompanyName() throws RuntimeException;
    public String getSector() throws RuntimeException;
    public Email getEmail() throws RuntimeException;

    public Password getPassword() throws RuntimeException;

    public TIN getTIN() throws RuntimeException;

    public Phone getPhoneNumber() throws  RuntimeException;
    public void showErrorMessage(String title, String message);
    // Method to handle successful account change
    void successfullyFinishActivity(String message, String userToken);

    public Employer getCurrEmployer();
}

