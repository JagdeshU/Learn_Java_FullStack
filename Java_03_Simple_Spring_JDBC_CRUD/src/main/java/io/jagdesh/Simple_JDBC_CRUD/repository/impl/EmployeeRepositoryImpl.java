package io.jagdesh.Simple_JDBC_CRUD.repository.impl;

import io.jagdesh.Simple_JDBC_CRUD.model.Employee;
import io.jagdesh.Simple_JDBC_CRUD.repository.EmployeeRepository;
import io.jagdesh.Simple_JDBC_CRUD.util.EmployeeRowMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class EmployeeRepositoryImpl implements EmployeeRepository {

    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public EmployeeRepositoryImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public List<Employee> findAll() {
        String sql = """
                SELECT id, first_name,last_name,email
                FROM employee
                LIMIT 100;
                """;
        return jdbcTemplate.query(sql, new EmployeeRowMapper());
    }

    @Override
    public int addEmployee(Employee employee) {
        String sql = """
                INSERT into employee(first_name,last_name,email)
                VALUES (?,?,?);
                """;
        return jdbcTemplate.update(sql,
                employee.getFirstName(),
                employee.getLastName(),
                employee.getEmail());
    }

    @Override
    public Optional<Employee> findById(int id) {
        String sql = """
                SELECT id, first_name, last_name, email
                FROM employee
                WHERE id = ?;
                """;
        return jdbcTemplate.query(sql, new EmployeeRowMapper(),id)
                .stream()
                .findFirst();
    }

    @Override
    public int updateEmployee(int id, Employee employee) {
        String sql = """
                UPDATE employee
                SET  first_name = ?, last_name = ?, email = ?
                WHERE id = ?;
                """;
        return jdbcTemplate.update(sql,
                employee.getFirstName(),
                employee.getLastName(),
                employee.getEmail(), id);
    }

    @Override
    public int deleteEmployee(int id) {
        String sql = """
                DELETE FROM employee
                WHERE id = ?;
                """;
        return jdbcTemplate.update(sql, id);
    }

}
