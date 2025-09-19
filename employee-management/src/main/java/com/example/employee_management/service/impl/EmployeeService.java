package com.example.employee_management.service.impl;

import com.example.employee_management.entity.Employee;
import com.example.employee_management.exception.RecordNotFoundException;
import com.example.employee_management.repository.EmployeeRepository;
import com.example.employee_management.service.IEmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class EmployeeService implements IEmployeeService {

    @Autowired
    EmployeeRepository repository;

    @Override
    public Employee getEmployeeById(Long id) throws RecordNotFoundException {
        Optional<Employee> employee = repository.findById(id);

        if (employee.isPresent()) {
            return employee.get();
        } else {
            throw new RecordNotFoundException("No employee record exist for given id");
        }
    }

    @Override
    public List<Employee> getAllEmployee() {

        List<Employee> employeeList = repository.findAll();

        if (!employeeList.isEmpty()) {
            return employeeList;
        } else {
            return new ArrayList<Employee>();
        }
    }

    @Override
    public Employee createEmployee(Employee entity) {
        repository.save(entity);
        Optional<Employee> employee = repository.findById(entity.getId());
        return employee.get();
    }

    @Override
    public Employee updateEmployee(Employee entity) {
        repository.save(entity);

        Optional<Employee> employee = repository.findById(entity.getId());
        return employee.get();
    }

    @Override
    public void deleteEmployeeById(Long id) throws RecordNotFoundException {

        Optional<Employee> employee = repository.findById(id);

        if (employee.isPresent()) {
            repository.deleteById(id);
        } else {
            throw new RecordNotFoundException("No employee record exist for given id");
        }
    }

}
