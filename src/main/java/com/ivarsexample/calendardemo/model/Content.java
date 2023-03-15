package com.ivarsexample.calendardemo.model;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;

import java.time.LocalDateTime;

public record Content(
        Integer id,
        @NotBlank //These are coming from the spring-boot-starter-validation we added
        String title,
        @NotBlank
        String desc,
        Status status,
        Type contentType,
        LocalDateTime dateCreated,
        LocalDateTime dateUpdated,
        String url
        ) {
}
