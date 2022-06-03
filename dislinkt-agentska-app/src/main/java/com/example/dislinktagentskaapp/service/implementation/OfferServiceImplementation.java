package com.example.dislinktagentskaapp.service.implementation;

import com.example.dislinktagentskaapp.dto.OfferDTO;
import com.example.dislinktagentskaapp.exception.CompanyNotFoundException;
import com.example.dislinktagentskaapp.model.Company;
import com.example.dislinktagentskaapp.model.Offer;
import com.example.dislinktagentskaapp.repository.CompanyRepository;
import com.example.dislinktagentskaapp.service.OfferService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class OfferServiceImplementation implements OfferService {

    @Autowired
    CompanyRepository companyRepository;

    @Override
    public OfferDTO addOffer(String companyId, OfferDTO newOfferDTO) {
        Company company = companyRepository.findById(companyId)
                .orElseThrow(CompanyNotFoundException::new);
        Offer offer = new Offer(newOfferDTO);
        company.offers.add(offer);
        companyRepository.save(company);
        return new OfferDTO(offer);
    }

    @Override
    public OfferDTO getOffer(String companyId, String offerId) {
        Company company = companyRepository.findById(companyId)
                .orElseThrow(CompanyNotFoundException::new);
        Offer foundOffer = new Offer();
        for(Offer offer : company.offers)
            if(offer.id.equals(offerId)){
                foundOffer = offer;
                break;
            }

        return new OfferDTO(foundOffer);
    }

    @Override
    public List<OfferDTO> getAllOffersByCompany(String companyId) {
        Company company = companyRepository.findById(companyId)
                .orElseThrow(CompanyNotFoundException::new);
        List<OfferDTO> offersDTO = new ArrayList<>();
        for(Offer offer : company.offers)
            offersDTO.add(new OfferDTO(offer));

        return offersDTO;
    }

    @Override
    public List<OfferDTO> getAllOffers() {
        List<Company> companies = companyRepository.findAll();
        List<OfferDTO> offers = new ArrayList<>();
        for(Company company : companies)
            for(Offer offer : company.offers)
                offers.add(new OfferDTO(offer));

        return offers;
    }

    @Override
    public boolean updateOffer(String companyId, OfferDTO updateOfferDTO) {
        boolean response = false;
        Company company = companyRepository.findById(companyId)
                .orElseThrow(CompanyNotFoundException::new);
        for(Offer offer : company.offers)
            if(offer.id.equals(updateOfferDTO.id)){
                offer.idUser = updateOfferDTO.idUser;
                offer.title = updateOfferDTO.title;
                offer.content = updateOfferDTO.content;
                offer.company = updateOfferDTO.company;
                offer.industry = updateOfferDTO.industry;
                offer.field = updateOfferDTO.field;
                offer.seniority = updateOfferDTO.seniority;
                offer.requirements = updateOfferDTO.requirements;
                offer.workType = updateOfferDTO.workType;
                offer.publishDate = updateOfferDTO.publishDate;
                offer.deadlineDate = updateOfferDTO.deadlineDate;
                offer.city = updateOfferDTO.city;
                offer.isShared = updateOfferDTO.isShared;
                companyRepository.save(company);
                response = true;
                break;
            }
        return response;
    }

    @Override
    public boolean deleteOffer(String companyId, String offerId) {
        Company company = companyRepository.findById(companyId)
                .orElseThrow(CompanyNotFoundException::new);
        boolean response = company.offers.removeIf(offer -> offer.id.equals(offerId));
        companyRepository.save(company);
        return response;
    }

    @Override
    public boolean setSharedFlag(String companyId, String offerId) {
        boolean response = false;
        Company company = companyRepository.findById(companyId)
                .orElseThrow(CompanyNotFoundException::new);
        for(Offer offer : company.offers)
            if(offer.id.equals(offerId)){
                offer.isShared = true;
                response = true;
                break;
            }
        companyRepository.save(company);
        return response;
    }
}
