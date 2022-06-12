package com.example.dislinktagentskaapp.model;

import com.example.dislinktagentskaapp.dto.CompanyDetailsDTO;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class CompanyDetails {
    public String name;
    public String city;
    public String country;
    public Date foundation;
    public String numberOfEmployees;
    public double rating;
    public String website;
    public String industry;
    public String phone;
    public String email;
    public List<String> techStack;
    public List<String> followers;

    public CompanyDetails() {}
    public CompanyDetails(CompanyDetailsDTO companyDetailsDTO){

        this.name = companyDetailsDTO.name;
        this.city = companyDetailsDTO.city;
        this.country = companyDetailsDTO.country;
        this.foundation = companyDetailsDTO.foundation;
        this.numberOfEmployees = companyDetailsDTO.numberOfEmployees;
        this.rating = companyDetailsDTO.rating;
        this.website = companyDetailsDTO.website;
        this.industry = companyDetailsDTO.industry;
        this.phone = companyDetailsDTO.phone;
        this.email = companyDetailsDTO.email;
        this.techStack = companyDetailsDTO.techStack;
        this.followers = new ArrayList<>();
    }
}
