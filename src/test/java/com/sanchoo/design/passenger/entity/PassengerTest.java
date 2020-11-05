package com.sanchoo.design.passenger.entity;

import com.sanchoo.design.ticket.entity.Ticket;
import com.sanchoo.design.user.entity.User;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.hamcrest.MatcherAssert.*;
import static org.hamcrest.Matchers.*;

class PassengerTest {
    private static Passenger passenger;

    @BeforeAll
    public static void initPassenger() {
        Ticket ticket = Ticket.of("Minsk", "Moscow");
        ticket.setCost(123);
        passenger = Passenger.of(ticket);
    }

    @Test
    public void setUser_user_is_null() {
        User user = null;

        assertThrows(NullPointerException.class, () -> {
           passenger.setUser(user);
        });
    }

    @Test
    public void setUser_success() {
        User user = User.of("Ivan", "Ivanov");

        passenger.setUser(user);
        assertThat(passenger, hasProperty("user", equalTo(user)));
    }

    @Test
    public void of_argument_is_null() {
        assertThrows(NullPointerException.class, () -> {
            Passenger.of(null);
        });
    }

    @Test
    public void of_success() {
        assertThat(passenger, hasProperty("ticket", is(notNullValue())));
    }
}