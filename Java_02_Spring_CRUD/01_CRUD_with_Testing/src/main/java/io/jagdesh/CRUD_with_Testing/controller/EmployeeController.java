package io.jagdesh.CRUD_with_Testing.controller;

import io.jagdesh.CRUD_with_Testing.entity.Employee;
import io.jagdesh.CRUD_with_Testing.exception.EmployeeNotFoundException;
import io.jagdesh.CRUD_with_Testing.service.EmployeeService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequiredArgsConstructor
@RequestMapping("/operations/api/v1")
public class EmployeeController {

    @Autowired
    private EmployeeService empServ;

    private final Logger logger = LoggerFactory.getLogger(EmployeeController.class);

    @Operation(summary = "Add an Employee")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Employee being added Successfully")
    })
    @PostMapping(value = "/employee")
    public Employee saveAnEmployee(@Valid @RequestBody Employee emp) {
        logger.info("Inside Save an Employee from the EmployeeController");
        return empServ.saveAnEmployee(emp);
    }

    @Operation(summary = "Fetch All Employees")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "All Employees being Fetched")
    })
    @GetMapping(value = "/employees")
    public List<Employee> getEmployeesList() {
        logger.info("Inside Get All Employee List from the EmployeeController");
        return empServ.getAllEmployees();
    }

    @Operation(summary = "Fetch an Employee by an ID")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Specific Employee being fetched")
    })
    @GetMapping(value = "employees/{id}")
    public Optional<Employee> getEmployeeById(@PathVariable("id") Long empId) throws EmployeeNotFoundException {
        logger.info("Inside Get an Employee by an ID from the EmployeeController");
        return empServ.getAnEmployeeById(empId);
    }

    @Operation(summary = "Update an Employee by an ID")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Specific Employee being Updated")
    })
    @PutMapping(value = "employees/{id}")
    public Employee updateEmployeeDetails(@PathVariable("id") Long empId, @RequestBody Employee emp) {
        logger.info("Inside Updating an Employee Details from the EmployeeController");
        return empServ.updateAnEmployee(empId, emp);
    }

    @Operation(summary = "Delete an Employee")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "204", description = "Employee Deleted")
    })
    @DeleteMapping("/employees/{id}")
    public String deleteEmployeeById(@PathVariable("id") Long empId) {
        empServ.deleteEmployeeById(empId);
        return "Department Deleted Successfully";
    }

}
