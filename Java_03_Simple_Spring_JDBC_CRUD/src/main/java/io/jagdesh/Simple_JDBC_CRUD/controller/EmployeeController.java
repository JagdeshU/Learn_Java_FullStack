package io.jagdesh.Simple_JDBC_CRUD.controller;

import io.jagdesh.Simple_JDBC_CRUD.model.Employee;
import io.jagdesh.Simple_JDBC_CRUD.repository.EmployeeRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/employee")
public class EmployeeController {

    private final EmployeeRepository empRepo;

    @Autowired
    public EmployeeController(EmployeeRepository empRepo) {
        this.empRepo = empRepo;
    }

    @GetMapping("/all")
    public List<Employee> findAll() {
        return empRepo.findAll();
    }

    @PostMapping("/add")
    public void addEmployee(@Valid @RequestBody Employee employee) {
        empRepo.addEmployee(employee);
    }

    @GetMapping("/{id}")
    public Employee findById(@PathVariable("id") int id) {
        return empRepo.findById(id)
                .orElseThrow(() -> new RuntimeException("employee not found"));
    }

    @PutMapping("/update/{id}")
    public int updateEmployee(@Valid @RequestBody Employee employee,
                              @PathVariable("id") int id) {
        return empRepo.updateEmployee(id,employee);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteEmployee(@PathVariable("id") int id) {
        empRepo.deleteEmployee(id);
    }

}
