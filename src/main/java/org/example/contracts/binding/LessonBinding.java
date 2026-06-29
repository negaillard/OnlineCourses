package org.example.contracts.binding;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import org.example.contracts.entities.Module;

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
