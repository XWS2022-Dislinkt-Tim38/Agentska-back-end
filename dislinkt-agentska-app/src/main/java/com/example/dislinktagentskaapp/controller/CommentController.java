package com.example.dislinktagentskaapp.controller;

import com.example.dislinktagentskaapp.dto.CommentDTO;
import com.example.dislinktagentskaapp.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.websocket.server.PathParam;
import java.util.List;

@CrossOrigin
@RestController
@RequestMapping(value = "/comment")
public class CommentController {

    @Autowired
    CommentService commentService;

    @PostMapping(value = "/companycomment/{companyId}")
    public ResponseEntity<Object> addCompanyComment(@PathVariable String companyId,
                                                    @RequestBody CommentDTO newCommentDTO){
        CommentDTO comment = commentService.addCompanyComment(companyId, newCommentDTO);
        return new ResponseEntity<>(comment, HttpStatus.OK);
    }

    @GetMapping(value = "/companycomment/{companyId}/{commentId}")
    public ResponseEntity<Object> getCompanyComment(@PathVariable String companyId,
                                                    @PathVariable String commentId){
        CommentDTO comment = commentService.getCompanyComment(companyId, commentId);
        return new ResponseEntity<>(comment, HttpStatus.OK);
    }

    @GetMapping(value = "/companycomment/{companyId}")
    public ResponseEntity<List<CommentDTO>> getAllCompanyComments(@PathVariable String companyId){
        List<CommentDTO> comments = commentService.getAllCompanyComments(companyId);
        return new ResponseEntity<>(comments, HttpStatus.OK);
    }

    @PutMapping(value = "/companycomment/{companyId}")
    public ResponseEntity<Object> getAllCompanyComments(@PathVariable String companyId,
                                                        @RequestBody CommentDTO updateCommentDTO){
        boolean response = commentService.updateCompanyComment(companyId, updateCommentDTO);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @DeleteMapping(value = "/companycomment/{companyId}/{commentId}")
    public ResponseEntity<Object> deleteCompanyComment(@PathVariable String companyId,
                                                       @PathVariable String commentId){
        boolean response = commentService.deleteCompanyComment(companyId, commentId);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
}
