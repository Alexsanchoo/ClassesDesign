package com.sanchoo.design.train.entity;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.Iterator;
import java.util.NoSuchElementException;
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

    @AfterEach
    public void clearNextTrain() {
        train.removeNextTrain();
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

    @Test
    void iterator_invalid_next_train() {
        Iterator<Train> iterator = train.iterator();
        assertThrows(NoSuchElementException.class, () -> {
           iterator.next();
           iterator.next();
        });
    }

    @Test
    void iterator_success() {
        Train train2 = new Train(UUID.randomUUID().toString());
        Train train3 = new Train(UUID.randomUUID().toString());

        train.setNextTrain(train2);
        train2.setNextTrain(train3);

        Iterator<Train> iterator = train.iterator();
        assertThat(iterator.hasNext(), is(true));
        assertThat(iterator.next(), is(equalTo(train)));
        assertThat(iterator.hasNext(), is(true));
        assertThat(iterator.next(), is(equalTo(train2)));
        assertThat(iterator.hasNext(), is(true));
        assertThat(iterator.next(), is(equalTo(train3)));
        assertThat(iterator.hasNext(), is(false));
    }
}