package com.example.dislinktagentskaapp.controller;

import com.example.dislinktagentskaapp.dto.CompanyDTO;
import com.example.dislinktagentskaapp.dto.CompanyDetailsDTO;
import com.example.dislinktagentskaapp.service.CompanyService;
import com.example.dislinktagentskaapp.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping(value = "/company")
public class CompanyController {

    @Autowired
    CompanyService companyService;

    @GetMapping(value = "/test")
    public ResponseEntity<Object> testController(){
        return new ResponseEntity<>("Company Controller works!", HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<CompanyDTO>> getAllCompanies(){
        List<CompanyDTO> companies = companyService.getAllCompanies();
        return new ResponseEntity<>(companies, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Object> createCompany(@RequestBody CompanyDTO newCompanyDto){
        CompanyDTO company = companyService.createCompany(newCompanyDto);
        return new ResponseEntity<>(company, HttpStatus.OK);
    }

    @PutMapping
    public ResponseEntity<Object> updateCompany(@RequestBody CompanyDTO updateCompanyDTO){
        companyService.updateCompany(updateCompanyDTO);
        return new ResponseEntity<>("Company successfully updated!", HttpStatus.OK);

    }

    @PutMapping(value = "/details")
    public ResponseEntity<Object> updateCompanyDetails(@RequestBody CompanyDetailsDTO updateCompanyDetailsDTO){
        companyService.updateCompanyDetails(updateCompanyDetailsDTO);
        return new ResponseEntity<>("Company details successfully updated!", HttpStatus.OK);

    }
}
