package com.example.dislinktagentskaapp.model;

import com.example.dislinktagentskaapp.dto.CompanyDetailsDTO;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class CompanyDetails {

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

    public CompanyDetails() {}
    public CompanyDetails(CompanyDetailsDTO companyDetailsDTO){
        this.companyId = companyDetailsDTO.companyId;
        this.name = companyDetailsDTO.name;
        this.city = companyDetailsDTO.city;
        this.address = companyDetailsDTO.address;
        this.foundation = companyDetailsDTO.foundation;
        this.numberOfEmployees = companyDetailsDTO.numberOfEmployees;
        this.rating = companyDetailsDTO.rating;
        this.website = companyDetailsDTO.website;
        this.industry = companyDetailsDTO.industry;
        this.techStack = companyDetailsDTO.techStack;
        this.followers = new ArrayList<>();
    }
}
