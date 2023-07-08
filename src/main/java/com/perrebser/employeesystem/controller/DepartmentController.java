package com.perrebser.employeesystem.controller;

import com.perrebser.employeesystem.dto.DepartmentDTO;
import com.perrebser.employeesystem.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/api/department")
public class DepartmentController {

    @Autowired
    DepartmentService departmentService;

    @GetMapping()
    public ResponseEntity<List<DepartmentDTO>> getDepartments(){
        return ResponseEntity.ok(departmentService.getAllDepartments());
    }
}
