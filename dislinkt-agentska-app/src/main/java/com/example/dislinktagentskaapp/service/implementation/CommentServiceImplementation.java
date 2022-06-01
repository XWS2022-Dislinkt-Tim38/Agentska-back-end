package com.example.dislinktagentskaapp.service.implementation;

import com.example.dislinktagentskaapp.dto.CommentDTO;
import com.example.dislinktagentskaapp.exception.CompanyNotFoundException;
import com.example.dislinktagentskaapp.model.Comment;
import com.example.dislinktagentskaapp.model.Company;
import com.example.dislinktagentskaapp.repository.CompanyRepository;
import com.example.dislinktagentskaapp.service.CommentService;
import com.example.dislinktagentskaapp.service.CompanyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@Service
public class CommentServiceImplementation implements CommentService {

    @Autowired
    CompanyService companyService;

    @Autowired
    CompanyRepository companyRepository;

    @Override
    public CommentDTO addCompanyComment(String companyId, CommentDTO newCommentDTO) {
        Company company = companyRepository.findById(companyId)
                .orElseThrow(CompanyNotFoundException::new);
        Comment comment = new Comment(newCommentDTO);
        company.comments.add(comment);
        companyRepository.save(company);

        return new CommentDTO(comment);
    }

    @Override
    public CommentDTO getCompanyComment(String companyId, String commentId) {
        Company company = companyRepository.findById(companyId)
                .orElseThrow(CompanyNotFoundException::new);
        Comment foundComment = new Comment();

        for(Comment comment : company.comments)
            if(comment.id.equals(commentId)){
                foundComment = comment;
                break;
            }

        return new CommentDTO(foundComment);
    }

    @Override
    public List<CommentDTO> getAllCompanyComments(String companyId) {
        Company company = companyRepository.findById(companyId)
                .orElseThrow(CompanyNotFoundException::new);
        List<CommentDTO> commentsDTO = new ArrayList<>();
        for(Comment comment : company.comments)
            commentsDTO.add(new CommentDTO(comment));

        return commentsDTO;
    }

    @Override
    public boolean updateCompanyComment(String companyId, CommentDTO updateCommentDTO) {
        boolean response = false;
        Company company = companyRepository.findById(companyId)
                .orElseThrow(CompanyNotFoundException::new);

        for(Comment comment : company.comments)
            if(comment.id.equals(updateCommentDTO.id)){
                comment.rating = updateCommentDTO.rating;
                comment.title = updateCommentDTO.title;
                comment.content = updateCommentDTO.content;
                response = true;
                break;
            }

        companyRepository.save(company);
        return response;
    }

    @Override
    public boolean deleteCompanyComment(String companyId, String commentId) {
        Company company = companyRepository.findById(companyId)
                .orElseThrow(CompanyNotFoundException::new);

        boolean response = company.comments.removeIf(comment -> comment.id.equals(commentId));
        companyRepository.save(company);
        return response;

    }


    @Override
    public CommentDTO addInterviewComment(String companyId, CommentDTO newCommentDTO) {
        return null;
    }

    @Override
    public CommentDTO getInterviewComment(String companyId, String interviewId) {
        return null;
    }

    @Override
    public List<CommentDTO> getAllInterviewComments(String interviewId) {
        return null;
    }

    @Override
    public boolean updateInterviewComment(String companyId, CommentDTO updateCommentDTO) {
        return false;
    }

    @Override
    public boolean deleteInterviewComment(String companyId, String commentId) {
        return false;
    }
}
