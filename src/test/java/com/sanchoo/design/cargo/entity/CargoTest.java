package com.sanchoo.design.cargo.entity;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.hamcrest.MatcherAssert.*;
import static org.hamcrest.Matchers.*;

class CargoTest {
    private static Cargo cargo;

    @BeforeAll
    public static void initCargo() {
        cargo = Cargo.of("Ацетон", CargoState.LIQUID);
    }

    @Test
    public void setWeight_incorrect_weight() {
        assertThrows(IllegalArgumentException.class, () -> {
           cargo.setWeight(-120);
        });
    }

    @Test
    public void setWeight_success() {
        cargo.setWeight(150);
        assertThat(cargo, hasProperty("weight", equalTo(150)));
    }

    @Test
    public void of_arguments_are_null() {
        assertThrows(NullPointerException.class, () -> {
            Cargo.of(null, null);
        });
        assertThrows(NullPointerException.class, () -> {
            Cargo.of("Ацетон", null);
        });
        assertThrows(NullPointerException.class, () -> {
            Cargo.of(null, CargoState.LIQUID);
        });
    }

    @Test
    public void of_success() {
        assertThat(cargo, hasProperty("name", is(equalTo("Ацетон"))));
        assertThat(cargo, hasProperty("state", is(equalTo(CargoState.LIQUID))));
    }
}