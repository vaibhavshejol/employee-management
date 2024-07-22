package com.bnt.example.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bnt.example.entities.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {
    
}
