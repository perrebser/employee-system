package com.perrebser.employeesystem.repository;

import com.perrebser.employeesystem.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface EmployeeRepository extends JpaRepository<Employee,Long> {

    Optional<Employee> findByEmailOrPhoneNumber(String email, String phoneNumber);
}
