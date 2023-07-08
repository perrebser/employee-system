package com.perrebser.employeesystem.mapper;

import com.perrebser.employeesystem.dto.EmployeeDTO;
import com.perrebser.employeesystem.model.Employee;
import org.mapstruct.Mapper;

@Mapper
public interface EmployeeMapper {

    EmployeeDTO asEmployeeDto(Employee employee);

    Employee asEmployee(EmployeeDTO employeeDTO);
}
