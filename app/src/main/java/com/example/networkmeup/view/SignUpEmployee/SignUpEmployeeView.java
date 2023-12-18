package com.example.networkmeup.view.SignUpEmployee;

import com.example.networkmeup.domain.Email;
import com.example.networkmeup.domain.Password;
import com.example.networkmeup.domain.Phone;

public interface SignUpEmployeeView {
    public Email getEmail();
    public Phone getPhone();
    public Password getPassword();
    public void showErrorMessage(String title, String message);
    public void successfullyFinishActivity(String message);
}
