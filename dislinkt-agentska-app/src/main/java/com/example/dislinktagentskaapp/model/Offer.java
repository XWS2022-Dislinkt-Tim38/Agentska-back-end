package com.example.dislinktagentskaapp.model;

import com.example.dislinktagentskaapp.dto.OfferDTO;

import java.util.Date;
import java.util.List;

public class Offer {

    public String id;
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

    public Offer() {}

    public Offer(OfferDTO offerDTO){

        this.id = "offer_" + java.util.UUID.randomUUID().toString();
        this.idUser = offerDTO.idUser;
        this.title = offerDTO.title;
        this.content = offerDTO.content;
        this.company = offerDTO.company;
        this.industry = offerDTO.industry;
        this.field = offerDTO.field;
        this.seniority = offerDTO.seniority;
        this.requirements = offerDTO.requirements;
        this.workType = offerDTO.workType;
        this.publishDate = new Date();
        this.deadlineDate = offerDTO.deadlineDate;
        this.city = offerDTO.city;
    }
}
