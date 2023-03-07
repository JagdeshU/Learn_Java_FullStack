package io.jagdesh.CRUD_with_Testing.config;

import com.github.javafaker.Faker;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SampleDataConfig {

    Faker faker() {
        return new Faker();
    }

}
