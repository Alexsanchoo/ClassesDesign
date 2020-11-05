package com.sanchoo.design.train.entity;

import com.sanchoo.design.cargo.entity.Cargo;
import com.sanchoo.design.cargo.entity.CargoState;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;

import java.util.UUID;

import static com.google.common.base.Preconditions.*;

@Slf4j
@Getter
public class FreightTrain extends Train{
    private final CargoState state;
    private final int weightCapacity;
    private Cargo cargo;

    private FreightTrain(String number, CargoState state, int weightCapacity) {
        super(number);
        log.info("Creating freight train {}", number);
        this.state = state;
        this.weightCapacity = weightCapacity;
        log.info("Created freight train {}", number);
    }

    public static FreightTrain of(CargoState state, int weightCapacity) {
        checkNotNull(state, "state is null");
        checkArgument(weightCapacity > 0, "weight capacity is less than 0");
        String number = UUID.randomUUID().toString();
        return new FreightTrain(number, state, weightCapacity);
    }

    public void setCargo(Cargo cargo) {
        log.info("Setting cargo {} for train {}", cargo.getId(), this.getNumber());
        checkNotNull(cargo, "cargo is null");
        checkState(cargo.getState() == this.state, "state of train not equals state of cargo");
        checkState(this.weightCapacity >= cargo.getWeight(), "weight capacity is less than weight of cargo");
        this.cargo = cargo;
        log.info("Set cargo {} for train {}", cargo.getId(), this.getNumber());
    }

    @Override
    public String toString() {
        return new StringBuilder(super.toString()).append(" ")
                .append("FreightTrain{")
                .append("state = ").append(state).append(", ")
                .append("weightCapacity = ").append(weightCapacity).append(", ")
                .append("cargo = ").append(cargo)
                .append("}")
                .toString();
    }
}
