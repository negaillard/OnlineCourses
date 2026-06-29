package org.example.contracts.binding;

import jakarta.validation.constraints.NotBlank;
import java.time.LocalDateTime;

public record LessonBinding (
    Integer id,
    @NotBlank
    String name,
    @NotBlank
    String description,
    @NotBlank
    String link,
    LocalDateTime dateTime,
    Integer moduleId
)
{}
