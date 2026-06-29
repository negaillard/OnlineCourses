package org.example.contracts.binding;

import org.example.contracts.entities.UserCourseStatus;

public record UserCourseBinding(
    Integer id,
    Integer userId,
    Integer courseId,
    UserCourseStatus status,
    Integer progress)
{}
