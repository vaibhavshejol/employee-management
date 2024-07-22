package com.bnt.example.service.serviceimpl;

import org.springframework.stereotype.Service;

import com.bnt.example.entities.Employee;
import com.bnt.example.exception.UnknownException;
import com.bnt.example.service.EmployeeService;
import com.bnt.example.repository.EmployeeRepository;

@Service
public class EmployeeServiceImpl implements EmployeeService{

    private EmployeeRepository employeeRepository;

    public EmployeeServiceImpl(EmployeeRepository employeeRepository){
        this.employeeRepository=employeeRepository;
    }

    @Override
    public Employee addEmployee(Employee employee) {
        try{
            if(employee==null || employee.getName()==null|| employee.getCompany()==null){
                throw new UnknownException("Employee object or field cannot be null.");
            }
            return employeeRepository.save(employee);
        }catch(Exception e){
            throw new UnknownException(e.getMessage());
        }
    }
    
}
