package org.example.contracts.binding;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

public record UserBinding (
    Integer id,
    @NotBlank
    String username,
    @Email
    String email,
    @NotBlank
    String passwordHash,
    Boolean isAdmin,
    @NotBlank
    String bill
){}
