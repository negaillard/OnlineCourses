package org.example.contracts.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.example.contracts.binding.CourseBinding;
import org.example.contracts.binding.UserBinding;

import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "courses")
@Getter
@Setter
public class Course {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(nullable = false, length = 255)
    private String name;

    @Column(nullable = false, length = 255)
    private String username;

    @Column(nullable = true, length = 4000)
    private String description;

    @Column(nullable = true, length = 4000)
    private Boolean isPaid = false;

    @Column(precision = 19, scale = 2)
    private BigDecimal price;

    @Column(name = "user_id")
    private int userId;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(
            name = "user_id",
            insertable = false,
            updatable = false
    )
    private User author;

    public void update(CourseBinding model) {
        Objects.requireNonNull(model, "CourseBinding must not be null");
        this.name = model.username();
        this.description = model.description();
    }
}
