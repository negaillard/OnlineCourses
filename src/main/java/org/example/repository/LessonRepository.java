package org.example.repository;

import jakarta.persistence.criteria.Predicate;
import org.example.contracts.entities.Lesson;
import org.example.contracts.request.LessonRequest;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public interface LessonRepository extends JpaRepository<Lesson, int>, JpaSpecificationExecutor<Lesson> {
    public static Specification<Lesson> filter(LessonRequest request) {

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

            return cb.and(
                    predicates.toArray(
                            new Predicate[0]
                    )
            );
        };
    }
}
