package com.example.dislinktagentskaapp.dto;

import com.example.dislinktagentskaapp.model.Comment;

import java.util.Date;

public class CommentDTO {

    public String idUser;
    public String title;
    public String content;
    public Date datePosted;
    public double rating;

    public CommentDTO() {}

    public CommentDTO(Comment comment) {

        this.idUser = comment.idUser;
        this.title = comment.title;
        this.content = comment.content;
        this.datePosted = comment.datePosted;
        this.rating = comment.rating;
    }

}
