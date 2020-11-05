package com.sanchoo.design.user.entity;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.*;
import static org.hamcrest.Matchers.*;
import static org.junit.jupiter.api.Assertions.assertThrows;

class UserTest {
    private static User user;

    @BeforeAll
    public static void initUser() {
        user = User.of("Ivan", "Ivanov");
    }

    @Test
    public void setAge_incorrect_age() {
        assertThrows(IllegalArgumentException.class, () -> {
            user.setAge(-20);
        });
    }

    @Test
    public void setAge_success() {
        user.setAge(18);
        assertThat(user, hasProperty("age", equalTo(18)));
    }

    @Test
    public void of_arguments_are_null() {
        assertThrows(NullPointerException.class, () -> {
           User.of(null, null);
        });
        assertThrows(NullPointerException.class, () -> {
           User.of("Ivan", null);
        });
        assertThrows(NullPointerException.class, () -> {
           User.of(null, "Ivanov");
        });
    }

    @Test
    public void of_success() {
        assertThat(user, hasProperty("firstName", is(equalTo("Ivan"))));
        assertThat(user, hasProperty("lastName", is(equalTo("Ivanov"))));
    }
}