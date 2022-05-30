package com.example.dislinktagentskaapp.repository;

import com.example.dislinktagentskaapp.model.OwnershipRequest;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface RequestRepository extends MongoRepository<OwnershipRequest, String> {
}
