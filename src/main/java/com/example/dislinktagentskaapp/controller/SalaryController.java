package com.example.dislinktagentskaapp.controller;

import com.example.dislinktagentskaapp.dto.SalaryDTO;
import com.example.dislinktagentskaapp.dto.SalaryNewDTO;
import com.example.dislinktagentskaapp.service.SalaryService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping(value = "/salary")
public class SalaryController {

    Logger logger = LoggerFactory.getLogger(SalaryController.class);
    @Autowired
    private SalaryService salaryService;

    @PostMapping(value = "/companysalary/{companyId}")
    public ResponseEntity<Object> addCompanySalary(@PathVariable String companyId,
                                                    @RequestBody SalaryDTO newSalaryDTO){
        logger.info("POST REQUEST /salary/companysalary/{companyId}");
        SalaryDTO salary = salaryService.addCompanySalary(companyId, newSalaryDTO);
        return new ResponseEntity<>(salary, HttpStatus.OK);
    }

    @GetMapping(value = "/companysalary/{companyId}/{salaryId}")
    public ResponseEntity<Object> getCompanySalary(@PathVariable String companyId,
                                                    @PathVariable String salaryId){
        logger.info("GET REQUEST /salary/companysalary/{companyId}/{salaryId}");
        SalaryDTO salary = salaryService.getCompanySalary(companyId, salaryId);
        return new ResponseEntity<>(salary, HttpStatus.OK);
    }

    @GetMapping(value = "/companysalary/{companyId}")
    public ResponseEntity<List<SalaryDTO>> getAllCompanySalaries(@PathVariable String companyId){
        logger.info("GET REQUEST /salary/companysalary/{companyId}");
        List<SalaryDTO> salaries = salaryService.getAllCompanySalaries(companyId);
        return new ResponseEntity<>(salaries, HttpStatus.OK);
    }

    @PutMapping(value = "/companysalary/{companyId}")
    public ResponseEntity<Object> updateCompanySalary(@PathVariable String companyId,
                                                       @RequestBody SalaryDTO updateSalaryDTO){
        logger.info("PUT REQUEST /salary/companysalary/{companyId}");
        boolean response = salaryService.updateCompanySalary(companyId, updateSalaryDTO);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @DeleteMapping(value = "/companysalary/{companyId}/{salaryId}")
    public ResponseEntity<Object> deleteCompanySalary(@PathVariable String companyId,
                                                       @PathVariable String salaryId){
        logger.info("DELETE REQUEST /salary/companysalary/{companyId}/{salaryId}");
        boolean response = salaryService.deleteCompanySalary(companyId, salaryId);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @GetMapping(value = "/companysalary/unique/{companyId}")
    public ResponseEntity<List<SalaryNewDTO>> getUniqueSalaries(@PathVariable String companyId){
        logger.info("GET REQUEST /salary//companysalary/unique/{companyId}");
        List<SalaryNewDTO> salaries = salaryService.getUniqueSalaries(companyId);
        return new ResponseEntity<>(salaries, HttpStatus.OK);
    }

}
