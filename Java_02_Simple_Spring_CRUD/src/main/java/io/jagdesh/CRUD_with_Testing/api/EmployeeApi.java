package io.jagdesh.CRUD_with_Testing.api;

import io.jagdesh.CRUD_with_Testing.entity.Employee;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@Tag(name = "Employee Service", description = "List of CRUD endpoints to manage Employees")
public interface EmployeeApi {

    @Operation(summary = "Add an Employee")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Employee being added successfully.")
    })
    @PostMapping
    public ResponseEntity<Employee> createEmployee(@RequestBody Employee employee);

    @Operation(summary = "Fetch all employees")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "All Employees being fetched."),
            @ApiResponse(responseCode = "204", description = "Employees List is Empty.")
    })
    @GetMapping
    public ResponseEntity<List<Employee>> getAllEmployees();

    @Operation(summary = "Fetch an Employee by an ID")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Specific Employee being fetched"),
            @ApiResponse(responseCode = "404", description = "Specific Employee is not available")
    })
    @GetMapping(path = "/{id}")
    public ResponseEntity<Employee> getEmployeeById(@PathVariable("id") Long employeeId);

    @Operation(summary = "Update an Employee by an ID")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Specific Employee being Updated")
    })
    @PutMapping("/{id}")
    public ResponseEntity<Employee> updateEmployee(@PathVariable("id") Long employeeId,
                                                   @RequestBody Employee employee);

    @Operation(summary = "Delete an Employee")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Employee Deleted")
    })
    @DeleteMapping(path = "/{id}")
    public ResponseEntity<String> deleteEmployeeById(@PathVariable("id") Long employeeId);

    @Operation(summary = "Fetch Employees based on Joining Date using JPA")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Specific Employees are being fetched"),
            @ApiResponse(responseCode = "404", description = "Specific Employees is not available")
    })
    @GetMapping(path = "/JPA/startDate-endDate")
    public List<Employee> getEmployeesBasedOnJoiningDateRangesJPA(
            @RequestParam("startDate") LocalDateTime startDateStr,
            @RequestParam("endDate") LocalDateTime endDateStr
    );

    @Operation(summary = "Fetch Employees based on Joining Date using JDBC")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Specific Employees are being fetched"),
            @ApiResponse(responseCode = "404", description = "Specific Employees is not available")
    })
    @GetMapping(path = "/JDBC/startDate-endDate")
    public List<Employee> getEmployeesBasedOnJoiningDateRangesJDBC(
            @RequestParam("startDate") LocalDateTime startDate,
            @RequestParam("endDate") LocalDateTime endDate
    );

}
