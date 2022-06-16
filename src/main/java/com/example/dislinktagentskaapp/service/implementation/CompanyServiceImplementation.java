package com.example.dislinktagentskaapp.service.implementation;

import com.example.dislinktagentskaapp.dto.CompanyDTO;
import com.example.dislinktagentskaapp.dto.CompanyDetailsDTO;
import com.example.dislinktagentskaapp.exception.CompanyNotFoundException;
import com.example.dislinktagentskaapp.model.Company;
import com.example.dislinktagentskaapp.model.CompanyDetails;
import com.example.dislinktagentskaapp.repository.CompanyRepository;
import com.example.dislinktagentskaapp.service.CompanyService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CompanyServiceImplementation implements CompanyService {

    Logger logger = LoggerFactory.getLogger(CompanyServiceImplementation.class);
    @Autowired
    CompanyRepository companyRepository;

    @Override
    public CompanyDTO createCompany(CompanyDTO newCompanyDTO) {
        Company company = new Company(newCompanyDTO);
        companyRepository.save(company);
        logger.info("Registered company with id: " + company.id + " in database");
        return new CompanyDTO(company);
    }

    //TODO: Get Company By ID

    @Override
    public List<CompanyDTO> getAllCompanies() {
        List<Company> companies = companyRepository.findAll();
        List<CompanyDTO> companiesDTO = new ArrayList<>();
        for(Company company : companies){
            companiesDTO.add(new CompanyDTO(company));
        }
        logger.info("Fetching all companies");
        return companiesDTO;
    }

    @Override
    public Company updateCompany(CompanyDTO updateCompanyDTO) {

        if(!companyRepository.existsById(updateCompanyDTO.id))
            throw new CompanyNotFoundException();

        Company companyToUpdate = companyRepository.findById(updateCompanyDTO.id)
                .orElseThrow(CompanyNotFoundException::new);
        companyToUpdate.companyDetails = updateCompanyDTO.companyDetails;
        companyRepository.save(companyToUpdate);
        logger.warn("Company information changed for company with id: " + companyToUpdate.id);
        return companyToUpdate;
    }

    @Override
    public Company updateCompanyDetails(String companyId, CompanyDetailsDTO companyDetailsDTO) {
        Company companyToUpdate = companyRepository.findById(companyId)
                .orElseThrow(CompanyNotFoundException::new);
        companyToUpdate.companyDetails = new CompanyDetails(companyDetailsDTO);
        companyRepository.save(companyToUpdate);
        logger.warn("Company details changed for company with id: " + companyToUpdate.id);
        return companyToUpdate;
    }

    @Override
    public CompanyDTO getCompany(String companyId) {
        List<Company> companies = companyRepository.findAll();
        CompanyDTO companyToSend = new CompanyDTO();
        List<CompanyDTO> companiesDTO = new ArrayList<>();
        for(Company company : companies){
            if(company.id.equals(companyId)){
                companyToSend = new CompanyDTO(company);
            }
        }
        logger.info("Fetching company with id: " + companyId);
        return companyToSend;
    }

    public void registerCompany(Company company){
        companyRepository.save(company);
    }

    @Override
    public CompanyDTO getCompanyByOwner(String ownerId) {
        logger.info("Getting company by user with id: " + ownerId);
        Company company = companyRepository.findCompanyByidUser(ownerId);
        if(company == null) throw new CompanyNotFoundException();
        return new CompanyDTO(company);
    }
    @Override
    public List<CompanyDTO> getUserCompanies(String userId) {
        List<CompanyDTO> companies = getAllCompanies();
        List<CompanyDTO> userCompanies = new ArrayList<>();

        for(CompanyDTO company : companies){
            if(company.idUser.equals(userId)){
                userCompanies.add(company);
            }
        }

        logger.info("Getting companies by user with id: " + userId);
        return userCompanies;
    }
}
