package com.example.dislinktagentskaapp.dto;

import com.example.dislinktagentskaapp.model.Company;
import com.example.dislinktagentskaapp.model.CompanyDetails;

import java.util.Date;
import java.util.List;

public class CompanyDetailsDTO { ;
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

    public CompanyDetailsDTO() {}

    public CompanyDetailsDTO(CompanyDetails companyDetails) {

        this.name = companyDetails.name;
        this.city = companyDetails.city;
        this.country = companyDetails.country;
        this.foundation = companyDetails.foundation;
        this.numberOfEmployees = companyDetails.numberOfEmployees;
        this.rating = companyDetails.rating;
        this.website = companyDetails.website;
        this.industry = companyDetails.industry;
        this.phone = companyDetails.phone;
        this.email = companyDetails.email;
        this.techStack = companyDetails.techStack;
        this.followers = companyDetails.followers;
    }
}
