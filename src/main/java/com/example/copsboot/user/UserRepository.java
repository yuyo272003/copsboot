package com.example.copsboot.user;

import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface UserRepository extends CrudRepository<User, UserId>, UserRepositoryCustom {
    Optional<User> findByEmail(String email); // ✅ agregado
}
