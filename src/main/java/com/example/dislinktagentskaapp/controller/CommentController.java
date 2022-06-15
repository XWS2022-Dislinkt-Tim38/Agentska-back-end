package com.example.dislinktagentskaapp.controller;

import com.example.dislinktagentskaapp.dto.CommentDTO;
import com.example.dislinktagentskaapp.dto.InterviewDTO;
import com.example.dislinktagentskaapp.service.CommentService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.util.List;

@CrossOrigin
@RestController
@RequestMapping(value = "/comment")
public class CommentController {

    Logger logger = LoggerFactory.getLogger(CommentController.class);
    @Autowired
    CommentService commentService;

    @PostMapping(value = "/companycomment/{companyId}")
    public ResponseEntity<Object> addCompanyComment(@PathVariable String companyId,
                                                    @RequestBody CommentDTO newCommentDTO){
        logger.info("POST REQUEST /comment/companycomment/{companyId}");
        CommentDTO comment = commentService.addCompanyComment(companyId, newCommentDTO);
        return new ResponseEntity<>(comment, HttpStatus.OK);
    }

    @GetMapping(value = "/companycomment/{companyId}/{commentId}")
    public ResponseEntity<Object> getCompanyComment(@PathVariable String companyId,
                                                    @PathVariable String commentId){
        logger.info("GET REQUEST /comment/companycomment/{companyId}/{commentId}");
        CommentDTO comment = commentService.getCompanyComment(companyId, commentId);
        return new ResponseEntity<>(comment, HttpStatus.OK);
    }

    @GetMapping(value = "/companycomment/{companyId}")
    public ResponseEntity<List<CommentDTO>> getAllCompanyComments(@PathVariable String companyId){
        logger.info("GET REQUEST /comment/companycomment/{companyId}");
        List<CommentDTO> comments = commentService.getAllCompanyComments(companyId);
        return new ResponseEntity<>(comments, HttpStatus.OK);
    }

    @PutMapping(value = "/companycomment/{companyId}")
    public ResponseEntity<Object> updateCompanyComment(@PathVariable String companyId,
                                                        @RequestBody CommentDTO updateCommentDTO){
        logger.info("PUT REQUEST /comment/companycomment/{companyId}");
        boolean response = commentService.updateCompanyComment(companyId, updateCommentDTO);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @DeleteMapping(value = "/companycomment/{companyId}/{commentId}")
    public ResponseEntity<Object> deleteCompanyComment(@PathVariable String companyId,
                                                       @PathVariable String commentId){
        logger.info("DELETE REQUEST /comment/companycomment/{companyId}/{commentId}");
        boolean response = commentService.deleteCompanyComment(companyId, commentId);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @PostMapping(value = "/interviewcomment/{companyId}")
    public ResponseEntity<Object> addInterviewComment(@PathVariable String companyId,
                                                    @RequestBody CommentDTO newCommentDTO, @RequestParam int difficulty){
        logger.info("POST REQUEST /comment/interviewcomment/{companyId}");
        CommentDTO comment = commentService.addInterviewComment(companyId, newCommentDTO, difficulty);
        return new ResponseEntity<>(comment, HttpStatus.OK);
    }

    @GetMapping(value = "/interviewcomment/{companyId}/{commentId}")
    public ResponseEntity<Object> getInterviewComment(@PathVariable String companyId,
                                                    @PathVariable String commentId){
        logger.info("GET REQUEST /comment/interviewcomment/{companyId}/{commentId}");
        CommentDTO comment = commentService.getInterviewComment(companyId, commentId);
        return new ResponseEntity<>(comment, HttpStatus.OK);
    }

    @GetMapping(value = "/interview/{companyId}")
    public ResponseEntity<Object> getInterview(@PathVariable String companyId){
        logger.info("GET REQUEST /comment/interview/{companyId}");
        InterviewDTO interviewDTO = commentService.getInterview(companyId);
        return new ResponseEntity<>(interviewDTO, HttpStatus.OK);
    }


    @GetMapping(value = "/interviewcomment/{companyId}")
    public ResponseEntity<List<CommentDTO>> getAllInterviewComments(@PathVariable String companyId){
        logger.info("GET REQUEST /comment/interviewcomment/{companyId}");
        List<CommentDTO> comments = commentService.getAllInterviewComments(companyId);
        return new ResponseEntity<>(comments, HttpStatus.OK);
    }

    @PutMapping(value = "/interviewcomment/{companyId}")
    public ResponseEntity<Object> updateInterviewComment(@PathVariable String companyId,
                                                       @RequestBody CommentDTO updateCommentDTO){
        logger.info("PUT REQUEST /comment/interviewcomment/{companyId}");
        boolean response = commentService.updateInterviewComment(companyId, updateCommentDTO);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @DeleteMapping(value = "/interviewcomment/{companyId}/{commentId}")
    public ResponseEntity<Object> deleteInterviewComment(@PathVariable String companyId,
                                                       @PathVariable String commentId){
        logger.info("DELETE REQUEST /comment/interviewcomment/{companyId}");
        boolean response = commentService.deleteInterviewComment(companyId, commentId);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
}
