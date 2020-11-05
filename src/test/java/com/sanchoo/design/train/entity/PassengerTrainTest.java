package com.sanchoo.design.train.entity;

import com.sanchoo.design.passenger.entity.Passenger;
import com.sanchoo.design.ticket.entity.Ticket;
import com.sanchoo.design.user.entity.User;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.hamcrest.MatcherAssert.*;
import static org.hamcrest.Matchers.*;

class PassengerTrainTest {
    private static PassengerTrain train;

    @BeforeAll
    public static void initTrain() {
        train = PassengerTrain.createPassengerTrain();
    }

    @AfterEach
    public void clearTrain() {
        train.removeAllPassengers();
    }

    @Test
    public void addPassenger_argument_is_null() {
        Ticket ticket = Ticket.of("Minsk", "Moscow");
        Passenger passenger = Passenger.of(ticket);

        assertThrows(NullPointerException.class, () -> {
            train.addPassenger(null);
        });
        assertThrows(NullPointerException.class, () -> {
            train.addPassenger(passenger);
        });
    }

    @Test
    public void addPassenger_list_is_full() {
        assertThrows(IllegalStateException.class, () -> {
            User user = User.of("Ivan", "Ivanov");
            for(int i = 0; i < 21; i++) {
                Ticket ticket = Ticket.of(String.valueOf(i), String.valueOf(i + 1));
                Passenger passenger = Passenger.of(ticket);
                passenger.setUser(user);
                train.addPassenger(passenger);
            }
        });
    }

    @Test
    public void addPassenger_success() {
        Ticket ticket = Ticket.of("Minsk", "Moscow");
        User user = User.of("Ivan", "Ivanov");
        Passenger passenger = Passenger.of(ticket);
        passenger.setUser(user);

        train.addPassenger(passenger);
        assertThat(train.getPassengers(), contains(passenger));
    }

    @Test
    public void removePassenger_argument_is_null() {
        assertThrows(NullPointerException.class, () -> {
           train.removePassenger(null);
        });
    }

    @Test
    public void removePassenger_incorrect_index() {
        assertThrows(IllegalArgumentException.class, () -> {
            train.removePassenger(0);
        });
    }

    @Test
    public void removePassenger_success() {
        Ticket ticket = Ticket.of("Minsk", "Moscow");
        User user = User.of("Ivan", "Ivanov");
        Passenger passenger = Passenger.of(ticket);
        passenger.setUser(user);
        train.addPassenger(passenger);

        train.removePassenger(passenger);
        assertThat(train.getPassengers(), not(contains(passenger)));

        train.addPassenger(passenger);
        train.removePassenger(0);
        assertThat(train.getPassengers(), not(contains(passenger)));
    }
}