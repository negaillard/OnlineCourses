package org.example.contracts.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.example.contracts.binding.UserLessonBinding;


import java.util.Objects;

@Entity
@Table(name = "user_lessons")
@Getter
@Setter
public class UserLesson {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "user_id", nullable = false)
    private int userId;
    @ManyToOne
    @JoinColumn(
            name = "user_id",
            nullable = false,
            insertable = false,
            updatable = false
    )
    private User user;

    @Column(name = "lesson_id", nullable = false)
    private int lessonId;
    @ManyToOne
    @JoinColumn(
            name = "lesson_id",
            nullable = false,
            insertable = false,
            updatable = false
    )
    private Lesson lesson;

    @Column(nullable = false)
    private Boolean checked;

    public void update(UserLessonBinding model) {
        Objects.requireNonNull(model, "UserLessonBinding must not be null");
        this.checked = model.checked();
    }
}
