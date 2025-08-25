package de.tum.in.ase.pse.controller;

import de.tum.in.ase.pse.model.GateType;
import de.tum.in.ase.pse.model.TransistorMachine;
import de.tum.in.ase.pse.model.TransistorType;
import de.tum.in.ase.pse.utils.FactoryException;

/**
 * The controller class for the model TransistorMachine
 * This class and the corresponding buttons form the controller part of the system.
 * Actually this only delegates the calls. It was however implemented to mock a dedicated controller.
 */
public class TransistorTerminal {

    private final TransistorMachine machine;
    private static final int MIN_TRANSISTOR_SIZE = 7;
    private static final int MAX_TRANSISTOR_SIZE = 22;

    public TransistorTerminal(TransistorMachine transistorMachine) {
        this.machine = transistorMachine;
    }

    /**
     * This method updates the target temperature of the machine (by using machine's setter).
     * It checks if the input value is between the min. and the max. temperature of the machine,
     * and throws a FactoryException otherwise.
     */
    public void setTargetTemperature(int targetTemperature) {

        if (targetTemperature >= machine.getMinTemperature() && targetTemperature <= machine.getMaxTemperature()) {
            machine.setTargetTemperature(targetTemperature);
        } else {
            throw new FactoryException("out of bounds");
        }

        /**
         * 1. TODO: Implement this function by checking, if the passed targetTemperature is in the range denoted \
         *          by the machine's min- and max-temperature. If in range, set the machines target temperature, \
         *          if not throw a new Factory Exception
         */
    }

    /**
     * This method updates the target voltage of the machine (by using machine's setter).
     * It checks if the input value is between the min. and the max. voltage of the machine,
     * and throws a FactoryException otherwise.
     */
    public void setTargetVoltage(int targetVoltage) {
        if (targetVoltage >= machine.getMinVoltage() && targetVoltage <= machine.getMaxVoltage()) {
            machine.setTargetVoltage(targetVoltage);
        } else {
            throw new FactoryException("out of bounds");
        }

        /**
         * 2. TODO: Implement this function by checking, if the passed targetVoltage is in the range denoted \
         *          by the machine's min- and max-temperature. If in range, set the machines target voltage, \
         *          if not throw a new Factory Exception
         */
    }

    /**
     * This method sets the transistor size of the transistor machine (by using machine's setter).
     * It checks if the input value is reasonable (between 7nm and 22nm),
     * and throws a FactoryException otherwise.
     */
    public void setTransistorSize(int transistorSize) {
        if (transistorSize >= MIN_TRANSISTOR_SIZE && transistorSize <= MAX_TRANSISTOR_SIZE) {
            machine.setTransistorSize(transistorSize);
        } else {
            throw new FactoryException("out of bounds");
        }
        /**
         * 3. TODO: Implement this function by checking, if the passed transistorSize is in the range [7, 22] \
         *          If in range, set the machines target transistorSize , if not throw a new Factory Exception
         */
    }

    /**
     * This method sets the transistor type of the transistor machine (by using machine's setter).
     */
    public void setTransistorType(TransistorType transistorType) {
        machine.setTransistorType(transistorType);
    }

    /**
     * This method sets the gate type of the transistor machine (by using machine's setter).
     */
    public void setGateType(GateType gateType) {
        machine.setGateType(gateType);
    }
}
