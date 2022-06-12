package com.example.dislinktagentskaapp.repository;

import com.example.dislinktagentskaapp.model.User;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface UserRepository extends MongoRepository<User, String> {

    User findByUsername(String username);

}
