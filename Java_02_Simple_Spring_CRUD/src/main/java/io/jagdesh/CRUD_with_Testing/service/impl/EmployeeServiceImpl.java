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
        Employee savedEmployee = this.empRepo.save(employee);
        return savedEmployee;
    }

    @Override
    public List<Employee> getAllEmployees() {
        return empRepo.findAll();
    }

    @Override
    public Employee getEmployeeById(Long id) {
        Employee employee = empRepo.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Requested employee details is not present"));
        return employee;
    }

    @Override
    public Employee updateEmployee(Long employeeId, Employee employee) {
        Employee foundEmployee = empRepo.findById(employeeId)
                .orElseThrow(() -> new ResourceNotFoundException("Requested employee details is not present"));
        foundEmployee.setFirstName(employee.getFirstName());
        foundEmployee.setLastName(employee.getLastName());
        foundEmployee.setEmail(employee.getEmail());
        Employee updatedEmployee = empRepo.save(foundEmployee);
        return updatedEmployee;
    }

    @Override
    public void deleteEmployeeById(Long id) {
        Employee foundEmployee = this.empRepo.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Requested employee details is not present"));
        empRepo.deleteById(foundEmployee.getId());
    }

}
