package com.example.dislinktagentskaapp.dto;

import com.example.dislinktagentskaapp.model.Salary;

public class SalaryDTO {

    public String position;
    public String nettoSalary;
    public int min;
    public int max;

    public SalaryDTO() {}

    public SalaryDTO(Salary salary){
        this.position = salary.position;
        this.nettoSalary = salary.nettoSalary;
        this.min = salary.min;
        this.max = salary.max;
    }
}
