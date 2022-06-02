package com.example.dislinktagentskaapp.dto;


import com.example.dislinktagentskaapp.model.Company;
import com.example.dislinktagentskaapp.model.OwnershipRequest;

public class OwnershipRequestDTO {

    public String id;
    public String idUser;
    public CompanyDTO companyDTO;
    public boolean isAccepted;

    public OwnershipRequestDTO() {}
    public OwnershipRequestDTO(OwnershipRequest request){
        this.id = request.id;
        this.idUser = request.idUser;
        this.isAccepted = request.isAccepted;
        this.companyDTO = new CompanyDTO(request.company);
    }
}
