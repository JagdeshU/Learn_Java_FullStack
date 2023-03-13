package io.jagdesh.CRUD_with_Testing.service;

import io.jagdesh.CRUD_with_Testing.entity.Employee;

import java.util.List;

public interface EmployeeService {

    public Employee saveEmployee(Employee employee);
    public List<Employee> getAllEmployees();
    public Employee getEmployeeById(Long id);
    public Employee updateEmployee(Long employeeId, Employee employee);
    public void deleteEmployeeById(Long id);

}
