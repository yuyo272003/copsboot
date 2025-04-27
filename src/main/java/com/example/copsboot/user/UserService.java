package com.example.copsboot.user;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public class UserService {
    private final PasswordEncoder passwordEncoder;
    private final UserRepository userRepository;

    public UserService(UserRepository userRepository, PasswordEncoder passwordEncoder) {

        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    public User createUser(String email, String password, Set<UserRole> roles) {
        UserId userId = userRepository.nextId();
        String hashedPassword = passwordEncoder.encode(password); // ✅ encriptado
        User user = new User(userId, email, hashedPassword, roles);
        return userRepository.save(user);
    }

    @Bean
    CommandLineRunner init(UserService userService) {
        return args -> {
            userService.createUser("admin@viayage.com", "123456", Set.of(UserRole.ADMIN));
        };
    }

}
