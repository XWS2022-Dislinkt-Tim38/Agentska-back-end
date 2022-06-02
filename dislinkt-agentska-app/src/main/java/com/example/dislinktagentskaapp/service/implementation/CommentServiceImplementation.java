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
import java.util.List;

@Service
public class CommentServiceImplementation implements CommentService {

    @Autowired
    CompanyService companyService;

    @Autowired
    CompanyRepository companyRepository;


    private void updateCompanyRating(Company company) {
        double rating = 0;
        for (Comment comment : company.comments) {
            rating += comment.rating;
        }
        rating = rating / company.comments.size();
        company.companyDetails.rating = rating;
    }

    private void updateInterviewRating(Company company) {
        double rating = 0;
        for (Comment comment : company.interview.comments) {
            rating += comment.rating;
        }
        rating = rating / company.interview.comments.size();
        company.interview.rating = rating;
    }

    private void updateInterviewDifficultyPercent(Company company){
        int total = company.interview.easyDifficultyCount + company.interview.mediumDifficultyCount + company.interview.hardDifficultyCount;
        company.interview.easyPercent = (double)company.interview.easyDifficultyCount/total*100;
        company.interview.mediumPercent = (double)company.interview.mediumDifficultyCount/total*100;
        company.interview.hardPercent = (double)company.interview.hardDifficultyCount/total*100;
    }

    @Override
    public CommentDTO addCompanyComment(String companyId, CommentDTO newCommentDTO) {
        Company company = companyRepository.findById(companyId)
                .orElseThrow(CompanyNotFoundException::new);
        Comment comment = new Comment(newCommentDTO);
        company.comments.add(comment);
        updateCompanyRating(company);
        companyRepository.save(company);

        return new CommentDTO(comment);
    }

    @Override
    public CommentDTO getCompanyComment(String companyId, String commentId) {
        Company company = companyRepository.findById(companyId)
                .orElseThrow(CompanyNotFoundException::new);
        Comment foundComment = new Comment();

        for (Comment comment : company.comments)
            if (comment.id.equals(commentId)) {
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
        for (Comment comment : company.comments)
            commentsDTO.add(new CommentDTO(comment));

        return commentsDTO;
    }

    @Override
    public boolean updateCompanyComment(String companyId, CommentDTO updateCommentDTO) {
        boolean response = false;
        Company company = companyRepository.findById(companyId)
                .orElseThrow(CompanyNotFoundException::new);

        for (Comment comment : company.comments)
            if (comment.id.equals(updateCommentDTO.id)) {
                comment.rating = updateCommentDTO.rating;
                comment.title = updateCommentDTO.title;
                comment.content = updateCommentDTO.content;
                response = true;
                break;
            }
        updateCompanyRating(company);
        companyRepository.save(company);
        return response;
    }

    @Override
    public boolean deleteCompanyComment(String companyId, String commentId) {
        Company company = companyRepository.findById(companyId)
                .orElseThrow(CompanyNotFoundException::new);

        boolean response = company.comments.removeIf(comment -> comment.id.equals(commentId));
        updateCompanyRating(company);
        companyRepository.save(company);
        return response;

    }


    @Override
    public CommentDTO addInterviewComment(String companyId, CommentDTO newCommentDTO, int difficulty) {
        Company company = companyRepository.findById(companyId)
                .orElseThrow(CompanyNotFoundException::new);
        Comment comment = new Comment(newCommentDTO);
        company.interview.comments.add(comment);
        updateInterviewRating(company);
        if (difficulty == 1) {
            company.interview.easyDifficultyCount += 1;
        } else if (difficulty == 2) {
            company.interview.mediumDifficultyCount += 1;
        } else {
            company.interview.hardDifficultyCount += 1;
        }
        updateInterviewDifficultyPercent(company);
        companyRepository.save(company);
        return new CommentDTO(comment);
    }

    @Override
    public CommentDTO getInterviewComment(String companyId, String commentId) {
        Company company = companyRepository.findById(companyId)
                .orElseThrow(CompanyNotFoundException::new);
        Comment foundComment = new Comment();

        for (Comment comment : company.interview.comments)
            if (comment.id.equals(commentId)) {
                foundComment = comment;
                break;
            }

        return new CommentDTO(foundComment);
    }

    @Override
    public List<CommentDTO> getAllInterviewComments(String companyId) {
        Company company = companyRepository.findById(companyId)
                .orElseThrow(CompanyNotFoundException::new);
        List<CommentDTO> commentsDTO = new ArrayList<>();
        for (Comment comment : company.interview.comments)
            commentsDTO.add(new CommentDTO(comment));
        return commentsDTO;
    }

    @Override
    public boolean updateInterviewComment(String companyId, CommentDTO updateCommentDTO) {
        boolean response = false;
        Company company = companyRepository.findById(companyId)
                .orElseThrow(CompanyNotFoundException::new);

        for (Comment comment : company.interview.comments)
            if (comment.id.equals(updateCommentDTO.id)) {
                comment.rating = updateCommentDTO.rating;
                comment.title = updateCommentDTO.title;
                comment.content = updateCommentDTO.content;
                response = true;
                break;
            }
        updateInterviewRating(company);
        companyRepository.save(company);
        return response;
    }

    @Override
    public boolean deleteInterviewComment(String companyId, String commentId) {
        Company company = companyRepository.findById(companyId)
                .orElseThrow(CompanyNotFoundException::new);

        boolean response = company.interview.comments.removeIf(comment -> comment.id.equals(commentId));
        updateInterviewRating(company);
        companyRepository.save(company);
        return response;
    }
}
