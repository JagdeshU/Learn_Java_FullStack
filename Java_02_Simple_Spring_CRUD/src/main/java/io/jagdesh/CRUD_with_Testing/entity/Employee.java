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

import java.time.LocalDateTime;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name = "employee", uniqueConstraints = {@UniqueConstraint(columnNames = {"email"})})
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(nullable = false)
    private Long employee_ID;

    @NotBlank(message = "Employee First Name is empty or Just whitespace in the input")
    @Length(max = 40, min = 3, message = "Length of the Employee's First Name is not between range of 3 - 40")
    @Column(nullable = false)
    private String first_Name;
    @Column(nullable = true)
    @Length(max = 25, min = 0, message = "Length of the Employee's Last Name range is not within 25")
    private String last_Name;

    @Column(name = "email", nullable = false)
    @Email
    private String email;

    private LocalDateTime joined_Date;

    //  Faker Java constructors
    public Employee(String firstName, String lastName, String emailAddress, LocalDateTime date) {
        this.first_Name = firstName;
        this.last_Name = lastName;
        this.email = emailAddress;
        this.joined_Date = date;
    }

}
