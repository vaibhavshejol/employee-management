package com.bnt.example.service.serviceimpl;

import java.util.List;

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

    @Override
    public Employee getEmployee(Long id) {
        try{
            if (id==null) {
                throw new UnknownException("Id cannot be null");
            }
            return employeeRepository.findById(id).get();
        }catch(Exception e){
            throw new UnknownException(e.getMessage());
        }
    }

    @Override
    public List<Employee> getEmployees() {
        try{
            List<Employee> existedEmployees = employeeRepository.findAll();
            if (existedEmployees==null) {
                throw new UnknownException("There is no employees present in database.");
            }
            return existedEmployees;
        }catch(Exception e){
            throw new UnknownException(e.getMessage());
        }
    }
    
}
