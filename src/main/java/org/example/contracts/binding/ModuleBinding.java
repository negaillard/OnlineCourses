package org.example.contracts.binding;

import jakarta.persistence.*;
import org.example.contracts.entities.Course;

public record ModuleBinding (
    int id,
    String name,
    String description,
    int courseId)
{}
