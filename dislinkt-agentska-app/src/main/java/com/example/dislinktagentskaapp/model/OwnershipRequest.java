package com.example.dislinktagentskaapp.model;

import com.example.dislinktagentskaapp.dto.OwnershipRequestDTO;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class OwnershipRequest {

    @Id
    public String id;
    public String idUser;
    public boolean isAccepted;

    public OwnershipRequest() {}

    public OwnershipRequest(OwnershipRequestDTO ownershipRequestDTO){

        String id = java.util.UUID.randomUUID().toString();
        this.id = "request_" + id;
        this.idUser = ownershipRequestDTO.idUser;
        this.isAccepted = false;
    }
}
