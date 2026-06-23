package org.example.repository;

import jakarta.persistence.criteria.Predicate;
import org.example.contracts.entities.User;

import org.example.contracts.request.UserRequest;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public interface UserRepository  extends JpaRepository<User, int>, JpaSpecificationExecutor<User> {
    // methods for checkModel
    Optional<User> findByUsername(String username);
    Optional<User> findByEmail(String username);


    // universal filter method
    public static Specification<User> filter(UserRequest request) {

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

            if (request.getEmail() != null &&
                    !request.getEmail().isBlank()) {

                predicates.add(
                        cb.like(
                                cb.lower(root.get("email")),
                                "%" + request.getEmail()
                                        .toLowerCase() + "%"
                        )
                );
            }

            if (request.getPasswordHash() != null) {

                predicates.add(
                        cb.equal(
                                root.get("passwordhash"),
                                request.getPasswordHash()
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
