package com.example.dislinktagentskaapp.repository;

import com.example.dislinktagentskaapp.model.Comment;
import com.example.dislinktagentskaapp.model.Company;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface CompanyRepository extends MongoRepository<Company, String> {

    public Comment findCompanyCommentById(final String name);
}
