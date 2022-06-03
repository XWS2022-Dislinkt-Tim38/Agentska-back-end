package com.example.dislinktagentskaapp.dto;

import com.example.dislinktagentskaapp.model.Offer;

import java.util.Date;
import java.util.List;

public class OfferDTO {

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
    public boolean isShared;
    public OfferDTO() {}
    public OfferDTO(Offer offer){

        this.id = offer.id;
        this.idUser = offer.idUser;
        this.title = offer.title;
        this.content = offer.content;
        this.company = offer.company;
        this.industry = offer.industry;
        this.field = offer.field;
        this.seniority = offer.seniority;
        this.requirements = offer.requirements;
        this.workType = offer.workType;
        this.publishDate = offer.publishDate;
        this.deadlineDate = offer.deadlineDate;
        this.city = offer.city;
        this.isShared = offer.isShared;

    }
}
