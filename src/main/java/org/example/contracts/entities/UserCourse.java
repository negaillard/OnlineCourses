package org.example.contracts.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.example.contracts.binding.UserCourseBinding;

import java.util.Objects;

@Entity
@Table(name = "user_courses")
@Getter
@Setter
public class UserCourse {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "user_id", nullable = false)
    private int userId;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(
            name = "user_id",
            insertable = false,
            updatable = false
    )
    private User user;

    @Column(name = "course_id", nullable = false)
    private int courseId;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(
            name = "course_id",
            insertable = false,
            updatable = false
    )
    private Course course;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private UserCourseStatus status;

    @Column(nullable = false)
    private Integer progress = 0;

    public void update(UserCourseBinding model) {
        Objects.requireNonNull(model, "UserCourseBinding must not be null");
        this.progress = model.progress();
        this.status = model.status();
    }
}
