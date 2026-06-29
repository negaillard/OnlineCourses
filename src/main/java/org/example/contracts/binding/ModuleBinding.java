package org.example.contracts.binding;

import jakarta.validation.constraints.NotBlank;

public record ModuleBinding (
    int id,
    @NotBlank
    String name,
    @NotBlank
    String description,
    int courseId)
{}
