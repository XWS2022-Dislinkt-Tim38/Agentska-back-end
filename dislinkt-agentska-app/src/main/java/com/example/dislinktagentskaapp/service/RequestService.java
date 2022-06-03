package com.example.dislinktagentskaapp.service;

import com.example.dislinktagentskaapp.dto.OwnershipRequestDTO;
import com.example.dislinktagentskaapp.model.OwnershipRequest;

import java.util.List;

public interface RequestService {

    OwnershipRequestDTO createRequest(OwnershipRequestDTO requestDTO);
    boolean manageRequest(String id, boolean requestResponse);
    List<OwnershipRequestDTO> getAllRequests();

}
