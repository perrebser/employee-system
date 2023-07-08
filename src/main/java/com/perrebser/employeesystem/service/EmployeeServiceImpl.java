package com.perrebser.employeesystem.service;

import com.perrebser.employeesystem.dto.EmployeeDTO;
import com.perrebser.employeesystem.mapper.EmployeeMapper;
import com.perrebser.employeesystem.model.Employee;
import com.perrebser.employeesystem.repository.EmployeeRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DuplicateKeyException;
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
        if(employeeRepository.findByEmailOrPhoneNumber(employeeDTO.getEmail()
                ,employeeDTO.getPhoneNumber()).isPresent()){
            throw new DuplicateKeyException("Already exists");
        }
         return employeeRepository.save(employeeMapper.asEmployee(employeeDTO));
    }

    @Override
    public List<EmployeeDTO> getEmployees() {
        return employeeMapper.asEmployeeDto(employeeRepository.findAll());
    }

    @Override
    public EmployeeDTO getEmployee(Long id) {
       Optional<Employee> employee=employeeRepository.findById(id);
       if(employee.isEmpty()){
           throw new EntityNotFoundException();
       }
        return employeeMapper.asEmployeeDto(employee.get());
    }

    @Override
    public void deleteEmployee(Long id) {
        if(employeeRepository.findById(id).isEmpty()){
            throw new EntityNotFoundException();
        }else{
            employeeRepository.deleteById(id);
        }
    }
}
