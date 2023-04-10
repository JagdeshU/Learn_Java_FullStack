package io.jagdesh.CRUD_with_Testing.integration;

import static org.hamcrest.CoreMatchers.is;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.time.LocalDateTime;
import java.util.List;

import io.jagdesh.CRUD_with_Testing.entity.Employee;
import io.jagdesh.CRUD_with_Testing.repository.EmployeeJpaRepository;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@AutoConfigureMockMvc
public class EmployeeControllerIntegrationTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private EmployeeJpaRepository empRepo;

    @Autowired
    private ObjectMapper objectMapper;

    LocalDateTime ldt1 = LocalDateTime.parse("2023-03-30T14:42:38.39");
    LocalDateTime ldt2 = LocalDateTime.parse("2023-04-04T22:23:36.138");
    LocalDateTime ldt3 = LocalDateTime.parse("2023-04-09T07:07:16.518");
    LocalDateTime ldt4 = LocalDateTime.parse("2023-04-09T07:07:16.520");
    LocalDateTime ldt5 = LocalDateTime.parse("2023-04-10T07:07:16.520");

    @BeforeEach
    public void setUp() {
        this.empRepo.deleteAll();
    }

    @AfterEach
    public void tearDown() {}

    @Test
    @DisplayName("JUnit test for createEmployee operation")
    public void givenEmployee_whenCreateEmployee_thenReturnEmployee() throws JsonProcessingException, Exception {

        // given - precondition or setup
        Employee employee = new Employee(1L, "Richard", "Parker",
                "richard.parkar@dtechideas.com", ldt1);
        // when - action or the behaviour
        ResultActions response = mockMvc.perform(post("/api/v1/employees")
                .contentType(MediaType.APPLICATION_JSON)
                .content(this.objectMapper.writeValueAsBytes(employee)));
        // then - verify the output
        response.andDo(print());
        response.andDo(print()).andExpect(status().isCreated())
                .andExpect(jsonPath("$.firstName", is(employee.getFirst_Name())))
                .andExpect(jsonPath("$.lastName", is(employee.getLast_Name())))
                .andExpect(jsonPath("$.email", is(employee.getEmail())));
    }

    @Test
    @DisplayName("JUnit test for getAllEmployees operation")
    public void givenEmployeesList_whenGetAllEmployees_thenReturnEmployeesList() throws Exception {
        // given - precondition or setup
        Employee employee1 = new Employee(1L,"Richard", "Parker",
                "richard.parker@dtechideas.com", ldt2);
        Employee employee2 = new Employee(2L,"Peter", "Parker",
                "peter.parker@dtechideas.com", ldt3);
        List<Employee> employees = List.of(employee1, employee2);
        this.empRepo.saveAll(employees);
        // when - action or the behaviour
        ResultActions response = mockMvc.perform(get("/api/v1/employees"));
        // then - verify the output
        response.andDo(print()).andExpect(status().isOk()).andExpect(jsonPath("$.size()",
                is(employees.size())));
    }

    @Test
    @DisplayName("JUnit test for getEmployeeById operation")
    public void givenEmployeeId_whenGetEmployeeById_thenReturnEmployee() throws Exception {
        // given - precondition or setup
        Employee employee = new Employee("Peter","Parker","peter.parker@dtechideas.com", ldt4);
        Employee savedEmployee = this.empRepo.save(employee);
        // when - action or the behaviour
        ResultActions response = mockMvc.perform(get("/api/v1/employees/{id}", savedEmployee.getEmployee_ID()));
        // then - verify the output
        response.andDo(print())
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.firstName", is(employee.getFirst_Name())))
                .andExpect(jsonPath("$.lastName", is(employee.getLast_Name())))
                .andExpect(jsonPath("$.email",is(employee.getEmail())));

    }

    @Test
    @DisplayName("JUnit test for getEmployeeById operation - ResourceNotFoundException")
    public void givenInvalidEmployeeId_whenGetEmployeeById_thenThrowsResourceNotFoundException() throws Exception {
        // given - precondition or setup
        this.empRepo.findById(0L);
        // when - action or the behaviour
        ResultActions response = mockMvc.perform(get("/api/v1/employees/{id}", 0L));
        // then - verify the output
        response.andDo(print())
                .andExpect(status().isNotFound());
    }

    @Test
    @DisplayName("JUnit test for updateEmployee operation")
    public void givenEmployeeWithUpdates_whenUpdatedEmployee_thenReturnEmployeeUpdated() throws JsonProcessingException,
            Exception {
        // given - precondition or setup
        Employee employeeForSave = new Employee("Dhandapani","Sudhakar",
                "dhandapani.sudhakar@outlook.com", ldt5);
        Employee employeeToBeUpdated = this.empRepo.save(employeeForSave);
        employeeToBeUpdated.setFirst_Name("Sudhakar");
        employeeToBeUpdated.setLast_Name("Dhandapani");
        employeeToBeUpdated.setEmail("sudhakar.dhandapani@outlook.com");
        // when - action or the behaviour
        ResultActions response = mockMvc.perform(put("/api/v1/employees/{id}", employeeToBeUpdated.getEmployee_ID())
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsBytes(employeeToBeUpdated)));
        // then - verify the output
        response.andDo(print())
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.firstName",is(employeeToBeUpdated.getFirst_Name())))
                .andExpect(jsonPath("$.lastName",is(employeeToBeUpdated.getLast_Name())))
                .andExpect(jsonPath("$.email",is(employeeToBeUpdated.getEmail())));
    }

    @Test
    @DisplayName("JUnit test for updateEmployee operation - ResourceNotFoundException")
    public void givenInvalidEmployeeWithUpdates_whenUpdatedEmployee_thenThrowsResourceNotFoundException()
            throws JsonProcessingException, Exception {
        // given - precondition or setup
        Long invalidEmployeeId = 0L;
        Employee employeeForUpdate = new Employee("Dhandapani","Sudhakar",
                "dhandapani.sudhakar@outlook.com", ldt5);
        Employee employeeToBeUpdated = this.empRepo.save(employeeForUpdate);
        employeeToBeUpdated.setFirst_Name("Sudhakar");
        employeeToBeUpdated.setLast_Name("Dhandapani");
        employeeToBeUpdated.setEmail("sudhakar.dhandapani@outlook.com");
        // when - action or the behaviour
        ResultActions response = mockMvc.perform(put("/api/v1/employees/{id}", invalidEmployeeId)
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsBytes(employeeToBeUpdated)));
        // then - verify the output
        response.andDo(print())
                .andExpect(status().isNotFound());
    }

    @Test
    @DisplayName("JUnit test for deleteEmployeeById operation")
    public void givenEmployeeId_whenDeleteEmployeeById_thenReturnTrue()throws Exception {
        // given - precondition or setup
        Employee employeeTobeSaved = new Employee("Dhandapani","Sudhakar",
                "dhandapani.sudhakar@outlook.com", ldt5);
        Employee employeeSaved = this.empRepo.save(employeeTobeSaved);
        // when - action or the behaviour
        ResultActions response = mockMvc.perform(delete("/api/v1/employees/{id}", employeeSaved.getEmployee_ID()));
        // then - verify the output
        response.andDo(print())
                .andExpect(status().isOk());
    }

    @Test
    @DisplayName("JUnit test for deleteEmployeeById operation - ResourceNotFoundException")
    public void givenInvalidEmployeeId_whenDeleteEmployeeById_thenThrowsResourceNotFoundException() throws Exception {
        // given - precondition or setup
        Long invalidEmployeeId = 0L;
        Employee employeeTobeSaved = new Employee("Dhandapani","Sudhakar",
                "dhandapani.sudhakar@outlook.com", ldt5);
        this.empRepo.save(employeeTobeSaved);
        // when - action or the behaviour
        ResultActions response = mockMvc.perform(delete("/api/v1/employees/{id}", invalidEmployeeId));
        // then - verify the output
        response.andDo(print())
                .andExpect(status().isNotFound());
    }

}
