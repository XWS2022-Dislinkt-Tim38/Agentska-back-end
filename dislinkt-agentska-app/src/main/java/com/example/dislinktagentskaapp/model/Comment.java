package com.example.dislinktagentskaapp.model;

import com.example.dislinktagentskaapp.dto.CommentDTO;

import java.util.Date;

public class Comment {

    public String id;
    public String idUser;
    public String username;
    public String title;
    public String content;
    public Date datePosted;
    public double rating;

    public Comment(){}

    public Comment(CommentDTO commentDTO){

        this.id = "comment_" + java.util.UUID.randomUUID().toString();
        this.idUser = commentDTO.idUser;
        this.username = commentDTO.username;
        this.title = commentDTO.title;
        this.content = commentDTO.content;
        this.datePosted = new Date();
        this.rating = commentDTO.rating;

    }

}
