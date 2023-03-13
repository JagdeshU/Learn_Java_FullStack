package io.jagdesh.CRUD_with_Testing.controller;

import io.jagdesh.CRUD_with_Testing.entity.Employee;
import io.jagdesh.CRUD_with_Testing.exceptions.ResourceNotFoundException;
import io.jagdesh.CRUD_with_Testing.service.EmployeeService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path = "/api/v1/employees")
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    private final Logger logger = LoggerFactory.getLogger(EmployeeController.class);

    @Operation(summary = "Add an Employee")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Employee being added successfully.")
    })
    @PostMapping
    public ResponseEntity<Employee> createEmployee(@RequestBody Employee employee) {
        Employee savedEmployee = employeeService.saveEmployee(employee);
        logger.info("Inside Save an Employee from the EmployeeController");
        return new ResponseEntity<Employee>(savedEmployee, HttpStatus.CREATED);
    }

    @Operation(summary = "Fetch all employees")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "All Employees being fetched.")
    })
    @GetMapping
    public ResponseEntity<List<Employee>> getAllEmployees() {
        List<Employee> employees = employeeService.getAllEmployees();
        logger.info("Inside Get All Employee List from the EmployeeController");
        return new ResponseEntity<List<Employee>>(employees, HttpStatus.OK);
    }

    @Operation(summary = "Fetch an Employee by an ID")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Specific Employee being fetched"),
            @ApiResponse(responseCode = "404", description = "Specific Employee is not available")
    })
    @GetMapping(path = "/{id}")
    public ResponseEntity<Employee> getEmployeeById(@PathVariable("id") Long employeeId) {
        Employee foundEmployee = employeeService.getEmployeeById(employeeId);
        logger.info("Inside Get an Employee by an ID from the EmployeeController");
        return new ResponseEntity<Employee>(foundEmployee, HttpStatus.OK);
    }

    @Operation(summary = "Update an Employee by an ID")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Specific Employee being Updated")
    })
    @PutMapping("/{id}")
    public ResponseEntity<Employee> updateEmployee(@PathVariable("id") Long employeeId,
                                                   @RequestBody Employee employee) {
        Employee updatedEmployee = employeeService.updateEmployee(employeeId, employee);
        logger.info("Inside Updating an Employee Details from the EmployeeController");
        return new ResponseEntity<Employee>(updatedEmployee, HttpStatus.OK);
    }

    @Operation(summary = "Delete an Employee")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Employee Deleted")
    })
    @DeleteMapping(path = "/{id}")
    public ResponseEntity<String> deleteEmployeeById(@PathVariable("id") Long employeeId) {
        employeeService.deleteEmployeeById(employeeId);
        logger.info("Deleted an Employee with ID : " + employeeId);
        return new ResponseEntity<String>("Employee with Id : " + employeeId + " deleted successfully",
                HttpStatus.OK);
    }

}
