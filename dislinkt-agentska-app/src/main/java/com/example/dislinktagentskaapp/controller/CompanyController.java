package com.example.dislinktagentskaapp.controller;

import com.example.dislinktagentskaapp.dto.CompanyDTO;
import com.example.dislinktagentskaapp.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RestController
@RequestMapping(value = "/company")
public class CompanyController {

    @Autowired
    UserService userService;

    @GetMapping(value = "/test")
    public ResponseEntity<Object> testController(){
        return new ResponseEntity<>("Company Controller works!", HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Object> createCompany(@RequestBody CompanyDTO newCompanyDto,
                                                @RequestParam (value = "idUser") String idUser){
        CompanyDTO company = userService.addCompanyToUser(newCompanyDto, idUser);
        return new ResponseEntity<>(company, HttpStatus.OK);
    }
}
