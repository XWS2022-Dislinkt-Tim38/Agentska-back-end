package com.example.dislinktagentskaapp.dto;


import com.example.dislinktagentskaapp.model.Company;
import com.example.dislinktagentskaapp.model.OwnershipRequest;

public class OwnershipRequestDTO {

    public String id;
    public String idUser;
    public CompanyDTO companyDTO;
    public String status;

    public OwnershipRequestDTO() {}
    public OwnershipRequestDTO(OwnershipRequest request){
        this.id = request.id;
        this.idUser = request.idUser;
        this.status = request.status;
        this.companyDTO = new CompanyDTO(request.company);
    }
}
