package com.example.dislinktagentskaapp.model;

import com.example.dislinktagentskaapp.dto.InterviewDTO;

import java.util.ArrayList;
import java.util.List;

public class Interview {
    public int easyDifficultyCount;
    public int mediumDifficultyCount;
    public int hardDifficultyCount;
    public double averageSelectionDuration;
    public List<Comment> comments;

    public Interview() {
        this.easyDifficultyCount = 0;
        this.mediumDifficultyCount = 0;
        this.hardDifficultyCount = 0;
        this.averageSelectionDuration = 0.0;
        this.comments = new ArrayList<>();
    }

    public Interview(InterviewDTO interviewDTO){

        this.mediumDifficultyCount = 0;
        this.hardDifficultyCount = 0;
        this.averageSelectionDuration = 0.0;
        this.comments = new ArrayList<>();
    }
}
