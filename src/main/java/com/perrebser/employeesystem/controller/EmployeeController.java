package com.perrebser.employeesystem.controller;

import com.perrebser.employeesystem.dto.EmployeeDTO;
import com.perrebser.employeesystem.mapper.EmployeeMapper;
import com.perrebser.employeesystem.model.Employee;
import com.perrebser.employeesystem.service.DepartmentService;
import com.perrebser.employeesystem.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.time.Instant;
import java.util.Date;
import java.util.List;

@Controller
@RequestMapping(value = "/employees")
public class EmployeeController {
    @Autowired
    EmployeeService employeeService;

    @Autowired
    EmployeeMapper employeeMapper;

    @Autowired
    DepartmentService departmentService;

    @GetMapping(value = "/{employeeId}")
    public ResponseEntity<EmployeeDTO> getEmployeeById(@PathVariable Long employeeId){
       return ResponseEntity.ok(employeeService.getEmployee(employeeId));
    }

    @GetMapping("/new")
    public String showAddEmployeeForm(Model model) {
        model.addAttribute("departments",departmentService.getAllDepartments());
        return "create_employee";
    }

    @PostMapping("/new")
    public String addEmployee(@ModelAttribute EmployeeDTO employeeDTO){
        employeeDTO.setContractDate(Date.from(Instant.now()));
        employeeService.addEmployee(employeeDTO);
        return "redirect:/employees/";
    }

    @GetMapping(value = "/")
    public ModelAndView getEmployees() {
        ModelAndView mvw=new ModelAndView("employees");
        mvw.addObject("employees",employeeService.getEmployees());
        return mvw;
    }

    @GetMapping(value = "/edit/{employeeId}")
    public String showEditEmployeeForm(@PathVariable Long employeeId, Model model){
        EmployeeDTO employeeDTO = employeeService.getEmployee(employeeId);
        model.addAttribute("employee", employeeDTO);
        return "edit_employee";
    }
    @PostMapping("/edit/{employeeId}")
    public String editEmployee(@ModelAttribute EmployeeDTO employeeDTO,@PathVariable Long employeeId) {
        employeeService.updateEmployee(employeeDTO,employeeId);
        return "redirect:/employees/";
    }

    @PostMapping(value = "/delete/{employeeId}")
    public String deleteEmployeeById(@ModelAttribute("employeeId") Long employeeId){
        employeeService.deleteEmployee(employeeId);
        return "redirect:/employees/";
    }
}
