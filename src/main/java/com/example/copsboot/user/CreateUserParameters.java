package com.example.copsboot.user;

import java.util.Set;

public class CreateUserParameters {
    private String email;
    private String password;
    private Set<UserRole> roles;

    // Getters y setters
    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

    public String getPassword() { return password; }
    public void setPassword(String password) { this.password = password; }

    public Set<UserRole> getRoles() { return roles; }
    public void setRoles(Set<UserRole> roles) { this.roles = roles; }
}
