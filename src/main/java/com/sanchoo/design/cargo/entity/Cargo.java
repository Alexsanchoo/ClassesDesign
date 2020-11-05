package com.sanchoo.design.cargo.entity;

import lombok.Getter;
import lombok.extern.slf4j.Slf4j;

import java.util.Objects;
import java.util.UUID;

import static com.google.common.base.Preconditions.*;

@Getter
@Slf4j
public class Cargo {
    private final String id;
    private final String name;
    private int weight;
    private final CargoState state;

    private Cargo(String id, String name, CargoState state) {
        log.info("Creating cargo {}", id);
        this.id = id;
        this.name = name;
        this.state = state;
        log.info("Created cargo {}", this.id);
    }

    public static Cargo of(String name, CargoState state) {
        checkNotNull(name, "name is null");
        checkNotNull(state, "state is null");
        String id = UUID.randomUUID().toString();
        return new Cargo(id, name, state);
    }

    public void setWeight(int weight) {
        log.info("Setting weight of {} for cargo {}", weight, this.id);
        checkArgument(weight > 0, "weight less than 0");
        this.weight = weight;
        log.info("Set weight of {} for cargo {}", this.weight, this.id);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Cargo cargo = (Cargo) o;
        return Objects.equals(id, cargo.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return new StringBuilder("Cargo{")
                .append("id = ").append(id).append(", ")
                .append("name = ").append(name).append(", ")
                .append("weight = ").append(weight).append(", ")
                .append("state = ").append(state)
                .append("}")
                .toString();
    }
}
