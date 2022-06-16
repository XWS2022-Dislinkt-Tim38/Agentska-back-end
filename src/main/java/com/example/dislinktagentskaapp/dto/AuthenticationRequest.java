package com.example.dislinktagentskaapp.dto;

public class AuthenticationRequest {
    private String username;
    private String password;
    private String mfaCode;

    public String getUsername() {
        return username;
    }
    public String getPassword() {
        return password;
    }
    public String getMfaCode() {
        return mfaCode;
    }


    public void setUsername(String username) {
        this.username = username;
    }
    public void setPassword(String password) {
        this.password = password;
    }
    public void setMfacode(String mfaCode) {
        this.mfaCode = mfaCode;
    }

    public AuthenticationRequest(String username, String password, String mfacode) {
        this.username = username;
        this.password = password;
        this.mfaCode = mfacode;
    }
}
