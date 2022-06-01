package com.example.dislinktagentskaapp.model;

import com.example.dislinktagentskaapp.dto.JobOfferDTO;

import java.util.Date;
import java.util.List;

public class JobOffer {

    public String idUser;
    public String title;
    public String content;
    public String company;
    public String industry;
    public String field;
    public String seniority;
    public List<String> requirements;
    public String workType;
    public Date publishDate;
    public Date deadlineDate;
    public String city;

    public JobOffer() {}

    public JobOffer(JobOfferDTO jobOfferDTO){
        this.idUser = jobOfferDTO.idUser;
        this.title = jobOfferDTO.title;
        this.content = jobOfferDTO.content;
        this.company = jobOfferDTO.company;
        this.industry = jobOfferDTO.industry;
        this.field = jobOfferDTO.field;
        this.seniority = jobOfferDTO.seniority;
        this.requirements = jobOfferDTO.requirements;
        this.workType = jobOfferDTO.workType;
        this.publishDate = new Date();
        this.deadlineDate = jobOfferDTO.deadlineDate;
        this.city = jobOfferDTO.city;
    }
}
