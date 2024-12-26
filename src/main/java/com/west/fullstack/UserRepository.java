package com.west.fullstack;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findUserByUsername(String userName);

    Boolean existsUserByUsername(String userName);

    Boolean existsUserByEmail(String email);
}
