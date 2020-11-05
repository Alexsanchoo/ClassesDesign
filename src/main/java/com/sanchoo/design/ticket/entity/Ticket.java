package com.sanchoo.design.ticket.entity;

import lombok.Getter;
import lombok.extern.slf4j.Slf4j;

import java.util.Objects;
import java.util.UUID;

import static com.google.common.base.Preconditions.*;

@Getter
@Slf4j
public class Ticket {
    private final String id;
    private final String from;
    private final String to;
    private int cost;

    private Ticket(String id, String from, String to) {
        log.info("Creating ticket {}", id);
        this.id = id;
        this.from = from;
        this.to = to;
        log.info("Created ticket {}", this.id);
    }

    public static Ticket of(String from, String to) {
        checkNotNull(from, "\"from\" is null");
        checkNotNull(to, "\"to\" is null");
        checkArgument(!from.equalsIgnoreCase(to), "\"from\" is equal \"to\"");
        String id = UUID.randomUUID().toString();
        return new Ticket(id, from ,to);
    }

    public void setCost(int cost) {
        log.info("Setting cost of {} for ticket {}", cost, this.id);
        checkArgument(cost > 0, "cost less than 0");
        this.cost = cost;
        log.info("Setting cost of {} for ticket {}", this.cost, this.id);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Ticket ticket = (Ticket) o;
        return Objects.equals(id, ticket.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return new StringBuilder("Ticket{")
                .append("id = ").append(id).append(", ")
                .append("from = ").append(from).append(", ")
                .append("to = ").append(to).append(", ")
                .append("cost = ").append(cost / 100.0)
                .append("}")
                .toString();
    }
}
