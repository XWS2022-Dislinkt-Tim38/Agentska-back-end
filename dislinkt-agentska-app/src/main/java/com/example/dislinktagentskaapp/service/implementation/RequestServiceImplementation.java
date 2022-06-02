package com.example.dislinktagentskaapp.service.implementation;

import com.example.dislinktagentskaapp.dto.OwnershipRequestDTO;
import com.example.dislinktagentskaapp.exception.RequestNotFoundException;
import com.example.dislinktagentskaapp.model.OwnershipRequest;
import com.example.dislinktagentskaapp.model.Role;
import com.example.dislinktagentskaapp.repository.RequestRepository;
import com.example.dislinktagentskaapp.service.CompanyService;
import com.example.dislinktagentskaapp.service.RequestService;
import com.example.dislinktagentskaapp.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RequestServiceImplementation implements RequestService {

    @Autowired
    RequestRepository requestRepository;

    @Autowired
    UserService userService;

    @Autowired
    CompanyService companyService;

    @Override
    public OwnershipRequestDTO createRequest(OwnershipRequestDTO requestDTO) {
        OwnershipRequest request = new OwnershipRequest(requestDTO);
        requestRepository.save(request);
        return new OwnershipRequestDTO(request);
    }

    @Override
    public boolean manageRequest(String id, boolean requestResponse) {
        boolean response = false;
        OwnershipRequest request = requestRepository.findById(id).orElseThrow(RequestNotFoundException::new);

        if(requestResponse){
            userService.changeRole(request.idUser, Role.COMPANY_OWNER);
            companyService.registerCompany(request.company);
            request.status = "APPROVED";
            requestRepository.save(request);
            response = true;
        } else {
            request.status = "DENIED";
            requestRepository.save(request);
        }
        return response;
    }
}
