package org.example.repository;

import org.example.contracts.entities.User;
import org.example.contracts.entities.UserCourse;
import org.example.contracts.entities.UserCourseStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserCourseRepository extends JpaRepository<UserCourse, int>, JpaSpecificationExecutor<UserCourse> {
    List<UserCourse> findByUserId(int userId);
    List<UserCourse> findByCourseId(int courseId);
    List<UserCourse> findByStatus(UserCourseStatus status);
}
