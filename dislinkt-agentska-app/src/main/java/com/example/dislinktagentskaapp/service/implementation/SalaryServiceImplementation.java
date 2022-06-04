package com.example.dislinktagentskaapp.service.implementation;

import com.example.dislinktagentskaapp.dto.SalaryDTO;
import com.example.dislinktagentskaapp.dto.SalaryNewDTO;
import com.example.dislinktagentskaapp.exception.CompanyNotFoundException;
import com.example.dislinktagentskaapp.model.Company;
import com.example.dislinktagentskaapp.model.Salary;
import com.example.dislinktagentskaapp.repository.CompanyRepository;
import com.example.dislinktagentskaapp.service.SalaryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.parameters.P;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class SalaryServiceImplementation implements SalaryService {

    @Autowired
    CompanyRepository companyRepository;

    private void updateMinMaxSalary(Company company){
        double minSalary = 0;
        double maxSalary = 0;
        List<Double> salaries = new ArrayList<Double>();
        for(Salary salary: company.salaries){
            salaries.add(salary.nettoSalary);
        }
        minSalary = salaries.get(0);
        maxSalary = salaries.get(0);

        for (int i = 1; i < salaries.size(); i++)
        {
            if (salaries.get(i) > maxSalary) {
                maxSalary = salaries.get(i);
            }
            else if (salaries.get(i) < minSalary) {
                minSalary = salaries.get(i);
            }
        }

        for(Salary salary: company.salaries){
            salary.max = maxSalary;
            salary.min = minSalary;
        }

    }

    @Override
    public SalaryDTO addCompanySalary(String companyId, SalaryDTO newSalaryDTO) {
        Company company = companyRepository.findById(companyId)
                .orElseThrow(CompanyNotFoundException::new);
        Salary salary = new Salary(newSalaryDTO);
        company.salaries.add(salary);
        updateMinMaxSalary(company);
        companyRepository.save(company);

        return new SalaryDTO(salary);
    }

    @Override
    public SalaryDTO getCompanySalary(String companyId, String salaryId) {
        Company company = companyRepository.findById(companyId)
                .orElseThrow(CompanyNotFoundException::new);
        Salary foundSalary = new Salary();

        for (Salary salary: company.salaries)
            if (salary.id.equals(salaryId)) {
                foundSalary = salary;
                break;
            }

        return new SalaryDTO(foundSalary);
    }

    @Override
    public List<SalaryDTO> getAllCompanySalaries(String companyId) {
        Company company = companyRepository.findById(companyId)
                .orElseThrow(CompanyNotFoundException::new);
        List<SalaryDTO> salariesDTO = new ArrayList<>();
        for (Salary salary : company.salaries)
            salariesDTO.add(new SalaryDTO(salary));
        return salariesDTO;
    }

    @Override
    public boolean updateCompanySalary(String companyId, SalaryDTO updateSalaryDTO) {
        boolean response = false;
        Company company = companyRepository.findById(companyId)
                .orElseThrow(CompanyNotFoundException::new);

        for (Salary salary : company.salaries)
            if (salary.id.equals(updateSalaryDTO.id)) {
                salary.nettoSalary = updateSalaryDTO.nettoSalary;
                salary.position = updateSalaryDTO.position;
                response = true;
                break;
            }
        updateMinMaxSalary(company);
        companyRepository.save(company);
        return response;
    }

    @Override
    public boolean deleteCompanySalary(String companyId, String salaryId) {
        Company company = companyRepository.findById(companyId)
                .orElseThrow(CompanyNotFoundException::new);

        boolean response = company.salaries.removeIf(salary -> salary.id.equals(salaryId));
        updateMinMaxSalary(company);
        companyRepository.save(company);
        return response;
    }

    @Override
    public List<SalaryNewDTO> getUniqueSalaries(String companyId) {

        List<SalaryDTO> salariesDTO = new ArrayList<>();
        salariesDTO = getAllCompanySalaries(companyId);
        List<String> salaryPositions = new ArrayList<>();
        List<String> newSalaryPosition = new ArrayList<>();

        for (SalaryDTO salaryDTO : salariesDTO) {
            salaryPositions.add(salaryDTO.position);
        }

        for (String position : salaryPositions) {
            if (!newSalaryPosition.contains(position)) {
                newSalaryPosition.add(position);
            }
        }

        List<SalaryNewDTO> filteredSalaries = new ArrayList<>();
        
        for (String position : newSalaryPosition) {
            double averageSalary = 0;
            double min = Double.POSITIVE_INFINITY;
            double max = Double.NEGATIVE_INFINITY;
            double sum = 0;
            int counter = 0;

            for (SalaryDTO salaryDTO : salariesDTO){
                if(position.equals(salaryDTO.position)){
                    sum += salaryDTO.nettoSalary;
                    counter++;

                    if(min > salaryDTO.nettoSalary){
                        min = salaryDTO.nettoSalary;
                    }
                    if(max < salaryDTO.nettoSalary){
                        max = salaryDTO.nettoSalary;
                    }
                }
            }
            averageSalary = sum/counter;

            SalaryNewDTO salaryNewDTO = new SalaryNewDTO();
            salaryNewDTO.position = position;
            salaryNewDTO.averageSalary = averageSalary;
            salaryNewDTO.salaryCount = counter;
            salaryNewDTO.max = max;
            salaryNewDTO.min = min;

            filteredSalaries.add(salaryNewDTO);

        }

        return filteredSalaries;
    }
}
