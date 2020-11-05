package com.sanchoo.design.ticket.entity;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.hamcrest.MatcherAssert.*;
import static org.hamcrest.Matchers.*;

class TicketTest {
    private static Ticket ticket;

    @BeforeAll
    public static void initTicket() {
        ticket = Ticket.of("Minsk", "Moscow");
    }

    @Test
    public void setCost_inccorect_cost() {
        assertThrows(IllegalArgumentException.class, () -> {
            ticket.setCost(-20);
        });
    }

    @Test
    public void setCost_success() {
        ticket.setCost(150);
        assertThat(ticket, hasProperty("cost", equalTo(150)));
    }

    @Test
    public void of_arguments_are_null() {
        assertThrows(NullPointerException.class, () -> {
            Ticket.of(null, null);
        });
        assertThrows(NullPointerException.class, () -> {
            Ticket.of("Minsk", null);
        });
        assertThrows(NullPointerException.class, () -> {
            Ticket.of(null, "Moscow");
        });
    }

    @Test
    public void of_from_equal_to() {
        assertThrows(IllegalArgumentException.class, () -> {
            Ticket.of("Minsk", "Minsk");
        });
    }

    @Test
    public void of_success() {
        assertThat(ticket, hasProperty("to", is(equalTo("Moscow"))));
        assertThat(ticket, hasProperty("from", is(equalTo("Minsk"))));
        assertThat(ticket.getFrom(),not(equalToIgnoringCase(ticket.getTo())));
    }

}