package com.perrebser.employeesystem.service;

import com.perrebser.employeesystem.dto.EmployeeDTO;
import com.perrebser.employeesystem.mapper.EmployeeMapper;
import com.perrebser.employeesystem.model.Employee;
import com.perrebser.employeesystem.repository.EmployeeRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeServiceImpl implements  EmployeeService {
    @Autowired
    EmployeeRepository employeeRepository;

    @Autowired
    EmployeeMapper employeeMapper;

    @Override
    public Employee addEmployee(EmployeeDTO employeeDTO) {
        return null;
    }

    @Override
    public List<EmployeeDTO> getEmployees() {
        return null;
    }

    @Override
    public EmployeeDTO getEmployee(Long id) {
       Optional<Employee> employee=employeeRepository.findById(id);
       if(employee.isEmpty()){
           throw new EntityNotFoundException();
       }
        return employeeMapper.asEmployeeDto(employee.get());
    }
}
