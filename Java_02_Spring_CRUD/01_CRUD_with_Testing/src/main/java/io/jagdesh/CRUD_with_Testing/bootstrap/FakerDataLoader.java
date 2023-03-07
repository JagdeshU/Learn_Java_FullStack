package io.jagdesh.CRUD_with_Testing.bootstrap;

import com.github.javafaker.Faker;
import io.jagdesh.CRUD_with_Testing.entity.Employee;
import io.jagdesh.CRUD_with_Testing.repository.EmployeeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@Component
@RequiredArgsConstructor
public class FakerDataLoader implements CommandLineRunner {

    private final EmployeeRepository empRepo;
    private final Faker faker;

    @Override
    public void run(String... args) throws Exception {

        List<Employee> employee = IntStream.rangeClosed(1, 100)
                .mapToObj(i -> new Employee(
                        faker.name().firstName(),
                        faker.name().lastName(),
                        faker.address().fullAddress(),
                        faker.number().digit()
                )).collect(Collectors.toList());

        empRepo.saveAll(employee);

    }
}
