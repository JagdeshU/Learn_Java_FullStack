package io.jagdesh.CRUD_with_Testing.service;

import io.jagdesh.CRUD_with_Testing.entity.Employee;
import io.jagdesh.CRUD_with_Testing.exceptions.ResourceAlreadyExistsException;
import io.jagdesh.CRUD_with_Testing.exceptions.ResourceNotFoundException;
import io.jagdesh.CRUD_with_Testing.repository.EmployeeJpaRepository;
import io.jagdesh.CRUD_with_Testing.service.impl.EmployeeServiceImpl;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDateTime;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.BDDMockito.given;
import static org.mockito.BDDMockito.willDoNothing;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
public class EmployeeServiceTest {

    @Mock
    private EmployeeJpaRepository empRepo;

    @InjectMocks
    private EmployeeServiceImpl empServ;

    Employee employee;

    @BeforeEach
    public void setUp() {
        LocalDateTime ldt = LocalDateTime.parse("2023-03-02T02:09:49.711");
        employee = new Employee("Janani", "J", "jan@ni.com",
                ldt);
    }

    @AfterEach
    public void tearDown() {
        employee = null;
    }

    @Test
    @DisplayName("JUnit test for saveEmployee operation")
    public void givenEmployeeObject_whenSaveEmployee_thenReturnEmployeeObject() {
        // given - precondition or setup
        given(empRepo.findByEmail(employee.getEmail())).willReturn(Optional.empty());
        given(empRepo.save(employee)).willReturn(employee);
        // when - action or the behaviour
        Employee savedEmployee = empServ.saveEmployee(employee);
        // then - verify the output
        assertThat(savedEmployee).isNotNull();

    }

    @Test
    @DisplayName("JUnit test for saveEmployee operation - ResourceAlreadyExists Exception")
    public void givenEmployeeObject_whenSaveEmployee_thenThrowsResourceAlreadyExistsException() {
        // given - precondition or setup
        given(empRepo.findByEmail(employee.getEmail())).willReturn(Optional.of(employee));
        // when - action or the behaviour
        assertThrows(ResourceAlreadyExistsException.class, () -> {
            empServ.saveEmployee(employee);
        });
        // then - verify the output
        verify(empRepo, never()).save(any(Employee.class));
    }

    @Test
    @DisplayName("JUnit test for getAllEmployees operation")
    public void givenEmployeesList_whenGetAllEmployees_thenReturnEmployeesList() {
        // given - precondition or setup
        LocalDateTime ldt1 = LocalDateTime.parse("2022-07-12T00:42:58.778");
        LocalDateTime ldt2 = LocalDateTime.parse("2023-03-10T17:09:01.184");
        Employee employee1 = new Employee("Dhandapani", "Sudhakar",
                "dhandapani.sudhakar@dtechideas.com", ldt1);
        Employee employee2 = new Employee("Kathirvel", "Sudhakar",
                "kathirvel.sudhakar@dtechideas.com", ldt2);
        given(empRepo.findAll()).willReturn(List.of(employee1,employee2));
        // when - action or the behaviour
        List<Employee> employees = empServ.getAllEmployees();
        // then - verify the output
        assertThat(employees).isNotNull();
        assertThat(employees.size()).isEqualTo(2);
    }

    @Test
    @DisplayName("JUnit test for getAllEmployees operation - Empty List (Negative Scenario)")
    public void givenEmptyEmployeesList_whenGetAllEmployees_thenReturnEmptyEmployeesList() {
        // given - precondition or setup
        given(empRepo.findAll()).willReturn(Collections.emptyList());
        // when - action or the behaviour
        List<Employee> employees = empServ.getAllEmployees();
        // then - verify the output
        assertThat(employees).isEmpty();
        assertThat(employees.size()).isEqualTo(0);
    }

    @Test
    @DisplayName("JUnit test for getEmployeeById operation")
    public void givenEmployeeId_whenFindEmployeeById_thenReturnEmployee() {
        // given - precondition or setup
        given(empRepo.findById(employee.getEmployee_ID())).willReturn(Optional.of(employee));
        // when - action or the behaviour
        Employee foundEmployee = empServ.getEmployeeById(employee.getEmployee_ID());
        // then - verify the output
        assertThat(foundEmployee).isNotNull();
        assertThat(foundEmployee.getEmployee_ID()).isEqualTo(employee.getEmployee_ID());
    }

    @Test
    @DisplayName("JUnit test for getEmployeeById operation - throw ResourceNotFoundException")
    public void givenEmployeeId_whenFindEmployeeById_thenThrowResourceNotFoundException() {
        // given - precondition or setup
        given(empRepo.findById(anyLong())).willReturn(Optional.ofNullable(null));
        // when - action or the behaviour
        assertThrows(ResourceNotFoundException.class, () -> {
            empServ.getEmployeeById(employee.getEmployee_ID());
        });
    }

    @Test
    @DisplayName("JUnit test for updateEmployee operation")
    public void givenEmployee_whenUpdateEmployee_thenReturnEmployeeUpdated() {
        // given - precondition or setup
        given(empRepo.findById(employee.getEmployee_ID())).willReturn(Optional.of(employee));
        employee.setEmail("meenakshi.r@dtechideas.com");
        given(empRepo.save(employee)).willReturn(employee);
        // when - action or the behaviour
        Employee updatedEmployee = empServ.updateEmployee(employee.getEmployee_ID(),employee);
        // then - verify the output
        assertThat(updatedEmployee).isNotNull();
        assertThat(updatedEmployee.getEmail()).isEqualTo(employee.getEmail());
    }

    @Test
    @DisplayName("JUnit test for deleteEmployeeById operation")
    public void givenEmployeeId_whenDeleteEmployeeById_thenReturnTrue() {
        // given - precondition or setup
        given(empRepo.findById(employee.getEmployee_ID())).willReturn(Optional.of(employee));
        willDoNothing().given(empRepo).deleteById(employee.getEmployee_ID());
        // when - action or the behaviour
        empServ.deleteEmployeeById(employee.getEmployee_ID());
        // then - verify the output
        verify(empRepo,times(1)).deleteById(employee.getEmployee_ID());
    }

}
