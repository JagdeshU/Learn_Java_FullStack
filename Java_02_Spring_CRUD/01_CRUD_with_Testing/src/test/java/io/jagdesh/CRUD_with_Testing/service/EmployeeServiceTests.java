package io.jagdesh.CRUD_with_Testing.service;

import io.jagdesh.CRUD_with_Testing.entity.Employee;
import io.jagdesh.CRUD_with_Testing.exception.EmployeeNotFoundException;
import io.jagdesh.CRUD_with_Testing.repository.EmployeeRepository;
import io.jagdesh.CRUD_with_Testing.service.impl.EmployeeServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import javax.swing.text.html.Option;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.BDDMockito.given;
import static org.mockito.BDDMockito.willDoNothing;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
public class EmployeeServiceTests {

    @Mock
    private EmployeeRepository empRepo;

    @InjectMocks
    private EmployeeServiceImpl empServImpl;

    private Employee emp;

    @BeforeEach
    public void setup() {
        emp = Employee.builder()
                .employeeId(1L)
                .empFirstName("Jakki")
                .empLastName("Uma")
                .empAddress("Hasthinapurammm")
                .empCode("912")
                .build();
    }

    @DisplayName("JUnit test for saveEmployee method")
    @Test
    public void givenEmployeeObject_whenSaveEmployee_thenReturnEmployeeObject() {
        given(empRepo.save(emp)).willReturn(emp);
        Employee savedEmp = empServImpl.saveAnEmployee(emp);
        System.out.println("\n" + savedEmp);
        assertThat(savedEmp).isNotNull();
    }

    @DisplayName("JUnit test for getAllEmployees method")
    @Test
    public void givenEmployeesList_whenGetAllEmployees_thenReturnEmployeesList() {
        Employee emp1 = Employee.builder()
                .employeeId(3L)
                .empFirstName("Ant")
                .empLastName("Man")
                .empAddress("Quantumania")
                .empCode("69")
                .build();

        given(empRepo.findAll()).willReturn(List.of(emp, emp1));
        List<Employee> empList = empServImpl.getAllEmployees();
        System.out.println("\n" + empList);
        assertThat(empList).isNotNull();
        assertThat(empList.size()).isEqualTo(2);
    }

    @DisplayName("JUnit test for getAllEmployees method (negative scenario)")
    @Test
    public void givenEmptyEmployeesList_whenGetAllEmployees_thenReturnEmptyEmployeesList() {
        Employee emp1 = Employee.builder()
                .employeeId(4L)
                .empFirstName("Rick")
                .empLastName("Sanchez")
                .empAddress("Shy Pooping Planet")
                .empCode("420")
                .build();

        given(empRepo.findAll()).willReturn(Collections.emptyList());
        List<Employee> empList = empServImpl.getAllEmployees();
        System.out.println("\n" + empList);
        assertThat(empList).isNotNull();
        assertThat(empList.size()).isEqualTo(0);
    }

    @DisplayName("JUnit test for getEmployeeById method")
    @Test
    public void givenEmployeeId_whenGetEmployeeById_thenReturnEmployeeObject()
            throws EmployeeNotFoundException {
        given(empRepo.findById(1L)).willReturn(Optional.of(emp));
        Employee savedEmployee = empServImpl.getAnEmployeeById(emp.getEmployeeId()).get();
        System.out.println("\n" + savedEmployee);
        assertThat(savedEmployee).isNotNull();
    }

    // update test is yet to create

//    // delete trace
//    @DisplayName("JUnit test for deleteEmployee method")
//    @Test
//    public void givenEmployeeId_whenDeleteEmployee_thenNothing(){
//        long employeeId = 1L;
//        willDoNothing().given(empRepo).deleteById(employeeId);
//        empServImpl.deleteEmployeeById(employeeId);
//        verify(empRepo, times(1)).deleteById(employeeId);
//    }

}
