package com.example.dislinktagentskaapp.dto;

import com.example.dislinktagentskaapp.model.Company;

import java.util.List;

public class CompanyDTO {

    public String id;
    public String idUser;
    public String name;
    public String address;
    public List<String> comments;

    public CompanyDTO(){}
    public CompanyDTO(Company company){
        this.id = company.id;
        this.idUser = company.idUser;
        this.name = company.name;
        this.address = company.address;
        this.comments = company.comments;
    }
}
