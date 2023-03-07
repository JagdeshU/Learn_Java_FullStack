package io.jagdesh.CRUD_with_Testing.service;

import io.jagdesh.CRUD_with_Testing.entity.Employee;
import io.jagdesh.CRUD_with_Testing.repository.EmployeeRepository;
import io.jagdesh.CRUD_with_Testing.service.impl.EmployeeServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.BDDMockito.given;

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
        given(empRepo.save(emp))
                .willReturn(emp);
        System.out.println(empRepo);
        System.out.println(empServImpl);

        Employee savedEmp = empServImpl.saveAnEmployee(emp);
        System.out.println(savedEmp);
        assertThat(savedEmp).isNotNull();
    }

}
