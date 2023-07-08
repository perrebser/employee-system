package com.perrebser.employeesystem.repository;

import com.perrebser.employeesystem.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee,Long> {

}
