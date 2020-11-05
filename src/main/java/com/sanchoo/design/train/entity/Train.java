package com.sanchoo.design.train.entity;

import lombok.Getter;
import lombok.extern.slf4j.Slf4j;

import java.util.Objects;
import java.util.UUID;

import static com.google.common.base.Preconditions.*;

@Slf4j
@Getter
public class Train {
    private final String number;
    private Train nextTrain;

    public Train(String number) {
        log.info("Creating train {}", number);
        this.number = number;
        log.info("Created train {}", number);
    }

    public void setNextTrain(Train train) {
        log.info("Setting next train {} for train {}", train.getNumber(), this.number);
        checkNotNull(train, "train is null");
        this.nextTrain = train;
        log.info("Set next train {} for train {}", train.getNumber(), this.number);
    }

    public boolean hasNextTrain() {
        return nextTrain != null;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Train train = (Train) o;
        return Objects.equals(number, train.number);
    }

    @Override
    public int hashCode() {
        return Objects.hash(number);
    }

    @Override
    public String toString() {
        return new StringBuilder("Train{")
                .append("number = ").append(number).append(", ")
                .append("nextTrain = ").append(nextTrain).append(", ")
                .append("}")
                .toString();
    }
}
