package com.perrebser.employeesystem.dto;

import com.perrebser.employeesystem.model.Department;
import lombok.Data;

import java.util.Date;

@Data
public class EmployeeDTO {

    private String name;
    private String surname;
    private String email;
    private String jobTitle;
    private Department department;
    private Date contractDate;
    private String phoneNumber;
    private String city;
}
