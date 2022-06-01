package com.example.dislinktagentskaapp.service;

import com.example.dislinktagentskaapp.dto.CompanyDTO;
import com.example.dislinktagentskaapp.dto.CompanyDetailsDTO;

import java.util.List;

public interface CompanyService {

    CompanyDTO createCompany(CompanyDTO newCompanyDTO);
    List<CompanyDTO> getAllCompanies();
    void updateCompany(CompanyDTO editCompanyDTO);
    void updateCompanyDetails(CompanyDetailsDTO companyDetailsDTO);

}
