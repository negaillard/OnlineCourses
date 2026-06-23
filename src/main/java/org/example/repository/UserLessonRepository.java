package org.example.repository;

import org.example.contracts.entities.UserCourse;
import org.example.contracts.entities.UserLesson;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserLessonRepository extends JpaRepository<UserLesson, int>, JpaSpecificationExecutor<UserLesson> {
    List<UserLesson> findByUserId(int userId);
    List<UserLesson> findByLessonId(int lessonId);
    List<UserLesson> findByChecked(boolean checked);
}
