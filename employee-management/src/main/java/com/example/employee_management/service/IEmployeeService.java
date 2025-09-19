package com.example.employee_management.service;

import com.example.employee_management.entity.Employee;
import com.example.employee_management.exception.RecordNotFoundException;

import java.util.List;

public interface IEmployeeService {

    public Employee createEmployee(Employee entity);

    public Employee getEmployeeById(Long id) throws RecordNotFoundException;

    public List<Employee> getAllEmployee();

    public Employee updateEmployee(Employee entity);

    public void deleteEmployeeById(Long id) throws RecordNotFoundException;

}