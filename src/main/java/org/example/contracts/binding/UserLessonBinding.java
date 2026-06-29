package org.example.contracts.binding;

import jakarta.persistence.*;
import org.example.contracts.entities.Lesson;
import org.example.contracts.entities.User;

public record UserLessonBinding(
        Integer id,
        Integer userId,
        Integer lessonId,
        Boolean checked) {
}
