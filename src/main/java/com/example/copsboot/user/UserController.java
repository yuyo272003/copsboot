package com.example.copsboot.user;

import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

@RestController
@RequestMapping("/api/users")
public class UserController {

    private final UserService userService;
    private final UserRepository userRepository;

    public UserController(UserService userService, UserRepository userRepository) {
        this.userService = userService;
        this.userRepository = userRepository;
    }

    // ✅ Permite POST sin autenticación si lo configuras en SecurityConfig
    @PostMapping
    public ResponseEntity<User> createUser(@Valid @RequestBody CreateUserParameters parameters) {
        User user = userService.createUser(
                parameters.getEmail(),
                parameters.getPassword(),
                parameters.getRoles()
        );
        return ResponseEntity.status(HttpStatus.CREATED).body(user);
    }

    @GetMapping("/{id}")
    public ResponseEntity<User> getUser(@PathVariable("id") UserId id) {
        return userRepository.findById(id)
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @GetMapping
    public Iterable<User> getAllUsers() {
        return userRepository.findAll();
    }
}
