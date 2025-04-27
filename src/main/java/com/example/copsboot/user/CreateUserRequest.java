package com.example.copsboot.user;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import java.util.Set;               // ← IMPORT CORRECTO

public class CreateUserRequest {

    @Email
    @NotBlank
    private String email;

    @NotBlank
    private String password;

    @NotEmpty
    private Set<UserRole> roles;    // java.util.Set<UserRole>

    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }

    public Set<UserRole> getRoles() {
        return roles;
    }
    public void setRoles(Set<UserRole> roles) {
        this.roles = roles;
    }
}
