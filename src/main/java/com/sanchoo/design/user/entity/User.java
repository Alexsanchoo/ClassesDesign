package com.sanchoo.design.user.entity;

import lombok.Getter;
import lombok.extern.slf4j.Slf4j;

import java.util.Objects;
import java.util.UUID;

import static com.google.common.base.Preconditions.*;

@Slf4j
@Getter
public class User {
    private final String id;
    private final String firstName;
    private final String lastName;
    private int age;


    private User(String id, String firstName, String lastName) {
        log.info("Creating user {}", id);
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        log.info("Created user {}", this.id);
    }

    public static User of(String firstName, String lastName) {
        checkNotNull(firstName, "firstname is null");
        checkNotNull(lastName, "lastname is null");
        String id = UUID.randomUUID().toString();
        return new User(id, firstName, lastName);
    }

    public void setAge(int age) {
        log.info("Setting age of {} for user {}", age, this.id);
        checkArgument(age > 0, "age less than 0");
        this.age = age;
        log.info("Set age of {} for user {}", this.age, this.id);

    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return Objects.equals(id, user.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return new StringBuilder("User{")
                .append("id = ").append(id).append(", ")
                .append("firstname = ").append(firstName).append(", ")
                .append("lastname = ").append(lastName).append(", ")
                .append("age = ").append(age)
                .append("}")
                .toString();
    }
}