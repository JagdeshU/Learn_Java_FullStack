package io.jagdesh.CRUD_with_Testing.controller;

import io.jagdesh.CRUD_with_Testing.api.EmployeeApi;
import io.jagdesh.CRUD_with_Testing.entity.Employee;
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

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping(path = "/api/v1/employees")
public class EmployeeController implements EmployeeApi {

    @Autowired
    private EmployeeService employeeService;

    private final Logger logger = LoggerFactory.getLogger(EmployeeController.class);

    public ResponseEntity<Employee> createEmployee(@RequestBody Employee employee) {
        Employee savedEmployee = employeeService.saveEmployee(employee);
        logger.info("Inside Save an Employee from the EmployeeController");
        return new ResponseEntity<Employee>(savedEmployee, HttpStatus.CREATED);
    }

    public ResponseEntity<List<Employee>> getAllEmployees() {
        List<Employee> employees = employeeService.getAllEmployees();
            logger.info("Fetching the list of all employees.");
            return new ResponseEntity<List<Employee>>(employees, HttpStatus.OK);
    }

    public ResponseEntity<Employee> getEmployeeById(@PathVariable("id") Long employeeId) {
        Employee foundEmployee = employeeService.getEmployeeById(employeeId);
        logger.info("Inside Get an Employee by an ID from the EmployeeController");
        return new ResponseEntity<Employee>(foundEmployee, HttpStatus.OK);
    }

    public ResponseEntity<Employee> updateEmployee(@PathVariable("id") Long employeeId,
                                                   @RequestBody Employee employee) {
        Employee updatedEmployee = employeeService.updateEmployee(employeeId, employee);
        logger.info("Inside Updating an Employee Details from the EmployeeController");
        return new ResponseEntity<Employee>(updatedEmployee, HttpStatus.OK);
    }

    public ResponseEntity<String> deleteEmployeeById(@PathVariable("id") Long employeeId) {
        employeeService.deleteEmployeeById(employeeId);
        logger.info("Deleted an Employee with ID : " + employeeId);
        return new ResponseEntity<String>("Employee with Id : " + employeeId + " deleted successfully",
                HttpStatus.OK);
    }

    public List<Employee> getEmployeesBasedOnJoiningDateRangesJPA(
            @RequestParam("startDate") LocalDateTime startDateStr,
            @RequestParam("endDate") LocalDateTime endDateStr
    ) {
        List<Employee> foundEmployee = employeeService.getEmployeeBasedOnJoinedDateRanges(startDateStr, endDateStr);
        return foundEmployee;
    }

    public List<Employee> getEmployeesBasedOnJoiningDateRangesJDBC(
            @RequestParam("startDate") LocalDateTime startDate,
            @RequestParam("endDate") LocalDateTime endDate
    ) {
        List<Employee> emp = employeeService.getEmployeeBasedOnJoinedDateRangesJDBC(startDate, endDate);
        return emp;
    }

}
