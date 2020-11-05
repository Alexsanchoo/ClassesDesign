package com.sanchoo.design.train.entity;

import com.sanchoo.design.trainDriver.entity.TrainDriver;
import com.sanchoo.design.user.entity.User;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.hamcrest.MatcherAssert.*;
import static org.hamcrest.Matchers.*;

class LocomotiveTest {
    private static Locomotive train;

    @BeforeAll
    public static void initTrain() {
        train = Locomotive.createLocomotive();
    }

    @Test
    public void setDriver_argument_is_null() {
        assertThrows(NullPointerException.class, () -> {
            train.setDriver(null);
        });
    }

    @Test
    public void setDriver_success() {

        User user = User.of("Ivan", "Ivanov");
        user.setAge(19);
        TrainDriver driver = TrainDriver.of(user);

        train.setDriver(driver);
        assertThat(train, hasProperty("driver", is(equalTo(driver))));
    }
}