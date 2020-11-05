package com.sanchoo.design.train.entity;

import com.sanchoo.design.cargo.entity.Cargo;
import com.sanchoo.design.cargo.entity.CargoState;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.hamcrest.MatcherAssert.*;
import static org.hamcrest.Matchers.*;

class FreightTrainTest {
    private static FreightTrain train;

    @BeforeAll
    public static void initTrain() {
        train = FreightTrain.of(CargoState.LIQUID, 1000);
    }

    @Test
    public void of_state_is_null() {
        assertThrows(NullPointerException.class, () -> {
           FreightTrain.of(null, 0);
        });
    }

    @Test
    public void of_incorrect_weightCapacity() {
        assertThrows(IllegalArgumentException.class, () -> {
           FreightTrain.of(CargoState.LIQUID, -44);
        });
    }

    @Test
    public void of_success() {
        assertThat(train, hasProperty("state", is(equalTo(CargoState.LIQUID))));
        assertThat(train, hasProperty("weightCapacity", is(equalTo(1000))));
    }

    @Test
    public void setCargo_argument_is_null() {
        assertThrows(NullPointerException.class, () -> {
           train.setCargo(null);
        });
    }

    @Test
    public void setCargo_incorrect_state() {
        Cargo cargo = Cargo.of("Доски", CargoState.GASEOUS);
        cargo.setWeight(500);

        assertThrows(IllegalStateException.class, () -> {
           train.setCargo(cargo);
        });
    }

    @Test
    public void setCargo_incorrect_weightCapacity() {
        Cargo cargo = Cargo.of("Бензин", CargoState.LIQUID);
        cargo.setWeight(1500);

        assertThrows(IllegalStateException.class, () -> {
           train.setCargo(cargo);
        });
    }

    @Test
    public void setCargo_success() {
        Cargo cargo = Cargo.of("Бензин", CargoState.LIQUID);
        cargo.setWeight(500);

        train.setCargo(cargo);
        assertThat(train, hasProperty("cargo", is(equalTo(cargo))));
    }
}