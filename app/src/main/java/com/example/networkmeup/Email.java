package com.example.networkmeup;
import java.util.regex.Pattern;
public class Email {
    private String address;

    public Email (String address){

            //Common universal email address limitations
            String emailRegex = "^[a-zA-Z0-9_+&*-]+(?:\\.[a-zA-Z0-9_+&*-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,7}$";
            Pattern pattern = Pattern.compile(emailRegex);

            if (address == null){
                throw new NullPointerException("Email address cannot be empty.");
            }
            if (pattern.matcher(address).matches()) {
                this.address = address;
                return;
            }
            else{
                throw new IllegalArgumentException("Invalid email address.");
            }
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {

        //Common universal email address limitations
        String emailRegex = "^[a-zA-Z0-9_+&*-]+(?:\\.[a-zA-Z0-9_+&*-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,7}$";
        Pattern pattern = Pattern.compile(emailRegex);

        if (address == null){
            throw new NullPointerException("Email address cannot be empty.");
        }
        if (pattern.matcher(address).matches()) {
            this.address = address;
            return;
        }
        else{
            throw new IllegalArgumentException("Invalid email address.");
        }

    }
}
