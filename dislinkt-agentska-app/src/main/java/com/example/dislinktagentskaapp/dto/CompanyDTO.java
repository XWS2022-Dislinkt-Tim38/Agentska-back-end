package com.example.dislinktagentskaapp.dto;

import com.example.dislinktagentskaapp.model.*;

import java.sql.Array;
import java.util.ArrayList;
import java.util.List;

public class CompanyDTO {

    public String id;
    public String idUser;
    public CompanyDetails companyDetails;
    public List<CommentDTO> commentsDTO;
    public InterviewDTO interviewDTO;
    public List<SalaryDTO> salariesDTO;
    public List<JobOfferDTO> jobOffersDTO;

    public CompanyDTO(){}

    public CompanyDTO(Company company) {
        this.idUser = company.idUser;
        this.companyDetails = company.companyDetails;
        this.commentsDTO = mapCommentsToDTO(company.comments);
        this.salariesDTO = mapSalariesToDTO(company.salaries);
        this.interviewDTO = new InterviewDTO(company.interview);
        this.jobOffersDTO = mapJobOffersToDTO(company.jobOffers);
    }

    private List<CommentDTO> mapCommentsToDTO(List<Comment> comments){
        List<CommentDTO> commentsDTO = new ArrayList<>();
        for(Comment comment : comments)
            commentsDTO.add(new CommentDTO(comment));

        return commentsDTO;
    }

    private List<SalaryDTO> mapSalariesToDTO(List<Salary> salaries){
        List<SalaryDTO> salariesDTO = new ArrayList<>();
        for(Salary salary : salaries)
            salariesDTO.add(new SalaryDTO(salary));

        return salariesDTO;
    }

    private List<JobOfferDTO> mapJobOffersToDTO(List<JobOffer> jobOffers){
        List<JobOfferDTO> jobOFfersDTO = new ArrayList<>();
        for(JobOffer jobOffer : jobOffers)
            jobOFfersDTO.add(new JobOfferDTO(jobOffer));

        return jobOFfersDTO;
    }
}
