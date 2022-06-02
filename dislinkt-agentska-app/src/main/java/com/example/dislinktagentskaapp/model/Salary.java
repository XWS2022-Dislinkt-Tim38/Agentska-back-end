package com.example.dislinktagentskaapp.model;

import com.example.dislinktagentskaapp.dto.SalaryDTO;

public class Salary {

    public String id;

    public String idUser;
    public String position;
    public double nettoSalary;
    public double min;
    public double max;

    public Salary() {}
    public Salary(SalaryDTO salaryDTO){

        this.id = java.util.UUID.randomUUID().toString();
        this.idUser = salaryDTO.idUser;
        this.position = salaryDTO.position;
        this.nettoSalary = salaryDTO.nettoSalary;
        this.min = salaryDTO.min;
        this.max = salaryDTO.max;
    }
}
