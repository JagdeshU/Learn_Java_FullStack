package io.jagdesh.CRUD_with_Testing.service;

import io.jagdesh.CRUD_with_Testing.entity.Employee;

import java.time.LocalDateTime;
import java.util.List;

public interface EmployeeService {

    public Employee saveEmployee(Employee employee);
    public List<Employee> getAllEmployees();
    public Employee getEmployeeById(Long id);
    public Employee updateEmployee(Long employeeId, Employee employee);
    public void deleteEmployeeById(Long id);
    public List<Employee> getEmployeeBasedOnJoinedDateRanges(LocalDateTime startDate, LocalDateTime endDate);
    public List<Employee> getEmployeeBasedOnJoinedDateRangesJDBC(LocalDateTime startDate, LocalDateTime endDate);

}
