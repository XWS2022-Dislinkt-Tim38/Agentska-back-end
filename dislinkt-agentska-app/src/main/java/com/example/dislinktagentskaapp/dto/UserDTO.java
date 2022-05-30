package com.example.dislinktagentskaapp.dto;

import com.example.dislinktagentskaapp.model.Company;
import com.example.dislinktagentskaapp.model.Role;
import com.example.dislinktagentskaapp.model.User;

import java.util.Date;
import java.util.List;

public class UserDTO {

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

    public UserDTO(User user){
        this.id = user.id;
        this.firstName = user.firstName;
        this.lastName = user.lastName;
        this.username = user.username;
        this.password = user.password;
        this.key = user.key;
        this.email = user.email;
        this.address = user.address;
        this.phoneNumber = user.phoneNumber;
        this.dateOfBirth = user.dateOfBirth;
        this.role = user.role;
        this.isVerified = user.isVerified;
        this.companies = user.companies;
    }
}
