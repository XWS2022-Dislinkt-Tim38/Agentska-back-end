package com.example.dislinktagentskaapp.controller;

import com.example.dislinktagentskaapp.dto.OfferDTO;
import com.example.dislinktagentskaapp.service.OfferService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping(value = "/offer")
public class OfferController {

    @Autowired
    OfferService offerService;

    @PostMapping(value = "/{companyId}")
    public ResponseEntity<Object> addOffer(@PathVariable String companyId,
                                                    @RequestBody OfferDTO newOfferDTO){
        OfferDTO offer = offerService.addOffer(companyId, newOfferDTO);
        return new ResponseEntity<>(offer, HttpStatus.OK);
    }

    @GetMapping(value = "/{companyId}/{offerId}")
    public ResponseEntity<Object> getOffer(@PathVariable String companyId,
                                                    @PathVariable String offerId){
        OfferDTO offer = offerService.getOffer(companyId, offerId);
        return new ResponseEntity<>(offer, HttpStatus.OK);
    }

    @GetMapping(value = "/{companyId}")
    public ResponseEntity<List<OfferDTO>> getAllOffersByCompany(@PathVariable String companyId){
        List<OfferDTO> offers = offerService.getAllOffersByCompany(companyId);
        return new ResponseEntity<>(offers, HttpStatus.OK);
    }

    @GetMapping(value = "/user/{userId}")
    public ResponseEntity<List<OfferDTO>> getAllOffersByUser(@PathVariable String userId){
        List<OfferDTO> offers = offerService.getAllOffersByUser(userId);
        return new ResponseEntity<>(offers, HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<OfferDTO>> getAllOffers(){
        List<OfferDTO> offers = offerService.getAllOffers();
        return new ResponseEntity<>(offers, HttpStatus.OK);
    }

    @PutMapping(value = "/{companyId}")
    public ResponseEntity<Object> updateOffer(@PathVariable String companyId,
                                              @RequestBody OfferDTO updateOfferDTO){
        boolean response = offerService.updateOffer(companyId, updateOfferDTO);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @DeleteMapping(value = "/{companyId}/{offerId}")
    public ResponseEntity<Object> deleteCompanyComment(@PathVariable String companyId,
                                                       @PathVariable String offerId){
        boolean response = offerService.deleteOffer(companyId, offerId);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @PutMapping(value = "/sharing/{companyId}/{offerId}")
    public ResponseEntity<Object> updateOffer(@PathVariable String companyId,
                                              @PathVariable String offerId){
        boolean response = offerService.setSharedFlag(companyId, offerId);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
}
