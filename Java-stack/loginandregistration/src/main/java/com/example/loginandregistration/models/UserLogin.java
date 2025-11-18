package com.example.loginandregistration.models;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public class UserLogin {

    @NotBlank
    @Email(message="Please Enter a valid email")
    private String loginEmail;

    @NotBlank
    @Size(min = 8,max = 128,message="Password must be between 8 and 128 characters")
    private String loginPassword;

    public UserLogin() {
    }

    public UserLogin(String loginEmail,String loginPassword) {
        this.loginEmail = loginEmail;
        this.loginPassword = loginPassword;
    }

    public String getLoginEmail() {
        return loginEmail;
    }

    public void setLoginEmail(String loginEmail) {
        this.loginEmail = loginEmail;
    }

    public String getLoginPassword() {
        return loginPassword;
    }

    public void setLoginPassword(String loginPassword) {
        this.loginPassword = loginPassword;
    }

    


}