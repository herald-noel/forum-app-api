package com.herald.forumapi.repository;

import com.herald.forumapi.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findUserByFirstnameAndLastname(String firstname, String lastname);
}
