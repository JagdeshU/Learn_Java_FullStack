package io.jagdesh.CRUD_with_Testing.service.impl;

import io.jagdesh.CRUD_with_Testing.entity.Employee;
import io.jagdesh.CRUD_with_Testing.exception.EmployeeNotFoundException;
import io.jagdesh.CRUD_with_Testing.repository.EmployeeRepository;
import io.jagdesh.CRUD_with_Testing.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    private EmployeeRepository empRepo;

    @Override
    public Employee saveAnEmployee(Employee emp) {
        return empRepo.save(emp);
    }

    @Override
    public List<Employee> getAllEmployees() {
        return empRepo.findAll();
    }

    @Override
    public Optional<Employee> getAnEmployeeById(Long empId) throws EmployeeNotFoundException {
        Optional<Employee> employee = Optional.ofNullable(empRepo.findById(empId)
                .orElseThrow(() -> new EmployeeNotFoundException("Employee is not Available")));
        return employee;
    }

    @Override
    public Employee updateAnEmployee(Long empId, Employee emp) {
        Employee empDB = empRepo.findById(empId).get();

        if (Objects.nonNull(emp.getEmpFirstName()) && !"".equalsIgnoreCase(emp.getEmpFirstName())) {
            empDB.setEmpFirstName(emp.getEmpFirstName());
        }
        if (Objects.nonNull(emp.getEmpLastName()) && !"".equalsIgnoreCase(emp.getEmpLastName())) {
            empDB.setEmpLastName(emp.getEmpLastName());
        }
        if (Objects.nonNull(emp.getEmpAddress()) && !"".equalsIgnoreCase(emp.getEmpAddress())) {
            empDB.setEmpAddress(emp.getEmpAddress());
        }
        if (Objects.nonNull(emp.getEmpCode()) && !"".equalsIgnoreCase(emp.getEmpCode())) {
            empDB.setEmpCode(emp.getEmpCode());
        }
        return empRepo.save(empDB);
    }

    @Override
    public void deleteEmployeeById(Long empId) {
        empRepo.deleteById(empId);
    }
}
