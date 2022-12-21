package com.manager.orders.models.dto;

import java.io.Serializable;
import java.util.Objects;

/**
 * A DTO for the {@link com.manager.orders.models.entities.User} entity
 */
public class UserDto implements Serializable {
    private final String name;
    private final String email;

    public UserDto(String name, String email) {
        this.name = name;
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UserDto entity = (UserDto) o;
        return Objects.equals(this.name, entity.name) &&
                Objects.equals(this.email, entity.email);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, email);
    }

    @Override
    public String toString() {
        return getClass().getSimpleName() + "(" +
                "name = " + name + ", " +
                "email = " + email + ")";
    }
}