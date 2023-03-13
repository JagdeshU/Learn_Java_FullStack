package io.jagdesh.CRUD_with_Testing.entity;


import jakarta.persistence.Entity;
import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name = "employee", uniqueConstraints = {@UniqueConstraint(columnNames = {"email"})})
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "employee_ID", nullable = false)
    private Long id;

    @NotBlank(message = "Employee First Name is empty or Just whitespace in the input")
    @Length(max = 40, min = 3, message = "Length of the Employee's First Name is not between range of 3 - 40")
    @Column(name = "emp_first_name", nullable = false)
    private String firstName;
    @Column(name = "emp_last_name", nullable = true)
    @Length(max = 25, min = 0, message = "Length of the Employee's Last Name range is not within 25")
    private String lastName;

    @Column(name = "email", nullable = false)
    @Email
    private String email;

}
