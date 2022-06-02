package com.example.dislinktagentskaapp.service;

import com.example.dislinktagentskaapp.dto.CommentDTO;
import com.example.dislinktagentskaapp.dto.OfferDTO;

import java.util.List;

public interface OfferService {

    OfferDTO addOffer(String companyId, OfferDTO newOfferDTO);
    OfferDTO getOffer(String companyId, String offerId);
    List<OfferDTO> getAllOffers(String companyId);
    boolean updateOffer (String companyId, OfferDTO updateOfferDTO);
    boolean deleteOffer(String companyId, String offerId);

    //TODO: Podeli ponudu s dislinktom
}
