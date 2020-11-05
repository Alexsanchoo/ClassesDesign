package com.sanchoo.design.trainDriver.entity;

import com.sanchoo.design.user.entity.User;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;

import java.util.Objects;

import static com.google.common.base.Preconditions.*;

@Slf4j
@Getter
public class TrainDriver {
    public static final int AGE_TO_DRIVE = 18;
    public static final int MIN_CATEGORY = 8;
    public static final int MAX_CATEGORY = 12;
    private final User user;
    private int experience;
    private int categorySalary;

    private TrainDriver(User user) {
        log.info("Creating train driver {}", user.getId());
        this.user = user;
        log.info("Created train driver {}", user.getId());
    }

    public static TrainDriver of(User user) {
        checkUser(user);
        return new TrainDriver(user);
    }

    private static void checkUser(User user) {
        log.info("Checking user {} for train driver", user.getId());
        checkNotNull(user, "user is null");
        checkArgument(user.getAge() >= AGE_TO_DRIVE, "user is young to be a driver");
        log.info("Checked user {} for train driver", user.getId());
    }

    public void setExperience(int experience) {
        log.info("Setting experience {} for train driver {}", experience, user.getId());
        checkArgument(experience >= 0, "experience less than 0");
        this.experience = experience;
        log.info("Set experience {} for train driver {}", experience, user.getId());
    }

    public void setCategorySalary(int category) {
        log.info("Setting category {} for train driver {}", category, user.getId());
        checkArgument(category >= MIN_CATEGORY && category <= MAX_CATEGORY, "category doesn't match the range (8 .. 12)");
        this.categorySalary = category;
        log.info("Set category {} for train driver {}", category, user.getId());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TrainDriver that = (TrainDriver) o;
        return Objects.equals(user, that.user);
    }

    @Override
    public int hashCode() {
        return Objects.hash(user);
    }

    @Override
    public String toString() {
        return new StringBuilder("TrainDriver{")
                .append("user = ").append(user).append(", ")
                .append("experience = ").append(experience).append(", ")
                .append("categorySalary = ").append(categorySalary)
                .append("}")
                .toString();
    }
}
