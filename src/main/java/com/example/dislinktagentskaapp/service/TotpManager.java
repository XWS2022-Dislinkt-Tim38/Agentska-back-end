package com.example.dislinktagentskaapp.service;

public interface TotpManager {

    String generateSecret();
    String getUriForImage(String secret);
    boolean verifyCode(String code, String secret);
}
