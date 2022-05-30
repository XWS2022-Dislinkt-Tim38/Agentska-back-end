package com.example.dislinktagentskaapp.controller;

import com.example.dislinktagentskaapp.dto.OwnershipRequestDTO;
import com.example.dislinktagentskaapp.service.RequestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RestController
@RequestMapping(value = "/request")
public class RequestController {

    @Autowired
    RequestService requestService;

    @GetMapping(value = "/test")
    public ResponseEntity<Object> testController(){
        return new ResponseEntity<>("Request Controller works!", HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Object> createRequest(@RequestBody OwnershipRequestDTO newRequestDTO){
        OwnershipRequestDTO request = requestService.createRequest(newRequestDTO);
        return new ResponseEntity<>(request, HttpStatus.OK);
    }

    @PutMapping
    public  ResponseEntity<Object> manageRequest(@RequestParam(value = "id") String id,
                                                 @RequestParam(value = "requestResponse") boolean requestResponse){
        boolean response = requestService.manageRequest(id, requestResponse);
        if(response)
            return new ResponseEntity<>("Request accepted!", HttpStatus.OK);
        else
            return new ResponseEntity<>("Request denied!", HttpStatus.OK);

    }
}
