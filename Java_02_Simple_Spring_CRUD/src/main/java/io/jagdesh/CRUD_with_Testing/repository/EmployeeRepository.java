package io.jagdesh.CRUD_with_Testing.repository;

import io.jagdesh.CRUD_with_Testing.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {

    Optional<Employee> findByEmail(String email);

    @Query("select e from Employee e where e.firstName = ?1 and e.lastName = ?2")
    Employee findByJPQLFirstNameLastName(String firstName, String lastName);

    @Query("select e from Employee e where e.firstName = :fName and e.lastName = :lName")
    Employee findByJPQLNamedParamsFirstNameLastName(@Param("fName")String firstName, @Param("lName")String lastName);

    @Query(value = "select * from employees e where e.first_name = ?1 and e.last_name = ?2", nativeQuery = true)
    Employee findByNativeSQLFirstNameLastName(@Param("fName")String firstName, @Param("lName")String lastName);

    @Query(value = "select * from employees e where e.first_name = :fName and e.last_name = :lName", nativeQuery = true)
    Employee findByNativeSQLNamedParamsFirstNameLastName(@Param("fName")String firstName, @Param("lName")String lastName);

}
