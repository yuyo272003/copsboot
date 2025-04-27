package com.example.orm.jpa;

import jakarta.persistence.EmbeddedId;
import jakarta.persistence.MappedSuperclass;
import java.util.Objects;
import static com.google.common.base.MoreObjects.toStringHelper;
import static com.google.common.base.Preconditions.checkNotNull;

@MappedSuperclass
public abstract class AbstractEntity<T extends EntityId> implements Entity<T> {
    @EmbeddedId
    private T id;

    protected AbstractEntity() {}

    public AbstractEntity(T id) {
        this.id = checkNotNull(id);
    }

    @Override
    public T getId() {
        return id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof AbstractEntity)) return false;
        AbstractEntity<?> that = (AbstractEntity<?>) o;
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