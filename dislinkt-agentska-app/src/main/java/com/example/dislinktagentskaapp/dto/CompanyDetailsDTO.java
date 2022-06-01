package com.example.dislinktagentskaapp.dto;

import com.example.dislinktagentskaapp.model.Company;
import com.example.dislinktagentskaapp.model.CompanyDetails;

import java.util.Date;
import java.util.List;

public class CompanyDetailsDTO {
    public String companyId;
    public String name;
    public String city;
    public String address;
    public Date foundation;
    public String numberOfEmployees;
    public double rating;
    public String website;
    public String industry;
    public List<String> techStack;
    public List<String> followers;

    public CompanyDetailsDTO() {}

    public CompanyDetailsDTO(CompanyDetails companyDetails) {
        this.companyId = companyDetails.companyId;
        this.name = companyDetails.name;
        this.city = companyDetails.city;
        this.address = companyDetails.address;
        this.foundation = companyDetails.foundation;
        this.numberOfEmployees = companyDetails.numberOfEmployees;
        this.rating = companyDetails.rating;
        this.website = companyDetails.website;
        this.industry = companyDetails.industry;
        this.techStack = companyDetails.techStack;
        this.followers = companyDetails.followers;
    }
}
