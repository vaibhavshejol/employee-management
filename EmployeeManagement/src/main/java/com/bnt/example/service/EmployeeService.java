package com.bnt.example.service;

import java.util.List;

import com.bnt.example.entities.Employee;

public interface EmployeeService {

    Employee addEmployee(Employee employee);

    Employee getEmployee(Long id);

    List<Employee> getEmployees();

    Employee updateEmployee(Long id, Employee employee);

    
}
