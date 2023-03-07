package io.jagdesh.CRUD_with_Testing;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.models.annotations.OpenAPI30;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@OpenAPI30
public class CrudWithTestingApplication {

	public static void main(String[] args) {
		SpringApplication.run(CrudWithTestingApplication.class, args);
	}

}
