package com.perrebser.employeesystem.controller;

import com.perrebser.employeesystem.dto.EmployeeDTO;
import com.perrebser.employeesystem.mapper.EmployeeMapper;
import com.perrebser.employeesystem.model.Employee;
import com.perrebser.employeesystem.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping(value = "/employees")
public class EmployeeController {
    @Autowired
    EmployeeService employeeService;

    @Autowired
    EmployeeMapper employeeMapper;

    @GetMapping(value = "/{employeeId}")
    public ResponseEntity<EmployeeDTO> getEmployeeById(@PathVariable Long employeeId){
       return ResponseEntity.ok(employeeService.getEmployee(employeeId));
    }

    @GetMapping("/new")
    public String showAddEmployeeForm(Model model) {
        // Aquí puedes realizar cualquier lógica adicional si es necesario
        return "create_employee";
    }

    @GetMapping(value = "/")
    public ModelAndView getEmployees() {
        ModelAndView mvw=new ModelAndView("employees");
        mvw.addObject("employees",employeeService.getEmployees());
        return mvw;
    }

    @DeleteMapping(value = "/{employeeId}")
    public  ResponseEntity<Void> deleteEmployeeById(@PathVariable  Long employeeId){
        employeeService.deleteEmployee(employeeId);
        return ResponseEntity.ok().build();
    }
}
