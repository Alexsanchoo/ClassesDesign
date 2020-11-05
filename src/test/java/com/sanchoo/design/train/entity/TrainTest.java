package com.sanchoo.design.train.entity;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;
import static org.hamcrest.MatcherAssert.*;
import static org.hamcrest.Matchers.*;

class TrainTest {
    private static Train train;

    @BeforeAll
    public static void initTrain() {
        String number = UUID.randomUUID().toString();
        train = new Train(number);
    }

    @Test
    public void setNextTrain_argument_is_null() {
        assertThrows(NullPointerException.class, () -> {
            train.setNextTrain(null);
        });
    }

    @Test
    public void setNextTrain_success() {
        String number = UUID.randomUUID().toString();
        Train nextTrain = new Train(number);

        train.setNextTrain(nextTrain);
        assertThat(train, hasProperty("nextTrain", is(notNullValue())));
    }
}