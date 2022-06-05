package com.example.dislinktagentskaapp.service;

import com.example.dislinktagentskaapp.dto.CompanyDTO;
import com.example.dislinktagentskaapp.dto.CompanyDetailsDTO;
import com.example.dislinktagentskaapp.model.Company;

import java.util.List;

public interface CompanyService {

    CompanyDTO createCompany(CompanyDTO newCompanyDTO);
    List<CompanyDTO> getAllCompanies();
    Company updateCompany(CompanyDTO editCompanyDTO);
    Company updateCompanyDetails(String companyId, CompanyDetailsDTO companyDetailsDTO);
    CompanyDTO getCompany(String companyId);
    void registerCompany(Company company);
    CompanyDTO getCompanyByOwner(String ownerId);

}
