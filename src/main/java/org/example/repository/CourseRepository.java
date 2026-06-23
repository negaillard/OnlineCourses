package org.example.repository;

import jakarta.persistence.criteria.Predicate;
import org.example.contracts.entities.Course;
import org.example.contracts.request.CourseRequest;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import java.util.ArrayList;
import java.util.List;


public interface CourseRepository  extends JpaRepository<Course, int>, JpaSpecificationExecutor<Course> {
    public static Specification<Course> filter(CourseRequest request) {

        return (root, query, cb) -> {

            List<Predicate> predicates =
                    new ArrayList<>();

            if (request.getId() != null) {
                predicates.add(
                        cb.equal(
                                root.get("id"),
                                request.getId()
                        )
                );
            }

            if (request.getName() != null &&
                    !request.getName().isBlank()) {

                predicates.add(
                        cb.like(
                                cb.lower(root.get("name")),
                                "%" + request.getName()
                                        .toLowerCase() + "%"
                        )
                );
            }

            if (request.getUsername() != null &&
                    !request.getUsername().isBlank()) {

                predicates.add(
                        cb.like(
                                cb.lower(root.get("username")),
                                "%" + request.getUsername()
                                        .toLowerCase() + "%"
                        )
                );
            }

            if (request.getDescription() != null &&
                    !request.getDescription().isBlank()) {

                predicates.add(
                        cb.like(
                                cb.lower(root.get("description")),
                                "%" + request.getDescription()
                                        .toLowerCase() + "%"
                        )
                );
            }

            if (request.getIsPaid() != null) {

                predicates.add(
                        cb.equal(
                                root.get("paid"),
                                request.getIsPaid()
                        )
                );
            }

            if (request.getMinPrice() != null) {
                predicates.add(
                        cb.ge(
                                root.get("price"),
                                request.getMinPrice()
                        )
                );
            }

            if (request.getMaxPrice() != null) {
                predicates.add(
                        cb.le(
                                root.get("price"),
                                request.getMaxPrice()
                        )
                );
            }

            if (request.getUserId() != null) {

                predicates.add(
                        cb.equal(
                                root.get("userId"),
                                request.getUserId()
                        )
                );
            }

            return cb.and(
                    predicates.toArray(
                            new Predicate[0]
                    )
            );
        };
    }
}
