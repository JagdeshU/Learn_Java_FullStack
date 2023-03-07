package io.jagdesh.CRUD_with_Testing.service;

import io.jagdesh.CRUD_with_Testing.entity.Employee;
import io.jagdesh.CRUD_with_Testing.exception.EmployeeNotFoundException;

import java.util.List;
import java.util.Optional;

public interface EmployeeService {

    public Employee saveAnEmployee(Employee emp);

    public List<Employee> getAllEmployees();

    public Optional<Employee> getAnEmployeeById(Long empId) throws EmployeeNotFoundException;

    public Employee updateAnEmployee(Long empId, Employee emp);

    public void deleteEmployeeById(Long empId);

}
