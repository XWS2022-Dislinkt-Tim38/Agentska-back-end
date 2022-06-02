package com.example.dislinktagentskaapp.dto;

import com.example.dislinktagentskaapp.model.Comment;
import com.example.dislinktagentskaapp.model.Interview;

import java.util.ArrayList;
import java.util.List;

public class InterviewDTO {
    public int easyDifficultyCount;
    public int mediumDifficultyCount;
    public int hardDifficultyCount;

    public double rating;
    public double easyPercent;
    public double mediumPercent;
    public double hardPercent;
    public List<CommentDTO> commentsDTO;

    public InterviewDTO() {
    }

    public InterviewDTO(Interview interview) {
        this.rating = interview.rating;
        this.easyDifficultyCount = interview.easyDifficultyCount;
        this.mediumDifficultyCount = interview.mediumDifficultyCount;
        this.hardDifficultyCount = interview.hardDifficultyCount;
        this.easyPercent = interview.easyPercent;
        this.mediumPercent = interview.mediumPercent;
        this.hardPercent = interview.hardPercent;
        this.commentsDTO = mapCommentsToDTO(interview.comments);
    }

    private List<CommentDTO> mapCommentsToDTO(List<Comment> comments) {
        List<CommentDTO> commentsDTO = new ArrayList<>();
        for (Comment comment : comments)
            commentsDTO.add(new CommentDTO(comment));

        return commentsDTO;
    }

}
