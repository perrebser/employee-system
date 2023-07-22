package com.perrebser.employeesystem.service;

import com.perrebser.employeesystem.dto.EmployeeDTO;
import com.perrebser.employeesystem.model.Employee;
import org.springframework.stereotype.Service;

import java.util.List;


public interface EmployeeService {

    Employee addEmployee(EmployeeDTO employeeDTO);

    EmployeeDTO updateEmployee(EmployeeDTO employeeDTO,Long employeeId);

    List<EmployeeDTO> getEmployees();

    EmployeeDTO getEmployee(Long id);

    void deleteEmployee(Long id);

}
