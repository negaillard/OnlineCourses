package org.example.contracts.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import org.example.contracts.binding.UserBinding;

import java.util.Objects;

@Entity
@Table(name = "users")
@Getter
@Setter
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(nullable = false, length = 20, unique = true)
    private String username;

    @Column(nullable = false, unique = true)
    private String email;

    @Column(nullable = false, name = "passwordhash")
    private String passwordHash;

    @Column(nullable = false)
    private Boolean isAdmin = false;

    @Column(length = 255)
    private String bill;

    public void update(UserBinding model) {
        Objects.requireNonNull(model, "UserBinding must not be null");
        this.username = model.username();
        this.email = model.email();
        this.isAdmin = model.isAdmin();
        this.bill = model.bill();
    }
}