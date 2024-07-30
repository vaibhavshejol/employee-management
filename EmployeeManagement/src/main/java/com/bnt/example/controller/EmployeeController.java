package com.bnt.example.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bnt.example.entities.Employee;
import com.bnt.example.response.SuccessResponse;
import com.bnt.example.service.EmployeeService;

@RestController
@RequestMapping("/api/employee")
public class EmployeeController {

    private EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService){
        this.employeeService=employeeService;
    }

    @PostMapping
    public ResponseEntity<SuccessResponse> createEmployee(@RequestBody Employee employee){
        Employee createdEmployee = employeeService.addEmployee(employee);
        SuccessResponse response = new SuccessResponse("Employee added successfully.....", createdEmployee, HttpStatus.CREATED);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    @GetMapping("/{id}")
    public ResponseEntity<SuccessResponse> getEmployee(@PathVariable("id") Long id){
        Employee existedEmployee = employeeService.getEmployee(id);
        SuccessResponse response = new SuccessResponse("Employee with id = "+id, existedEmployee, HttpStatus.OK);
        return ResponseEntity.status(HttpStatus.OK).body(response);
    }

    @GetMapping
    public ResponseEntity<List<Employee>> getEmployees(){
        List<Employee> existedEmployees = employeeService.getEmployees();
    }
    
}
