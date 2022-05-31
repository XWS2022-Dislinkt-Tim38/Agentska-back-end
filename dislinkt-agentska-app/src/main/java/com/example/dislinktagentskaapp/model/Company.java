package com.example.dislinktagentskaapp.model;

import com.example.dislinktagentskaapp.dto.CompanyDTO;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.ArrayList;
import java.util.List;
@Document
public class Company {

    @Id
    public String id;
    public String idUser;
    public String name;
    public String address;
    public List<String> comments;

    public Company() {}
    public Company(CompanyDTO companyDTO){
        this.id = java.util.UUID.randomUUID().toString();
        this.idUser = companyDTO.idUser;
        this.name = companyDTO.name;
        this.address = companyDTO.address;
        this.comments = new ArrayList<>();
    }

}
