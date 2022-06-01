package com.example.dislinktagentskaapp.model;

import com.example.dislinktagentskaapp.dto.CommentDTO;
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
    public CompanyDetails companyDetails;
    public List<Comment> comments;
    public Interview interview;
    public List<Salary> salaries;
    public List<JobOffer> jobOffers;

    public Company() {}
    public Company(CompanyDTO companyDTO){

        this.id = java.util.UUID.randomUUID().toString();
        this.idUser = companyDTO.idUser;
        this.companyDetails = companyDTO.companyDetails;
        this.comments = new ArrayList<>();
        this.interview = new Interview();
        this.salaries = new ArrayList<>();
        this.jobOffers = new ArrayList<>();

    }
}
