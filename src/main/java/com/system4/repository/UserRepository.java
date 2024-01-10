package com.system4.repository;

import com.system4.model.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {
    Page<User> findByNameContainingOrSurnameContainingOrLoginContaining(
            String name, String surname, String login, Pageable pageable);
}
