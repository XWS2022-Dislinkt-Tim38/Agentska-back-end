package com.example.dislinktagentskaapp.model;

import com.example.dislinktagentskaapp.dto.CommentDTO;

import java.util.Date;

public class Comment {

    public String idUser;
    public String title;
    public String content;
    public Date datePosted;
    public double rating;

    public Comment(){}

    public Comment(CommentDTO commentDTO){

        this.idUser = commentDTO.idUser;
        this.title = commentDTO.title;
        this.content = commentDTO.content;
        this.datePosted = commentDTO.datePosted;
        this.rating = commentDTO.rating;

    }

}
