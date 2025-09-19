package com.example.employee_management.controller;

import com.example.employee_management.entity.Employee;
import com.example.employee_management.exception.RecordNotFoundException;
import com.example.employee_management.service.IEmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class EmployeeController {

    @Autowired
    IEmployeeService employeeService;

    @PostMapping(value = "/employee")
    public ResponseEntity<Object> createEmployee(@RequestBody Employee employee) {
        employeeService.createEmployee(employee);
        return new ResponseEntity<Object>("Successfully Created Employee",HttpStatus.CREATED);
    }

    @GetMapping(value = "/employee/{id}")
    public ResponseEntity<Object> getEmployeeByEmployeeId(@PathVariable long id) throws RecordNotFoundException {
        Employee response = null;
        response = employeeService.getEmployeeById(id);
        return new ResponseEntity<Object>(response, HttpStatus.OK);
    }

    @GetMapping(value = "/employee")
    public ResponseEntity<Object> getAllEmployees() throws RecordNotFoundException {
        List<Employee> response = null;
        response = employeeService.getAllEmployee();
        return new ResponseEntity<Object>(response, HttpStatus.OK);
    }

    @PutMapping(value = "/employee")
    public ResponseEntity<Object> updateEmployee(@RequestBody Employee employee) {
        Employee response = null;
        response = employeeService.updateEmployee(employee);
        return new ResponseEntity<Object>(response, HttpStatus.OK);
    }

    @DeleteMapping(value = "/employee/{id}")
    public ResponseEntity<Object> deleteEmployee(@PathVariable long id) throws RecordNotFoundException {
        employeeService.deleteEmployeeById(id);
        return new ResponseEntity<Object>("Successfully Deleted Employee", HttpStatus.NO_CONTENT);
    }
}
