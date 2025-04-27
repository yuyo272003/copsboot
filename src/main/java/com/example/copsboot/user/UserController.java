package com.example.copsboot.user;

import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.Set;           // ← IMPORT CORRECTO
import java.util.UUID;

// NUNCA esto:
// import org.hibernate.mapping.Set;

@RestController
@RequestMapping("/api/users")
public class UserController {
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public User createUser(@Valid @RequestBody CreateUserRequest req) {
        UUID id = UUID.randomUUID();
        // req.getRoles() debe devolver java.util.Set<UserRole>
        return userService.createUser(id,
                req.getEmail(),
                req.getPassword(),
                req.getRoles());
    }

    @GetMapping("/{id}")
    public ResponseEntity<User> getUser(@PathVariable UUID id) {
        return userService.findById(id)
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }
}
