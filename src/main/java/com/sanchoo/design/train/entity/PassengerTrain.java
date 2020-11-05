package com.sanchoo.design.train.entity;

import com.sanchoo.design.passenger.entity.Passenger;
import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import static com.google.common.base.Preconditions.*;

@Slf4j
public class PassengerTrain extends Train {
    public static final int PACKAGES_NUMBER = 20;
    private final List<Passenger> passengers = new ArrayList<>(PACKAGES_NUMBER);

    private PassengerTrain(String number) {
        super(number);
        log.info("Creating passenger train {}", number);
        log.info("Created passenger train {}", number);
    }

    public static PassengerTrain createPassengerTrain() {
        String number = UUID.randomUUID().toString();
        return new PassengerTrain(number);
    }

    public boolean isAdding() {
        return passengers.size() < PACKAGES_NUMBER;
    }

    public void addPassenger(Passenger passenger) {
        log.info("Adding passenger {} to train {}", passenger.getTicket().getId(), this.getNumber());
        checkNotNull(passenger, "passenger is null");
        checkNotNull(passenger.getUser(), "user info in passenger is null");
        checkState(passengers.size() < PACKAGES_NUMBER, "train is full");
        passengers.add(passenger);
        log.info("Added passenger {} to train {}", passenger.getTicket().getId(), this.getNumber());
    }

    public void removePassenger(int index) {
        log.info("Removing passenger with index {} from train {}", index, this.getNumber());
        checkArgument(index >= 0 && index < passengers.size(), "incorrect index");
        passengers.remove(index);
        log.info("Removed passenger with index {} from train {}", index, this.getNumber());
    }

    public void removePassenger(Passenger passenger) {
        log.info("Removing passenger {} from train {}", passenger.getTicket().getId(), this.getNumber());
        checkNotNull(passenger, "passenger is null");
        if(!passengers.contains(passenger)) {
            log.info("Passenger {} was not removed, because he is not in the train {}", passenger.getTicket().getId(), this.getNumber());
        }
        else {
            passengers.remove(passenger);
            log.info("Removed passenger {} from train {}", passenger.getTicket().getId(), this.getNumber());
        }
    }

    public void removeAllPassengers() {
        log.info("Removing all passengers from train {}", this.getNumber());
        passengers.clear();
        log.info("Removed all passengers from train {}", this.getNumber());
    }

    public List<Passenger> getPassengers() {
        return List.copyOf(passengers);
    }

    @Override
    public String toString() {
        return new StringBuilder(super.toString()).append(" ")
                .append("PassengerTrain{")
                .append("passengers = ").append(passengers)
                .append("}")
                .toString();
    }
}
