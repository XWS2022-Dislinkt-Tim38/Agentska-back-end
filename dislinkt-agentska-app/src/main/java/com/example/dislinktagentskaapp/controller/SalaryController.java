package com.example.dislinktagentskaapp.controller;

import com.example.dislinktagentskaapp.dto.SalaryDTO;
import com.example.dislinktagentskaapp.service.SalaryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping(value = "/salary")
public class SalaryController {

    @Autowired
    private SalaryService salaryService;

    @PostMapping(value = "/companysalary/{companyId}")
    public ResponseEntity<Object> addCompanySalary(@PathVariable String companyId,
                                                    @RequestBody SalaryDTO newSalaryDTO){
        SalaryDTO salary = salaryService.addCompanySalary(companyId, newSalaryDTO);
        return new ResponseEntity<>(salary, HttpStatus.OK);
    }

    @GetMapping(value = "/companysalary/{companyId}/{salaryId}")
    public ResponseEntity<Object> getCompanySalary(@PathVariable String companyId,
                                                    @PathVariable String salaryId){
        SalaryDTO salary = salaryService.getCompanySalary(companyId, salaryId);
        return new ResponseEntity<>(salary, HttpStatus.OK);
    }

    @GetMapping(value = "/companysalary/{companyId}")
    public ResponseEntity<List<SalaryDTO>> getAllCompanySalaries(@PathVariable String companyId){
        List<SalaryDTO> salaries = salaryService.getAllCompanySalaries(companyId);
        return new ResponseEntity<>(salaries, HttpStatus.OK);
    }

    @PutMapping(value = "/companysalary/{companyId}")
    public ResponseEntity<Object> updateCompanySalary(@PathVariable String companyId,
                                                       @RequestBody SalaryDTO updateSalaryDTO){
        boolean response = salaryService.updateCompanySalary(companyId, updateSalaryDTO);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @DeleteMapping(value = "/companysalary/{companyId}/{salaryId}")
    public ResponseEntity<Object> deleteCompanySalary(@PathVariable String companyId,
                                                       @PathVariable String salaryId){
        boolean response = salaryService.deleteCompanySalary(companyId, salaryId);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
}
