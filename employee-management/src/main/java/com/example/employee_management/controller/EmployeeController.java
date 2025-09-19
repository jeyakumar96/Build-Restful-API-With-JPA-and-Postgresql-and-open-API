package com.example.employee_management.controller;

import com.example.employee_management.entity.Employee;
import com.example.employee_management.exception.RecordNotFoundException;
import com.example.employee_management.service.IEmployeeService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/employees")   // Base path
public class EmployeeController {

    @Autowired
    IEmployeeService employeeService;

    @Operation(summary = "Create Employee", description = "Add a new employee into the system")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Employee created successfully",
                    content = @Content(mediaType = "application/json",
                            schema = @Schema(implementation = Employee.class))),
            @ApiResponse(responseCode = "400", description = "Invalid input data")
    })
    @PostMapping
    public ResponseEntity<Object> createEmployee(@RequestBody Employee employee) {
        employeeService.createEmployee(employee);
        return new ResponseEntity<>("Successfully Created Employee", HttpStatus.CREATED);
    }

    @Operation(summary = "Get Employee by ID", description = "Retrieve details of an employee by their ID")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Employee found",
                    content = @Content(mediaType = "application/json",
                            schema = @Schema(implementation = Employee.class))),
            @ApiResponse(responseCode = "404", description = "Employee not found")
    })
    @GetMapping("/{id}")
    public ResponseEntity<Object> getEmployeeByEmployeeId(@PathVariable long id) throws RecordNotFoundException {
        Employee response = employeeService.getEmployeeById(id);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @Operation(summary = "Get All Employees", description = "Retrieve a list of all employees")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "List of employees",
                    content = @Content(mediaType = "application/json",
                            schema = @Schema(implementation = Employee.class)))
    })
    @GetMapping
    public ResponseEntity<Object> getAllEmployees() throws RecordNotFoundException {
        List<Employee> response = employeeService.getAllEmployee();
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @Operation(summary = "Update Employee", description = "Update existing employee details")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Employee updated successfully",
                    content = @Content(mediaType = "application/json",
                            schema = @Schema(implementation = Employee.class))),
            @ApiResponse(responseCode = "404", description = "Employee not found")
    })
    @PutMapping
    public ResponseEntity<Object> updateEmployee(@RequestBody Employee employee) {
        Employee response = employeeService.updateEmployee(employee);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @Operation(summary = "Delete Employee", description = "Delete an employee by their ID")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "204", description = "Employee deleted successfully"),
            @ApiResponse(responseCode = "404", description = "Employee not found")
    })
    @DeleteMapping("/{id}")
    public ResponseEntity<Object> deleteEmployee(@PathVariable long id) throws RecordNotFoundException {
        employeeService.deleteEmployeeById(id);
        return new ResponseEntity<>("Successfully Deleted Employee", HttpStatus.NO_CONTENT);
    }
}
