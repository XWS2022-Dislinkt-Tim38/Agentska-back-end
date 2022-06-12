package com.example.dislinktagentskaapp.service;

import com.example.dislinktagentskaapp.dto.CommentDTO;
import com.example.dislinktagentskaapp.dto.SalaryDTO;
import com.example.dislinktagentskaapp.dto.SalaryNewDTO;

import java.util.List;

public interface SalaryService {
    SalaryDTO addCompanySalary(String companyId, SalaryDTO newSalaryDTO);
    SalaryDTO getCompanySalary(String companyId, String salaryId);
    List<SalaryDTO> getAllCompanySalaries(String companyId);
    boolean updateCompanySalary(String companyId, SalaryDTO updateSalaryDTO);
    boolean deleteCompanySalary(String companyId, String salaryId);
    List<SalaryNewDTO> getUniqueSalaries(String companyId);
}
