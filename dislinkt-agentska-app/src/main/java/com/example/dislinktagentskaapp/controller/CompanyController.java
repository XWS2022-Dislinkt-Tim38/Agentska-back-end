package com.example.dislinktagentskaapp.controller;

import com.example.dislinktagentskaapp.dto.CompanyDTO;
import com.example.dislinktagentskaapp.dto.CompanyDetailsDTO;
import com.example.dislinktagentskaapp.model.Company;
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

    @GetMapping(value = "/usercompanies")
    public ResponseEntity<List<CompanyDTO>> getUserCompanies(@RequestParam(value = "userId") String userId){
        List<CompanyDTO> userCompanies = companyService.getUserCompanies(userId);
        return new ResponseEntity<>(userCompanies, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Object> createCompany(@RequestBody CompanyDTO newCompanyDto){
        CompanyDTO company = companyService.createCompany(newCompanyDto);
        return new ResponseEntity<>(company, HttpStatus.OK);
    }

    @PutMapping
    public ResponseEntity<Object> updateCompany(@RequestBody CompanyDTO updateCompanyDTO){
        Company company = companyService.updateCompany(updateCompanyDTO);
        return new ResponseEntity<>(company, HttpStatus.OK);

    }

    @PutMapping(value = "/details")
    public ResponseEntity<Object> updateCompanyDetails(@RequestParam(value = "companyId") String companyId,
                                                       @RequestBody CompanyDetailsDTO updateCompanyDetailsDTO){
        Company company  = companyService.updateCompanyDetails(companyId, updateCompanyDetailsDTO);
        return new ResponseEntity<>(company, HttpStatus.OK);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<CompanyDTO> getCompany(@PathVariable String id){
        CompanyDTO companyDTO = companyService.getCompany(id);
        return new ResponseEntity<>(companyDTO, HttpStatus.OK);
    }

    @GetMapping(value = "/user/{idOwner}")
    public ResponseEntity<CompanyDTO> getCompanyByOwner(@PathVariable String idOwner){
        CompanyDTO companyDTO = companyService.getCompanyByOwner(idOwner);
        return new ResponseEntity<>(companyDTO, HttpStatus.OK);
    }
}
