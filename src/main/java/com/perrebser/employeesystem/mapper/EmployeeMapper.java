package com.perrebser.employeesystem.mapper;

import com.perrebser.employeesystem.dto.EmployeeDTO;
import com.perrebser.employeesystem.model.Employee;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper
public interface EmployeeMapper {

    EmployeeDTO asEmployeeDto(Employee employee);

    Employee asEmployee(EmployeeDTO employeeDTO);

    List<EmployeeDTO> asEmployeeDto(List<Employee> employeeList);
}
