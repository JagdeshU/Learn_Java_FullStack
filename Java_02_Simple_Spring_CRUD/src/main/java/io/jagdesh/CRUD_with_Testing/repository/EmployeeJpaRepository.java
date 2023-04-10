package io.jagdesh.CRUD_with_Testing.repository;

import io.jagdesh.CRUD_with_Testing.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Repository
public interface EmployeeJpaRepository extends JpaRepository<Employee, Long> {

    Optional<Employee> findByEmail(String email);

    @Query("select e from Employee e where e.joined_Date between ?1 and ?2")
    List<Employee> getEmployeeBasedOnJoinedDateRangesInJPA(LocalDateTime startDate, LocalDateTime endDate);

}
