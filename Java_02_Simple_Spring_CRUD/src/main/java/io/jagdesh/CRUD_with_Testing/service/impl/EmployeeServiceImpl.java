package io.jagdesh.CRUD_with_Testing.service.impl;

import io.jagdesh.CRUD_with_Testing.entity.Employee;
import io.jagdesh.CRUD_with_Testing.exceptions.ResourceAlreadyExistsException;
import io.jagdesh.CRUD_with_Testing.exceptions.ResourceNotFoundException;
import io.jagdesh.CRUD_with_Testing.repository.EmployeeJpaRepository;
import io.jagdesh.CRUD_with_Testing.repository.EmployeeJdbcRepository;
import io.jagdesh.CRUD_with_Testing.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    private EmployeeJpaRepository empRepo;
    private EmployeeJdbcRepository jdbcRepo;

    @Autowired
    public EmployeeServiceImpl(EmployeeJpaRepository employeeRepository, EmployeeJdbcRepository jdbcRepository) {
        this.empRepo = employeeRepository;
        this.jdbcRepo = jdbcRepository;
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
                    e.setFirst_Name(employee.getFirst_Name());
                    e.setLast_Name(employee.getLast_Name());
                    e.setEmail(employee.getEmail());
                    e.setJoined_Date(employee.getJoined_Date());
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

    @Override
    public List<Employee> getEmployeeBasedOnJoinedDateRanges(LocalDateTime startDate, LocalDateTime endDate) {
        return empRepo.getEmployeeBasedOnJoinedDateRangesInJPA(startDate, endDate);
    }

    @Override
    public List<Employee> getEmployeeBasedOnJoinedDateRangesJDBC(LocalDateTime startDate, LocalDateTime endDate) {
        return jdbcRepo.getEmployeeBasedOnJoinedDateRangesInJDBC(startDate, endDate);
    }


}
