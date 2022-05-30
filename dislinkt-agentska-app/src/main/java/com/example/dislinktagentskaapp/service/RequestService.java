package com.example.dislinktagentskaapp.service;

import com.example.dislinktagentskaapp.dto.OwnershipRequestDTO;
import com.example.dislinktagentskaapp.model.OwnershipRequest;

public interface RequestService {

    OwnershipRequestDTO createRequest(OwnershipRequestDTO requestDTO);
    boolean manageRequest(String id, boolean requestResponse);

}
