package com.example.dislinktagentskaapp.model;

import com.example.dislinktagentskaapp.dto.CompanyDTO;

import java.util.ArrayList;
import java.util.List;

public class Company {

    public String id;
    public String name;
    public String address;
    public List<String> comments;

    public Company() {}
    public Company(CompanyDTO companyDTO){
        this.id = java.util.UUID.randomUUID().toString();
        this.name = companyDTO.name;
        this.address = companyDTO.address;
        this.comments = new ArrayList<>();
    }

}
