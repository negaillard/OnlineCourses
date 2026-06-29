package org.example.contracts.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.example.contracts.binding.CourseBinding;
import org.example.contracts.binding.LessonBinding;

import java.time.LocalDateTime;
import java.util.Objects;

@Entity
@Table(name = "lessons")
@Getter
@Setter
public class Lesson {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(nullable = false, length = 255)
    private String name;

    @Column(nullable = true, length = 500)
    private String description;

    @Column(nullable = false, length = 500)
    private String link;

    @Column(nullable = false)
    private LocalDateTime dateTime;

    @Column(name = "module_id", nullable = false)
    private int moduleId;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "module_id")
    private Module module;

    public void update(LessonBinding model) {
        Objects.requireNonNull(model, "LessonBinding must not be null");
        this.name = model.name();
        this.description = model.description();
        this.link = model.link();
    }
}
