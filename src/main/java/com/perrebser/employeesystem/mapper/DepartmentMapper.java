package com.perrebser.employeesystem.mapper;

import com.perrebser.employeesystem.dto.DepartmentDTO;
import com.perrebser.employeesystem.model.Department;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper
public interface DepartmentMapper {
    List<DepartmentDTO>asListDepartmentDtoList(List<Department> departmentList);
}
