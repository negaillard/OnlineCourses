package org.example.contracts.binding;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import org.example.contracts.entities.User;

import java.math.BigDecimal;

public record CourseBinding (
    Integer id,
    @NotBlank
    String name,
    @NotBlank
    String username,
    @NotBlank
    String description,
    Boolean isPaid,
    BigDecimal price,
    Integer userId
)
{}
