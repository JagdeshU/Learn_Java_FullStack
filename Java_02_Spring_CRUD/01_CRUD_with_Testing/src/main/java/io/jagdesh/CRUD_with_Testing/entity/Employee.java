package io.jagdesh.CRUD_with_Testing.entity;

import com.github.javafaker.Address;
import com.github.javafaker.Code;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "employees")
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "employee_ID", nullable = false)
    private Long employeeId;

    @NotBlank(message = "Employee First Name is empty or Just whitespace in the input")
    @Length(max = 40, min = 3, message = "Length of the Employee's First Name is not between range of 3 - 40")
    @Column(name = "emp_first_name", nullable = false)
    private String empFirstName;

    @Column(name = "emp_last_name", nullable = true)
    @Length(max = 25, min = 0, message = "Length of the Employee's Last Name range is not within 25")
    private String empLastName;

    @Column(name = "emp_address", nullable = false)
    private String empAddress;

    @Column(name = "emp_code", nullable = false)
    private String empCode;

    public Employee(String firstName, String lastName, String fullAddress, String digit) {
        this.empFirstName = firstName;
        this.empLastName = lastName;
        this.empAddress = fullAddress;
        this.empCode = digit;
    }
}
