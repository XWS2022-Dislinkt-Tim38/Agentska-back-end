package com.example.dislinktagentskaapp.dto;

import com.example.dislinktagentskaapp.model.JobOffer;

import java.util.Date;
import java.util.List;

public class JobOfferDTO {

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

    public JobOfferDTO() {}
    public JobOfferDTO(JobOffer jobOffer){
        this.idUser = jobOffer.idUser;
        this.title = jobOffer.title;
        this.content = jobOffer.content;
        this.company = jobOffer.company;
        this.industry = jobOffer.industry;
        this.field = jobOffer.field;
        this.seniority = jobOffer.seniority;
        this.requirements = jobOffer.requirements;
        this.workType = jobOffer.workType;
        this.publishDate = jobOffer.publishDate;
        this.deadlineDate = jobOffer.deadlineDate;
        this.city = jobOffer.city;

    }
}
