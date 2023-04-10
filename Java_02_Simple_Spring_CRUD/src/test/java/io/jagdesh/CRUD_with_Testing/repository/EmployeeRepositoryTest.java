package io.jagdesh.CRUD_with_Testing.repository;

import io.jagdesh.CRUD_with_Testing.entity.Employee;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class EmployeeRepositoryTest {

    @Autowired
    private EmployeeJpaRepository empRepo;

    private Employee employee;

    LocalDateTime ldt = LocalDateTime.parse("2023-03-25T03:14:19.426");
    LocalDateTime ldt1 = LocalDateTime.parse("2023-03-30T14:42:38.39");
    LocalDateTime ldt2 = LocalDateTime.parse("2023-04-04T22:23:36.138");
    LocalDateTime ldt3 = LocalDateTime.parse("2023-04-09T07:07:16.518");

    @BeforeEach
    public void setUp() {
        employee = new Employee("Phrom","Jagdesh","jakki@mail.com", ldt);
    }

    @AfterEach
    public void tearDown() {
        employee = null;
    }

    // JUnit test to test save method
    @Test
    @DisplayName("JUnit test for save Employee operation")
    public void givenEmployeeObject_whenSave_thenReturnSavedEmployee() {
        // given - Pre condition / setup
        /* Employee employee = new Employee("Dhandapani", "Sudhakar", "dhandapani.s@dtechideas.com"); */
        // when - actiona or behaviour
        Employee savedEmployee = empRepo.save(employee);
        // then - verify the output
        assertThat(savedEmployee).isNotNull();
        assertThat(savedEmployee.getEmployee_ID()).isGreaterThan(0);
    }

    // JUnit test for get all Employees operation
    @Test
    @DisplayName("JUnit test for get all Employees operation")
    public void givenEmployeesList_whenFindAll_thenReturnEmployeesList() {

        // given - precondition or setup
        Employee employee1 = new Employee("John", "Cena",
                "johncena@wwe.com", ldt1);
        Employee employee2 = new Employee("Devon", "Larratt",
                "devon@armw.com", ldt2);
        Employee employee3 = new Employee("Vladimir", "Putin",
                "putin@ussr.com", ldt3);
        empRepo.save(employee1);
        empRepo.save(employee2);
        empRepo.save(employee3);
        // when - action or the behaviour
        List<Employee> employees = empRepo.findAll();
        // then - verify the output
        assertThat(employees).isNotNull();
        assertThat(employees.size()).isEqualTo(3);
    }

    // JUnit test for get Employee by Id
    @Test
    @DisplayName("JUnit test for get Employee By Id operation")
    public void givenEmployee_whenFindById_thenReturnEmployee() {
        // given - precondition or setup
        /* Employee employee = new Employee("Nanthakumar", "Mohandoss", "nandhakumar.m@dtechideas.com"); */
        empRepo.save(employee);
        // when - action or the behaviour
        Employee foundEmployee = empRepo.findById(employee.getEmployee_ID()).get();
        // then - verify the output
        assertThat(foundEmployee).isNotNull();
        assertThat(foundEmployee.getEmployee_ID()).isEqualTo(employee.getEmployee_ID());
    }

    // JUnit test for get Employee by Email
    @Test
    @DisplayName("JUnit test for get Employee By Email operation")
    public void givenEmployee_whenFindByEmail_thenReturnEmployee() {
        // given - precondition or setup
        /* Employee employee = new Employee("Kannan", "Sundaralingam", "kannan.s@dtechideas.com"); */
        empRepo.save(employee);
        // when - action or the behaviour
        Employee foundEmployee = empRepo.findByEmail(employee.getEmail()).get();
        // then - verify the output
        assertThat(foundEmployee).isNotNull();
        assertThat(foundEmployee.getEmail()).isEqualTo(employee.getEmail());
    }

    // JUnit test for update Employee
    @Test
    @DisplayName("JUnit test for update Employee operation")
    public void givenEmployee_whenUpdate_thenReturnEmployee() {
        // given - precondition or setup
        empRepo.save(employee);
        // when - action or the behaviour
        String newEmail = "dhandapani.sudhakar@dtechideas.com";
        Employee foundEmployee = empRepo.findById(employee.getEmployee_ID()).get();
        foundEmployee.setEmail(newEmail);
        Employee updatedEmployee = empRepo.save(foundEmployee);
        // then - verify the output
        assertThat(updatedEmployee).isNotNull();
        assertThat(updatedEmployee.getEmail()).isEqualTo(newEmail);
    }

    // JUnit test for delete Employee by Id
    @Test
    @DisplayName("JUnit test for delete Employee By Id operation")
    public void givenEmployee_whenDeleteById_thenRemoveEmployee() {
        // given - precondition or setup
        Employee savedEmployee = empRepo.save(employee);
        // when - action or the behaviour
        empRepo.deleteById(savedEmployee.getEmployee_ID());
        Optional<Employee> optionalEmployee = empRepo.findById(savedEmployee.getEmployee_ID());
        // then - verify the output
        assertThat(optionalEmployee).isEmpty();
    }

}
