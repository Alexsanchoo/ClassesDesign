package com.sanchoo.design.trainDriver.entity;

import com.sanchoo.design.user.entity.User;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.hamcrest.MatcherAssert.*;
import static org.hamcrest.Matchers.*;

class TrainDriverTest {
    private static TrainDriver trainDriver;

    @BeforeAll
    public static void initTrainDriver() {
        User user = User.of("Ivan", "Ivanov");
        user.setAge(19);
        trainDriver = TrainDriver.of(user);
    }

    @Test
      public void of_argument_is_null() {
        assertThrows(NullPointerException.class, () -> {
            TrainDriver.of(null);
        });
    }

    @Test
    public void of_user_is_young() {
        assertThrows(IllegalArgumentException.class, () -> {
            User user = User.of("Ivan", "Ivanov");
            user.setAge(15);
            TrainDriver.of(user);
        });
    }

    @Test
    public void of_success() {
        assertThat(trainDriver, hasProperty("user", notNullValue()));
        assertThat(trainDriver.getUser().getAge(), is(equalTo(19)));
    }


    @Test
    public void setExperience_incorrect_experience() {
        assertThrows(IllegalArgumentException.class, () -> {
            trainDriver.setExperience(-22);
        });
    }

    @Test
    public void setExperience_success() {
        trainDriver.setExperience(12);

        assertThat(trainDriver, hasProperty("experience", is(equalTo(12))));
    }

    @Test
      public void setCategorySalary_incorrect_category() {
        assertThrows(IllegalArgumentException.class, () -> {
            trainDriver.setCategorySalary(16);
        });
        assertThrows(IllegalArgumentException.class, () -> {
            trainDriver.setCategorySalary(6);
        });
    }

    @Test
      public void setCategorySalary_success() {
        for(int i = 8; i <= 12; i++) {
            trainDriver.setCategorySalary(i);
            assertThat(trainDriver, hasProperty("categorySalary", is(equalTo(i))));
        }
    }
}