package de.tum.in.ase.eist;

public class ThermoAdapter implements ThermoInterface {
    private final FahrenheitThermo thermo = new FahrenheitThermo();

    @Override
    public double getTempC() {
         double result = thermo.getFahrenheitTemperature();
         return (result - 32.0) * 5.0 / 9.0;
    }



}
