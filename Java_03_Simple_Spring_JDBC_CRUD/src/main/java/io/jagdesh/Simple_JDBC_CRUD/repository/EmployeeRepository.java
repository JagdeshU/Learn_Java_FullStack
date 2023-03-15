package io.jagdesh.Simple_JDBC_CRUD.repository;

import io.jagdesh.Simple_JDBC_CRUD.model.Employee;

import java.util.List;
import java.util.Optional;

public interface EmployeeRepository {

    List<Employee> findAll();
    int addEmployee(Employee employee);
    Optional<Employee> findById(int id);
    int updateEmployee(int id, Employee employee);
    int deleteEmployee(int id);

}
