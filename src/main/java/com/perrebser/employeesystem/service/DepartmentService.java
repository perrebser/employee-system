package com.perrebser.employeesystem.service;

import com.perrebser.employeesystem.dto.DepartmentDTO;
import com.perrebser.employeesystem.dto.EmployeeDTO;

import java.util.List;

public interface DepartmentService {

    List<DepartmentDTO> getAllDepartments();

    List<EmployeeDTO> getEmployeeByDepartmentId(Long deparmentId);
}
