package io.jagdesh.CRUD_with_Testing.service.impl;

import io.jagdesh.CRUD_with_Testing.entity.Employee;
import io.jagdesh.CRUD_with_Testing.exceptions.ResourceAlreadyExistsException;
import io.jagdesh.CRUD_with_Testing.exceptions.ResourceNotFoundException;
import io.jagdesh.CRUD_with_Testing.repository.EmployeeRepository;
import io.jagdesh.CRUD_with_Testing.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    private EmployeeRepository empRepo;

    @Autowired
    public EmployeeServiceImpl(EmployeeRepository employeeRepository) {
        this.empRepo = employeeRepository;
    }

    @Override
    public Employee saveEmployee(Employee employee) {
        Optional<Employee> optionalEmployee = empRepo.findByEmail(employee.getEmail());
        if (optionalEmployee.isPresent()) {
            throw new ResourceAlreadyExistsException("Employee is already present");
        }
        return empRepo.save(employee);
    }

    @Override
    public List<Employee> getAllEmployees() {
        return empRepo.findAll();
    }

    @Override
    public Employee getEmployeeById(Long id) {
        return empRepo.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException(
                        "Requested employee details is not present with this ID : " + id));
    }

    @Override
    public Employee updateEmployee(Long employeeId, Employee employee) {
       return empRepo.findById(employeeId)
                .map(e -> {
                    e.setFirstName(employee.getFirstName());
                    e.setLastName(employee.getLastName());
                    e.setEmail(employee.getEmail());
                    return empRepo.save(e);
                })
                .orElseThrow(() -> new ResourceNotFoundException(
                        "Requested employee details is not present with this ID : " + employeeId));
    }

    @Override
    public void deleteEmployeeById(Long id) {
        Employee foundEmployee = empRepo.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException(
                        "Requested employee details is not present with this ID : " + id));
        empRepo.delete(foundEmployee);
    }

}
