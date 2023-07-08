package com.perrebser.employeesystem.controller;

import com.perrebser.employeesystem.dto.EmployeeDTO;
import com.perrebser.employeesystem.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/api/employee")
public class EmployeeController {
@Autowired
    EmployeeService employeeService;

    @GetMapping(value = "/{employeeId}")
    public ResponseEntity<EmployeeDTO> getEmployeeById(@PathVariable Long employeeId){
       return ResponseEntity.ok(employeeService.getEmployee(employeeId));
    }
}
