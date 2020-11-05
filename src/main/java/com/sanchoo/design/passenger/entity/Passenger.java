package com.sanchoo.design.passenger.entity;

import com.sanchoo.design.ticket.entity.Ticket;
import com.sanchoo.design.user.entity.User;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;

import java.util.Objects;

import static com.google.common.base.Preconditions.*;


@Slf4j
@Getter
public class Passenger {
    private User user;
    private final Ticket ticket;

    private Passenger(Ticket ticket) {
        log.info("Creating passenger {}", ticket.getId());
        this.ticket = ticket;
        log.info("Created passenger {} ", ticket.getId());
    }

    public static Passenger of(Ticket ticket) {
        checkTicket(ticket);
        return new Passenger(ticket);
    }

    public void setUser(User user) {
        log.info("Setting user {} for passenger", user.getId());
        checkNotNull(user, "user is null");
        this.user = user;
        log.info("Set user {} for passenger", this.user.getId());
    }

    private static void checkTicket(Ticket ticket) {
        log.info("Setting ticket {} for passenger", ticket.getId());
        checkNotNull(ticket, "ticket is null");
        log.info("Set ticket {} for passenger", ticket.getId());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Passenger passenger = (Passenger) o;
        return Objects.equals(ticket, passenger.ticket);
    }

    @Override
    public int hashCode() {
        return Objects.hash(ticket);
    }

    @Override
    public String toString() {
        return new StringBuilder("Passenger{")
                .append("user = ").append(user).append(", ")
                .append("ticket = ").append(ticket)
                .append("}")
                .toString();
    }
}
