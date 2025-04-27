package com.example.orm.jpa;

import java.io.Serializable;
import java.util.Objects;
import static com.google.common.base.MoreObjects.toStringHelper;

public abstract class AbstractEntityId<T extends Serializable> implements Serializable, EntityId<T> {
    private T id;

    protected AbstractEntityId() {
        // Requerido por JPA
    }

    protected AbstractEntityId(T id) {
        this.id = Objects.requireNonNull(id);
    }

    @Override
    public T getId() {
        return id;
    }

    @Override
    public String asString() {
        return id.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof AbstractEntityId)) return false;
        AbstractEntityId<?> that = (AbstractEntityId<?>) o;
        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return toStringHelper(this).add("id", id).toString();
    }
}