package org.example.contracts.response;

public record UserResponse (
    Integer id,
    String username,
    String email,
    Boolean isAdmin,
    String bill)
{ }
