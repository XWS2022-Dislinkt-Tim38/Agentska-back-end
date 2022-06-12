package com.example.dislinktagentskaapp.dto;

import com.example.dislinktagentskaapp.model.Salary;

public class SalaryNewDTO {

    public String position;
    public double min;
    public double max;
    public double averageSalary;
    public int salaryCount;

    public SalaryNewDTO() {}

    public SalaryNewDTO(String position, double min, double max, double averageSalary, int salaryCount) {
        this.position = position;
        this.min = min;
        this.max = max;
        this.averageSalary = averageSalary;
        this.salaryCount = salaryCount;
    }
}
