package com.example.copsboot.user;

import com.example.orm.jpa.AbstractEntityId;
import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;

import java.util.UUID;

@Embeddable
public class UserId extends AbstractEntityId<UUID> {

    @Column(name = "id")
    private UUID id;

    protected UserId() {
        // Constructor requerido por JPA
    }

    public UserId(UUID id) {
        super(id);
        this.id = id;
    }

    @Override
    public UUID getId() {
        return id;
    }
}
