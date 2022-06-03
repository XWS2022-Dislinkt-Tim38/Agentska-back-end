package com.example.dislinktagentskaapp.model;

import com.example.dislinktagentskaapp.dto.InterviewDTO;

import java.util.ArrayList;
import java.util.List;

public class Interview {
    public int easyDifficultyCount;
    public int mediumDifficultyCount;
    public int hardDifficultyCount;
    public double rating;
    public double easyPercent;
    public double mediumPercent;
    public double hardPercent;
    public List<Comment> comments;

    public Interview() {
        this.easyDifficultyCount = 0;
        this.mediumDifficultyCount = 0;
        this.hardDifficultyCount = 0;
        this.rating = 0.0;
        this.easyPercent = 0.0;
        this.mediumPercent = 0.0;
        this.hardPercent = 0.0;
        this.comments = new ArrayList<>();
    }

    public Interview(InterviewDTO interviewDTO) {
        this.rating = interviewDTO.rating;
        this.easyDifficultyCount = interviewDTO.easyDifficultyCount;
        this.mediumDifficultyCount = interviewDTO.mediumDifficultyCount;
        this.hardDifficultyCount = interviewDTO.hardDifficultyCount;
        this.easyPercent = interviewDTO.easyPercent;
        this.mediumPercent = interviewDTO.mediumPercent;
        this.hardPercent = interviewDTO.hardPercent;
        this.comments = new ArrayList<>();
    }
}
