package com.perrebser.employeesystem.controller;

import com.perrebser.employeesystem.dto.EmployeeDTO;
import com.perrebser.employeesystem.mapper.EmployeeMapper;
import com.perrebser.employeesystem.model.Employee;
import com.perrebser.employeesystem.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/api/employee")
public class EmployeeController {
    @Autowired
    EmployeeService employeeService;

    @Autowired
    EmployeeMapper employeeMapper;

    @GetMapping(value = "/{employeeId}")
    public ResponseEntity<EmployeeDTO> getEmployeeById(@PathVariable Long employeeId){
       return ResponseEntity.ok(employeeService.getEmployee(employeeId));
    }

    @PostMapping
    public ResponseEntity<EmployeeDTO> addEmployee(@RequestBody EmployeeDTO employeeDTO){
        EmployeeDTO e=employeeMapper.asEmployeeDto(employeeService.addEmployee(employeeDTO));
        return ResponseEntity.ok(e);
    }

    @GetMapping
    public ResponseEntity<List<EmployeeDTO>> getEmployees(){
        List<EmployeeDTO> list=employeeService.getEmployees();
        return ResponseEntity.ok(list);
    }

    @DeleteMapping(value = "/{employeeId}")
    public  ResponseEntity<Void> deleteEmployeeById(@PathVariable  Long employeeId){
        employeeService.deleteEmployee(employeeId);
        return ResponseEntity.ok().build();
    }
}
