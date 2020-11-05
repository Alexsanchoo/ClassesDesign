package com.sanchoo.design.train.entity;

import com.sanchoo.design.trainDriver.entity.TrainDriver;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;

import java.util.UUID;

import static com.google.common.base.Preconditions.*;

@Slf4j
@Getter
public class Locomotive extends Train {
    private TrainDriver driver;

    private Locomotive(String number) {
        super(number);
        log.info("Creating locomotive {}", number);
        log.info("Created locomotive {}", number);
    }

    public static Locomotive createLocomotive() {
        String number = UUID.randomUUID().toString();
        return new Locomotive(number);
    }

    public void setDriver(TrainDriver driver) {
        log.info("Setting driver {} for locomotive {}", driver.getUser().getId(), this.getNumber());
        checkNotNull(driver, "driver is null");
        this.driver = driver;
        log.info("Set driver {} for locomotive {}", driver.getUser().getId(), this.getNumber());
    }

    @Override
    public String toString() {
        return new StringBuilder(super.toString()).append(" ")
                .append("Locomotive{")
                .append("driver = ").append(driver)
                .append("}")
                .toString();
    }
}
