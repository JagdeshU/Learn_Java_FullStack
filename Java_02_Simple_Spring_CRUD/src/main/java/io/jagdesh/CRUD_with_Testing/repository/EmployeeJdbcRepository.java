package io.jagdesh.CRUD_with_Testing.repository;

import io.jagdesh.CRUD_with_Testing.entity.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public class EmployeeJdbcRepository {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public List<Employee> getEmployeeBasedOnJoinedDateRangesInJDBC(LocalDateTime startDate, LocalDateTime endDate) {
        String sql = "SELECT * FROM EMPLOYEE WHERE JOINED_DATE BETWEEN ? AND ?";
        return jdbcTemplate.query(
                sql, new Object[]{startDate, endDate}, (rs, rowNum) -> new Employee(
                        rs.getLong("employee_ID"),
                        rs.getString("first_Name"),
                        rs.getString("last_Name"),
                        rs.getString("email"),
                        rs.getTimestamp("joined_Date").toLocalDateTime()
                )
        );
    }

}
