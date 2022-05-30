package com.example.dislinktagentskaapp.model;

import com.example.dislinktagentskaapp.dto.UserDTO;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Document
public class User {

    @Id
    public String id;
    public String firstName;
    public String lastName;
    public String username;
    public String password;
    public String key;
    public String email;
    public String address;
    public String phoneNumber;
    public Date dateOfBirth;

    public Role role;
    public boolean isVerified;
    public List<Company> companies;

    public User() {}
    public User(String firstName,
                String lastName,
                String username,
                String password,
                String email,
                String address,
                String phoneNumber,
                Date dateOfBirth){

        String id = java.util.UUID.randomUUID().toString();
        String key = java.util.UUID.randomUUID().toString();
        this.id = "user_" + id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.username = username;
        this.password = password;
        this.key = key;
        this.email = email;
        this.address = address;
        this.phoneNumber = phoneNumber;
        this.dateOfBirth = dateOfBirth;
        this.role = Role.USER;
        this.isVerified = true;
        this.companies = new ArrayList<>();
    }

    public User(UserDTO userDTO){

        String id = java.util.UUID.randomUUID().toString();
        String key = java.util.UUID.randomUUID().toString();
        this.id = "user_" + id;
        this.firstName = userDTO.firstName;
        this.lastName = userDTO.lastName;
        this.username = userDTO.username;
        this.password = userDTO.password;
        this.key = key;
        this.email = userDTO.email;
        this.address = userDTO.address;
        this.phoneNumber = userDTO.phoneNumber;
        this.dateOfBirth = userDTO.dateOfBirth;
        this.role = Role.USER;
        this.isVerified = true;
        this.companies = new ArrayList<>();

    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
