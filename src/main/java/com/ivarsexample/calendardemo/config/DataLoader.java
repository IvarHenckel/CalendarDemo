package com.ivarsexample.calendardemo.config;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.ivarsexample.calendardemo.model.Content;
import com.ivarsexample.calendardemo.repository.ContentRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.io.InputStream;
import java.util.List;

@Component
public class DataLoader implements CommandLineRunner {
    // A CommandLineRunner has a run method which will be executed after the CommandLineRunner instance
    // is dependency injected.

    private final ContentRepository repository;
    private final ObjectMapper objectMapper;// For mapping json to Java objects.

    public DataLoader(ContentRepository repository, ObjectMapper objectMapper) {
        this.repository = repository;
        this.objectMapper = objectMapper;
    }

    @Override
    public void run(String... args) throws Exception {
        System.out.println("Hello!");
        try (InputStream inputStream = TypeReference.class.getResourceAsStream("/data/content.json")) {
            repository.saveAll(objectMapper.readValue(inputStream, new TypeReference<List<Content>>() {}));
        }
    }
}
