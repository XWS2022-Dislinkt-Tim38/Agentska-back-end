package com.example.dislinktagentskaapp.controller;

import com.example.dislinktagentskaapp.dto.OwnershipRequestDTO;
import com.example.dislinktagentskaapp.service.RequestService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping(value = "/request")
public class RequestController {

    Logger logger = LoggerFactory.getLogger(RequestController.class);
    @Autowired
    RequestService requestService;

    @GetMapping(value = "/test")
    public ResponseEntity<Object> testController(){
        return new ResponseEntity<>("Request Controller works!", HttpStatus.OK);
    }
    @GetMapping
    public ResponseEntity<List<OwnershipRequestDTO>> getAllRequests(){
        logger.info("GET REQUEST /request");
        List<OwnershipRequestDTO> requests = requestService.getAllRequests();
        return new ResponseEntity<>(requests, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Object> createRequest(@RequestBody OwnershipRequestDTO newRequestDTO){
        logger.info("POST REQUEST /request");
        OwnershipRequestDTO request = requestService.createRequest(newRequestDTO);
        return new ResponseEntity<>(request, HttpStatus.OK);
    }

    @PutMapping
    public  ResponseEntity<Object> manageRequest(@RequestParam(value = "id") String id,
                                                 @RequestParam(value = "requestResponse") boolean requestResponse){
        logger.info("PUT REQUEST /request");
        boolean response = requestService.manageRequest(id, requestResponse);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
}
