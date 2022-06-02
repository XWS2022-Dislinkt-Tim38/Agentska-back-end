package com.example.dislinktagentskaapp.service;

import com.example.dislinktagentskaapp.dto.CommentDTO;

import java.util.List;

public interface CommentService {

    CommentDTO addCompanyComment(String companyId,CommentDTO newCommentDTO);
    CommentDTO getCompanyComment(String companyId, String commentId);
    List<CommentDTO> getAllCompanyComments(String companyId);
    boolean updateCompanyComment (String companyId, CommentDTO updateCommentDTO);
    boolean deleteCompanyComment(String companyId, String commentId);

    CommentDTO addInterviewComment(String companyId,CommentDTO newCommentDTO, int difficulty);
    CommentDTO getInterviewComment(String companyId, String interviewId);
    List<CommentDTO> getAllInterviewComments(String interviewId);
    boolean updateInterviewComment (String companyId, CommentDTO updateCommentDTO);
    boolean deleteInterviewComment(String companyId, String commentId);

}
