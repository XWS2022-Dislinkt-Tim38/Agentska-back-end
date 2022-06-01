package com.example.dislinktagentskaapp.dto;

import com.example.dislinktagentskaapp.model.Comment;
import com.example.dislinktagentskaapp.model.Interview;
import org.springframework.data.mongodb.core.aggregation.ArrayOperators;

import java.util.ArrayList;
import java.util.List;

public class InterviewDTO {

    public String idUser;
    public int easyDifficultyCount;
    public int mediumDifficultyCount;
    public int hardDifficultyCount;
    public double averageSelectionDuration;
    public List<CommentDTO> commentsDTO;

    public InterviewDTO() {}
    public InterviewDTO(Interview interview){

        this.idUser = interview.idUser;
        this.easyDifficultyCount = interview.easyDifficultyCount;
        this.mediumDifficultyCount = interview.mediumDifficultyCount;
        this.hardDifficultyCount = interview.hardDifficultyCount;
        this.averageSelectionDuration = interview.averageSelectionDuration;
        this.commentsDTO = mapCommentsToDTO(interview.comments);
    }

    private List<CommentDTO> mapCommentsToDTO(List<Comment> comments){
        List<CommentDTO> commentsDTO = new ArrayList<>();
        for(Comment comment : comments)
            commentsDTO.add(new CommentDTO(comment));

        return commentsDTO;
    }

}
