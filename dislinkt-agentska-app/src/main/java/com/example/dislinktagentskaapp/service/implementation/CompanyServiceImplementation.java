package com.example.dislinktagentskaapp.service.implementation;

import com.example.dislinktagentskaapp.dto.CompanyDTO;
import com.example.dislinktagentskaapp.dto.CompanyDetailsDTO;
import com.example.dislinktagentskaapp.exception.CompanyNotFoundException;
import com.example.dislinktagentskaapp.model.Company;
import com.example.dislinktagentskaapp.model.CompanyDetails;
import com.example.dislinktagentskaapp.repository.CompanyRepository;
import com.example.dislinktagentskaapp.service.CompanyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CompanyServiceImplementation implements CompanyService {

    @Autowired
    CompanyRepository companyRepository;

    @Override
    public CompanyDTO createCompany(CompanyDTO newCompanyDTO) {
        Company company = new Company(newCompanyDTO);
        companyRepository.save(company);
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
        return companyToUpdate;
    }

    @Override
    public Company updateCompanyDetails(String companyId, CompanyDetailsDTO companyDetailsDTO) {
        Company companyToUpdate = companyRepository.findById(companyId)
                .orElseThrow(CompanyNotFoundException::new);
        companyToUpdate.companyDetails = new CompanyDetails(companyDetailsDTO);
        companyRepository.save(companyToUpdate);
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
        return companyToSend;
    }

    public void registerCompany(Company company){
        companyRepository.save(company);
    }

    @Override
    public CompanyDTO getCompanyByOwner(String ownerId) {
        return new CompanyDTO(companyRepository.findCompanyByidUser(ownerId));
    }
}
