package org.example.contracts.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.example.contracts.binding.ModuleBinding;
import org.example.contracts.binding.UserBinding;

import java.util.Objects;

@Entity
@Table(name = "modules")
@Getter
@Setter
public class Module {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(nullable = false, unique = true)
    private String name;
    @Column(nullable = true, length = 500)
    private String description;

    @Column(name = "course_id")
    private int courseId;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(
            name = "course_id",
            insertable = false,
            updatable = false
    )
    private Course course;

    public void update(ModuleBinding model) {
        Objects.requireNonNull(model, "ModuleBinding must not be null");
        this.name = model.name();
        this.description = model.description();
    }
}

