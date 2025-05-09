// src/main/java/com/example/copsboot/user/UserRepository.java
package com.example.copsboot.user;

import org.springframework.data.repository.CrudRepository;
import java.util.UUID;

public interface UserRepository extends CrudRepository<User, UUID> {}