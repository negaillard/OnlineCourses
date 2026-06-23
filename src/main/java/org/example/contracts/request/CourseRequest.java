package org.example.contracts.request;

import jakarta.persistence.*;
import org.example.contracts.entities.User;

import java.util.HashSet;
import java.util.Set;

public class CourseRequest {
    private int id;
    private String name;
    private String description;
    private User user;
    private Set<User> users = new HashSet<>();
}
