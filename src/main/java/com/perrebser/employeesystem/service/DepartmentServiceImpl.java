package com.perrebser.employeesystem.service;

import com.perrebser.employeesystem.dto.DepartmentDTO;
import com.perrebser.employeesystem.dto.EmployeeDTO;
import com.perrebser.employeesystem.mapper.DepartmentMapper;
import com.perrebser.employeesystem.repository.DepartmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DepartmentServiceImpl implements DepartmentService {
    @Autowired
    DepartmentRepository departmentRepository;
    @Autowired
    DepartmentMapper departmentMapper;
    @Override
    public List<DepartmentDTO> getAllDepartments() {
        return  departmentMapper.asListDepartmentDtoList(departmentRepository.findAll());
    }

    @Override
    public List<EmployeeDTO> getEmployeeByDepartmentId(Long deparmentId) {
        return null;
    }
}
